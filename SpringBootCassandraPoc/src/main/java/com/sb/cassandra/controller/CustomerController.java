package com.sb.cassandra.controller;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sb.cassandra.entity.Customer;
import com.sb.cassandra.service.CustomerService;

@RestController
//@CrossOrigin(orgin="*")
@RequestMapping("/cassandra")
public class CustomerController 
{
	
	@Autowired
	private CustomerService customerService;
	
     @PostMapping(value ="/saveCustomer")
	public ResponseEntity<Object> SaveCustomer(@Valid @RequestBody Customer customer) throws InterruptedException
	{
    	 
    	return customerService.saveCustomer(customer);
    	 
	}
     
     @GetMapping(value ="/fetchCustomerById/{id}")
     public ResponseEntity<Customer> fetchById(@PathVariable("id") long customerNo) throws Exception
     {
    	 return customerService.fetchById(customerNo);
     }
     
     @DeleteMapping("/deleteCustomerById/{id}")
     public ResponseEntity<Object> deleteCustomerById(@PathVariable long id)
    	{
    	return customerService.deleteCustomerById(id);
    	
     }
   
     @PutMapping("/updateCustomerById/{id}")
     public ResponseEntity<Object> updateCustomerById(@PathVariable long id,@Valid @RequestBody Customer customer)
     {
    	 return customerService.updateCustomerById(id,customer);
     }
     
     @GetMapping("/customers")
     public List<Customer> fetchAllCustomers()
     {
    	 return customerService.fetchAllCustomers();
     }
      
}
