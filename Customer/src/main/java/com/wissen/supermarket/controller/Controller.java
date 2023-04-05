package com.wissen.supermarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.supermarket.customer.Customer;
import com.wissen.supermarket.employee.Employee;
import com.wissen.supermarket.inventory.Inventory;
import com.wissen.supermarket.services.CustomerService;
import com.wissen.supermarket.services.EmployeeService;
import com.wissen.supermarket.services.InventoryService;
import com.wissen.supermarket.services.TransactionService;
import com.wissen.supermarket.transaction.Transaction;

@RestController
@RequestMapping(value="/api/data/customer")
public class Controller {

	@Autowired
	CustomerService customerService;

	// get all customer
	@GetMapping(path="/getCustomer")
	List<Customer> getCustomer(){
		List<Customer> customerList = customerService.getAllCustomer();
		if(customerList.size() == 0)
			return customerList;		// change this
		else
			return customerList;
	}

	// create customer
	@PostMapping(path="/addCustomer")
	String addCustomer(@RequestBody Customer customer) {
		Optional<Customer>checkCustomer=customerService.getCustomerById(customer.getPhoneNumber());
		if(checkCustomer.isPresent()){
			return "Already present in database";
		}
		customerService.addCustomer(customer);
		return "Customer Inserted Successfully";
	}
}