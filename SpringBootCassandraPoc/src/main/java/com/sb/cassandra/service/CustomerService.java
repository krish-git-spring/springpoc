package com.sb.cassandra.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.cassandra.entity.Customer;
import com.sb.cassandra.exception.RecordNotFoundException;
import com.sb.cassandra.repository.CassandraRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class CustomerService {

	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	@Autowired
	private CassandraRepository cassandraRepository;
	
	public ResponseEntity<Object> saveCustomer(Customer customer) {
		customer.setId(Timestamp.valueOf(LocalDateTime.now()).getTime());
		Customer returnEntity= cassandraRepository.save(customer);
		if((customer.getName()).equals(returnEntity.getName())&&(customer.getContactNo()).equals(returnEntity.getContactNo())) {
			logger.info("Inserted data successfuly");
			return new ResponseEntity<>(returnEntity,HttpStatus.OK);
			
		}
		logger.error("Data not inserted in to DB, DB not available or down");
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	public ResponseEntity<Customer> fetchById(long customerNo){

		logger.info("Fetch customer by Id---->"+customerNo);

		Optional<Customer> customerInfo=cassandraRepository.findById(customerNo);

		if(!customerInfo.isPresent())
		{
			logger.info("Customer with given id does not exist");
			throw new RecordNotFoundException("Record is not available with id--"+customerNo);

		}
			logger.info("Customer with given id does exist");
   	 return new ResponseEntity<Customer>(customerInfo.get(),HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteCustomerById(long id)
	{
		logger.info("-----Delete Customer-----"+id);
		Optional<Customer> customer=cassandraRepository.findById(id);
		if(!customer.isPresent())
		{
			throw new RecordNotFoundException("Record is not available to delete with id--"+id);    	
		}

		cassandraRepository.deleteById(id);
		return new ResponseEntity<Object>("Record Deleted Successfully",HttpStatus.OK);

	}

	public ResponseEntity<Object> updateCustomerById(long id, Customer customer){
		logger.info("-----Update Customer-----"+id);

		Optional<Customer> customerInfo=cassandraRepository.findById(id);
		if(!customerInfo.isPresent())
		{
			throw new RecordNotFoundException("Record is not available to Update with id--"+id);
		}
		customer.setId(id);
		cassandraRepository.save(customer);
		return new ResponseEntity<Object>(customer,HttpStatus.OK);

	}

	 public List<Customer> fetchAllCustomers()
     {
    	 List<Customer> customers=null;
    	 customers=new ArrayList<Customer>();
    	  cassandraRepository.findAll().forEach(customers::add);
    	  logger.info("Total Customers " +customers.size());
    	  return customers;
     }
		
}
