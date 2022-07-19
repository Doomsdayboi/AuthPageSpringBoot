package com.example.Authpage;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService 
{
	@Autowired
	private AuthRepo authRepo;	
	
	public List<User> getAllUsers()
	{
		return authRepo.findAll();
	}

	public void deleteUser(String username) 
	{	
		User user = authRepo.findbyusername(username);
		log.info("Inside deleteUser {}", username);
		authRepo.delete(user);
	}

	public ResponseEntity<String> signup(User user) 
	{
		log.info("Inside singup {}", user);
		User user1 = authRepo.findbyusername(user.getUsername());
		if(Objects.isNull(user1))
		{
			authRepo.save(user);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
		}		
	}

	public ResponseEntity<String> login(User user) 
	{
		log.info("Inside login {}", user);
		User user1 = authRepo.findbyusername(user.getUsername());
		if(!Objects.isNull(user1))
		{
			if(user1.getPassword().equals(user.getPassword()))
			{
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
			else
				return new ResponseEntity<>("Wrong password", HttpStatus.BAD_REQUEST);
		}
		else 
		{
			return new ResponseEntity<>("This user does not exist", HttpStatus.BAD_REQUEST);
		}		
	}

}
