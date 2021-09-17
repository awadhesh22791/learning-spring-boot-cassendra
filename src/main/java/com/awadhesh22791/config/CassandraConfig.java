package com.awadhesh22791.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.EnableReactiveCassandraAuditing;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
@Configuration
@EnableReactiveCassandraRepositories("com.awadhesh22791.repository")
@EnableReactiveCassandraAuditing
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keyspace;
	
	@Override
	protected String getKeyspaceName() {
		return keyspace;
	}

}
