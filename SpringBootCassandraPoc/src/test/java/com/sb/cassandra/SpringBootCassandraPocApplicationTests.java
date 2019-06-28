package com.sb.cassandra;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sb.cassandra.controller.CustomerController;
import com.sb.cassandra.entity.Customer;
import com.sb.cassandra.service.CustomerService;
//@ContextConfiguration(classes= {CustomerController.class,Customer.class,CustomerService.class,CassandraRepository.class})
@RunWith(SpringRunner.class)
@WebMvcTest
//@SpringBootTest(classes = SpringBootCassandraPocApplication.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootCassandraPocApplicationTests {
	
	/*
	 * @Autowired MockMvc mockMvc;
	 * 
	 * @MockBean CustomerService customerService;
	 */
	
//	@MockBean
//	Customer customer;
//	
//	@Before public void customerSetUp() {
//		customer.setName("Sachin"); customer.setContactNo("9988998899");
	
//	}
//	@Ignore 
//	@Test
//	public void contextLoads() throws Exception{
//		
//		ResponseEntity R = new ResponseEntity(HttpStatus.OK);
//		
//		Mockito.when(customerService.saveCustomer(customer)).thenReturn(R);
//		
//		
//		
//		MvcResult mvcResult=mockMvc.perform(
//				MockMvcRequestBuilders.get("/cassandra/save").
//				accept(MediaType.APPLICATION_JSON)).andReturn();
//		
//		
//		System.out.println(mvcResult.getResponse());
//		
//		Mockito.verify(customerService).saveCustomer(customer);
//	}
//	
	
	
	
	
//	  @Autowired CustomerController customerController;
//	  
//	  @Autowired Customer customer;
//	  
//	  @Before public void setup(){ MockitoAnnotations.initMocks(this); }
//	  
//	  @Before public void customerSetUp() {
//	  
//	  customer.setName("Sachin"); customer.setContactNo("9988998899");
//	  
//	  }
//	  @Ignore
//	  @Test public void fetchByIDTest() throws Exception { ResponseEntity<Customer>
//	  custTest=customerController.fetchById(34); Customer
//	  customer1=custTest.getBody();
//	  
//	  assertEquals("hyd",customer1.getName());
//	  assertEquals(34,customer1.getContactNo()); }
//	 
	/*
	 * @Test public void save() {
	 * 
	 * }
	 */

}
