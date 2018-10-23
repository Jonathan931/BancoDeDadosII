package com.mongodb.bd.MongoDbTeste.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

public class MongoReactiveConfig extends AbstractReactiveMongoConfiguration {
	
	@Value("${spring.data.mongodb.database}")
    private String database;

	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create();
	}
	
	@Override
	protected String getDatabaseName() {
		return this.database;
	}
	
	@Override
	public @Bean ReactiveMongoOperations reactiveMongoTemplate() throws Exception {
		return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
	}
}