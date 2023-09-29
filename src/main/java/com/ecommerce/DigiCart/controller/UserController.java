package com.ecommerce.DigiCart.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.DigiCart.model.User;
import com.ecommerce.DigiCart.service.UserService;
import com.ecommerce.DigiCart.utils.Payment;
import com.ecommerce.DigiCart.utils.Response;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//This method is to Check the application Working or Not
	@RequestMapping("/healthcheck")
	public String healthCheck() {
		System.out.println();
		System.out.println("----Health Check Successfull----");
		return "App Is Running...!";
	}
	
	//Inserting Data into DataBase
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User user) {
		
		System.out.println("Product Added Successfully.!");
//		System.out.println("email : "+user.getEmail());
		boolean result = userService.register(user);

		if(result == true) {
		Response response=new Response();
			response.setMessage("Registered Successfully");
			response.setOperationStatus("Success");
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		}
		else {
			Response response=new Response();
			response.setMessage("Registration Failed!");
			response.setOperationStatus("Failed");
			return new ResponseEntity<Object> (response,HttpStatus.BAD_REQUEST);
		}
	}
	//Here we  are checking for the user credentials That is the user_name & password check 
	
	@PostMapping("/logIn")
	public ResponseEntity<Object> logIn(@RequestBody User user){
		
		boolean result=userService.logIn(user);
		
		if(result==true) {
			Response response=new Response();
			response.setMessage("LogIn Successfull..!");
			response.setOperationStatus("Successfull..!");
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		}
		else {
			Response response=new Response();
			response.setMessage("LogIn Failed!");
			response.setOperationStatus("Failed");
			return new ResponseEntity<Object> (response,HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/createOrder")
	public ResponseEntity<Object> createOrder(@RequestBody Payment payment) throws RazorpayException{
		
		RazorpayClient client=new RazorpayClient("rzp_test_S17s3lNasUe0wO","drVcjTjnxI2o7JxrexwqCSlN");
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("amount", payment.getAmount());
		jsonObject.put("currency", payment.getCurrency());
		//jsonObject.put("reciept", payment.getReciept());
		Order order = client.orders.create(jsonObject);
		Response response=new Response();
		response.setMessage(order.get("id"));
		response.setOperationStatus("Order Created");
		return new ResponseEntity<Object>(response,HttpStatus.CREATED);
	}
}
