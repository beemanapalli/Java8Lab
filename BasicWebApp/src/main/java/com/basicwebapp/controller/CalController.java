package com.basicwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalController {

	@PostMapping("/cal")
	public long doCalculation(@RequestParam(name="number1") long number1,
			                  @RequestParam(name="number2") long number2) {
		
		
		long results=0;
		
		return results;
		
	}
	
}
