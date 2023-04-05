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
@RequestMapping(value="/api/data/employee")
public class Controller {
	@Autowired
	EmployeeService employeeService;
	// get all employee
	@GetMapping(path="/getEmployee")
	List<Employee> getEmployee(){
		List<Employee> employeeList = employeeService.getAllEmployee();
		if(employeeList.size() == 0)
			return employeeList;		// change this
		else
			return employeeList;
	}

	// create a new employee
	@PostMapping(path="/addEmployee")
	String addEmployee(@RequestBody Employee cashier) {
		employeeService.addEmployee(cashier);
		return "Employee Inserted Successfully";
	}
	
	// remove an Employee
	@DeleteMapping(path="/removeEmployee/{empId}")
	public String removeEmployee(@PathVariable String empId) {
		return employeeService.removeEmployee(empId);
	}
	
	// update Employee Details
	@PutMapping(path="/updateEmployee")
	String updateEmployee(@RequestBody Employee cashier) {
		return employeeService.updateEmployee(cashier);
	}
}