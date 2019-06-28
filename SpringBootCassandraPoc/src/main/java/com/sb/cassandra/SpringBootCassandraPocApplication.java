package com.sb.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
@ComponentScan(basePackages ="com.sb.cassandra")
@EnableCassandraRepositories
@EntityScan(basePackages = "com.sb.cassandra")
@SpringBootApplication
public class SpringBootCassandraPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCassandraPocApplication.class, args);
	}

}
