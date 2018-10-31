package com.cassandra.bd.CassandraTeste.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;

@Configuration
public class CassandraConfigReactive extends AbstractReactiveCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		
		return "bdii";
	}
}
