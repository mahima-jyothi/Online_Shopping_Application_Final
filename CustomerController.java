package com.cg.osa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.osa.dto.CustomerDTO;

import com.cg.osa.exception.CustomerException;
import com.cg.osa.service.ICustomerServiceImpl;

@RestController
@RequestMapping("/onlineshoppingapplication")
public class CustomerController {
	@Autowired
	ICustomerServiceImpl customerService;
	 
	/* @author G Nikhitha
	 * @return Customer
	 * @description this method add the customer if the customer is not present
	 */
	
	 @PostMapping("/addcustomer")
	 public CustomerDTO addCustomer(@Valid @RequestBody CustomerDTO cust) throws CustomerException {
	    	customerService.addCustomer(cust);
	    	return cust;
	    }
	 
	 /* @author G Nikhitha
		 * @return Customer
		 * @description this method update the customer details of the existing customer
		 */
	 
	 @PutMapping("/updatecustomer")
	 public CustomerDTO updateCustomer(@Valid @RequestBody CustomerDTO cust)throws CustomerException {
	    	customerService.updateCustomer(cust);
	    	return cust;
	    }
	 
	 /* @author G Nikhitha
		 * @return Customer list
		 * @description this method gives all customer details 
		 */
	 
	 @GetMapping("/getallcustomer")
	 public List<CustomerDTO> viewAllCustomer(){
		 List<CustomerDTO> cd=customerService.viewAllCustomer();
		 return cd;
     }
	 
	 /* @author G Nikhitha
		 * @return Customer
		 * @description this method gives customer details for specified customer id
		 */
	 @GetMapping("/getcustomerbyid/{id}")
	 public CustomerDTO viewCustomer(@PathVariable("id") int id)throws CustomerException{
		  return customerService.viewCustomer(id);
		 
     }
	 
	 /* @author G Nikhitha
		 * @return Customer list
		 * @description this method gives the customer details for specified city
		 */
	 @GetMapping("/getcustomer/{city}")
	 public List<CustomerDTO> viewAllCustomerByCity(@PathVariable("city") String city)throws CustomerException
	 {
		 List<CustomerDTO> cd=customerService.viewAllCustomerByCity(city);
		 return cd;
     }
	 
	 /* @author G Nikhitha
		 * @return Customer
		 * @description this method delete the existing customer 
		 */
	 
	 @DeleteMapping("/deletecustomer/{id}")
		public CustomerDTO removeCustomer(@PathVariable("id") int id) throws CustomerException
		{
			
			return customerService.removeCustomer(id);
		}
	 


}
