package com.cassandra.bd.CassandraTeste.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;

@Configuration
public class CassandraConfigReactive extends AbstractReactiveCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		
		return "bdii";
	}
//    
//	@Value("${spring.data.cassandra.database}")
//    private String database;
//    
//	@Value("${spring.data.cassandra.host=localhost}")
//	private String conexao;
////	/*
////    * Provide a contact point to the configuration.
////    */
////    public String getContactPoints() {
////        return conexao;
////    }
//
//    /*
//     * Provide a keyspace name to the configuration.
//    */
//    public String getKeyspaceName() {
//        return database;
//    }
}
