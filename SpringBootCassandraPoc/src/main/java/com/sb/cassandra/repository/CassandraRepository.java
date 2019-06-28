package com.sb.cassandra.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.cassandra.entity.Customer;
@Repository
public interface CassandraRepository extends CrudRepository<Customer,Serializable>
{
	
    Optional<Customer> findById(Integer id);
   
}

