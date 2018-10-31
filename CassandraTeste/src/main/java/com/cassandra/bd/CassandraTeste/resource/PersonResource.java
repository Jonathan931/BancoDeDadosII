package com.cassandra.bd.CassandraTeste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cassandra.bd.CassandraTeste.model.Person;
import com.cassandra.bd.CassandraTeste.repository.PersonRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/person")
public class PersonResource {
	
	@Autowired
	private PersonRepository persons;
	
	@GetMapping
	public Flux<Person> buscarTodos(){
		long tempoInicio = System.currentTimeMillis();
		Flux<Person> pessoas = persons.findAll();
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
		return pessoas;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Flux<Person> criar( @RequestBody List<Person> person){
		long tempoInicio = System.currentTimeMillis();
		Flux<Person> pessoas = persons.saveAll(person);
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
		return pessoas;
	}
	
	@DeleteMapping
	public void deleteAll() {
		persons.deleteAll( persons.findAll());
	}

}
