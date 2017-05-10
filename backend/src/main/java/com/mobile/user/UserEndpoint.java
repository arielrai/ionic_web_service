package com.mobile.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserEndpoint {

	private List<User> usuariosCadastrados = new ArrayList<>();
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user){
		usuariosCadastrados.add(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> carregaUsuarios(){
		return new ResponseEntity<>(usuariosCadastrados, HttpStatus.OK);
	}
}
