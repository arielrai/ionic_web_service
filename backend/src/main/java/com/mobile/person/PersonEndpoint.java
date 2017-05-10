package com.mobile.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonEndpoint {

	private List<Person> pessoasCadastrados = new ArrayList<>();
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> savePessoa(@RequestBody Person pessoa){
		pessoasCadastrados.add(pessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> carregaPessoas(){
		return new ResponseEntity<>(pessoasCadastrados, HttpStatus.OK);
	}
}
