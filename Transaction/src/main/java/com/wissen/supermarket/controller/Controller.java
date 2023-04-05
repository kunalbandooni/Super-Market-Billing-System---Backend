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

import com.wissen.supermarket.transaction.Transaction;
import com.wissen.supermarket.services.TransactionService;

@RestController
@RequestMapping(value="/api/data/transaction")
public class Controller {

	@Autowired
	TransactionService transactionService;

	// get all transactions
	@GetMapping(path="/getTransaction")
	List<Transaction> getTransaction(){
		List<Transaction> transactionList = transactionService.getAllTransaction();
		if(transactionList.size() == 0)
			return transactionList;		// change this
		else
			return transactionList;
	}

	// get transaction by id
	@GetMapping(path="/getTransaction/{id}")
	Transaction getTransaction(@PathVariable String id) {
		Optional<Transaction> transactionObjOptional = transactionService.getTransactionById(id);
		if(transactionObjOptional.isPresent()){
			Transaction transactionObj = transactionObjOptional.get();
			return transactionObj;
		}
		return new Transaction();
	}

	//get transaction by customer id
	@GetMapping(path="/getTransactionByCustomerId/{id}")
	List<Transaction> getTransactionByCustomerId(@PathVariable long id) {
		List<Transaction> transactionObjOptional = transactionService.getTransactionByCustomerId(id);
		
		return transactionObjOptional;
	}

	// create transaction
	@PostMapping(path="/addTransaction")
	void addTransaction(@RequestBody Transaction transaction) {
		System.out.println("here");
		transactionService.addTransaction(transaction);
	}
}