package com.cassandra.bd.CassandraTeste.repository;


import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cassandra.bd.CassandraTeste.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveCrudRepository<Person, String> {
	
	Flux<Person> findByLastname(String lastname);
	
	@Query("{ 'firstname': ?0, 'lastname': ?1}")
	Mono<Person> findByFirstnameAndLastname(String firstname, String lastname);
	
	Mono<Person> findByFirstnameAndLastname(Mono<String> firstname, String lastname);

	
	

}
