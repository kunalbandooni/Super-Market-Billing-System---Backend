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

import com.wissen.supermarket.inventory.Inventory;
import com.wissen.supermarket.services.InventoryService;

@RestController
@RequestMapping(value="/api/data/inventory")
public class Controller {

	@Autowired
	InventoryService inventoryService;

	// get all products
	@GetMapping(path="/getInventory")
	List<Inventory> getAllInventory(){
		List<Inventory> productList = inventoryService.getAllInventory();
		if(productList.size() == 0)
			return productList;		// change this
		else
			return productList;
	}
	
	// get product by id
	@GetMapping(path="/getInventory/{id}")
	Inventory getProduct(@PathVariable String id) {
		Optional<Inventory> prodObjOptional = inventoryService.getProductById(id);
		if(prodObjOptional.isPresent()){
			Inventory prodObj = prodObjOptional.get();
			return prodObj;
		}
		return new Inventory();
	}
	
	// update Inventory
	@PutMapping(path="/updateInventory/{check}")
	String updateInventory(@RequestBody Inventory prodObj, @PathVariable boolean check) {		
		return inventoryService.updateInventory(prodObj, check);
	}

	// remove a product
	@DeleteMapping(path="/removeProduct/{productId}")
	public String removeProduct(@PathVariable String productId) {
		return inventoryService.removeProduct(productId);
	}
	
	// create a new product
	@PostMapping(path="/addProduct")
	String addProduct(@RequestBody Inventory invObj) {
		inventoryService.addProduct(invObj);
		return "Product Added Successfully";
	}
}