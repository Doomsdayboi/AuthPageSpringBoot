package com.example.Authpage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController 
{	
	@Autowired
	private AuthService authService;
	
	@RequestMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return authService.getAllUsers();
	}
	
	@PostMapping("/signup")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> signup (@RequestBody User user)
	{
		return authService.signup(user);
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> login (@RequestBody User user)
	{
		return authService.login(user);
	}
	
	@DeleteMapping("/deleteUser/{username}")
	public void deleteUser(@PathVariable String username)
	{
		authService.deleteUser(username);
	}
}