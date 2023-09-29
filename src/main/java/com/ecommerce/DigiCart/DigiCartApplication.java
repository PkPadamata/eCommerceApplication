/* 
 *  
 *   
 *   Spring Boot Project   
 * E-Commerce Application  
 * 
 * 
 */

package com.ecommerce.DigiCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages={"com.ecommerce.DigiCart.model"})
@ComponentScan(basePackages={"com.ecommerce.DigiCart"})
@SpringBootApplication
public class DigiCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigiCartApplication.class, args);
	} 
						 	
}
