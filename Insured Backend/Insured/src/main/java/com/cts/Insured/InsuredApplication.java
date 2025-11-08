package com.cts.Insured;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cts.Insured.Entities.ClaimDetails;
import com.cts.Insured.Repositories.ClaimDetailsRepo;
import com.cts.Insured.Service.ClaimDetailsService;

@SpringBootApplication
public class InsuredApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(InsuredApplication.class, args);
		
		ClaimDetailsRepo repo = context.getBean(ClaimDetailsRepo.class);
		
	
	    
	}

}
