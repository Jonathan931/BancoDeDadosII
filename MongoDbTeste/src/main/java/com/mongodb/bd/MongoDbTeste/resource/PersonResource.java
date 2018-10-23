package com.mongodb.bd.MongoDbTeste.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.bd.MongoDbTeste.model.Person;
import com.mongodb.bd.MongoDbTeste.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/person")
public class PersonResource {
	
	@Autowired
	private PersonRepository persons;
	
	@GetMapping
	public Flux<Person> buscarTodos(){
		return persons.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Person> criar( @RequestBody Person person){
		return persons.save(person);
	}

}
