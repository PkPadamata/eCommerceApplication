package com.ecommerce.DigiCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.DigiCart.model.Product;
import com.ecommerce.DigiCart.service.ProductService;
import com.ecommerce.DigiCart.utils.Response;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Object> add(@RequestBody Product product){
		boolean result=productService.add(product);
		if(result==true) {
			Response response =new Response();
			response.setMessage("Product Added SuccessFully");
			response.setOperationStatus("Successfull...!");
			return new ResponseEntity<Object> (response,HttpStatus.OK);
		}
		else {
			Response response =new Response();
			response.setMessage("Product Add Failed..!");
			response.setOperationStatus("Failed...!");
			return new ResponseEntity<Object> (response,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Object> delete(@RequestBody Product product){
		boolean result=productService.delete(product);
		if(result==true) {
			Response response =new Response();
			response.setMessage("Product Delete SuccessFully");
			response.setOperationStatus("Successfull...!");
			return new ResponseEntity<Object> (response,HttpStatus.OK);
		}
		else {
			Response response =new Response();
			response.setMessage("Product Delete Failed..!");
			response.setOperationStatus("Failed...!");
			return new ResponseEntity<Object> (response,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/list")
	public ResponseEntity<Object> list(){
		List<Product> list=productService.list();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
		
	}

}
