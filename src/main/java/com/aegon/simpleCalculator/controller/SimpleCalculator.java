package com.aegon.simpleCalculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aegon.simpleCalculator.service.SimpleCalculatorService;

 
@Controller
public class SimpleCalculator {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleCalculator.class);	
	
 
    @Autowired
    private SimpleCalculatorService simpleCalculatorService;
 
	/**
	*The code to direct welcome page
	 */
    @RequestMapping({"", "/", "welcome"})
	public String simpleCalculator(Model model) {
		model.addAttribute("name", "Simple Calculator");
		return "welcome";
	}
 
	/**
	*The code to get input from UI and direct to suitable method for calculate
	 */
	@PostMapping("/calculate")
    public String calculate(@RequestParam("sourceOne") int sourceOne, @RequestParam("sourceTwo") int sourceTwo,
	@RequestParam("action") String operation, Model model) {
		logger.info("calculate::"+sourceOne+"  "+sourceTwo+"  "+operation);
		double result=0;
		if("ADD".equalsIgnoreCase(operation)){
			result = add(sourceOne, sourceTwo);
			model.addAttribute("resultPage", "Addition of "+sourceOne+" and "+sourceTwo+" is ");
		} else if("SUBTRACT".equalsIgnoreCase(operation)){
			result = subtract(sourceOne, sourceTwo);
			model.addAttribute("resultPage", "Subtraction of "+sourceOne+" and "+sourceTwo+" is ");
		} else if("MULTIPLY".equalsIgnoreCase(operation)){
			result = multiply(sourceOne, sourceTwo);
			model.addAttribute("resultPage", "Multiplication of "+sourceOne+" and "+sourceTwo+" is ");
		} else {
			result = divide(sourceOne, sourceTwo);
			model.addAttribute("resultPage", "Divison of "+sourceOne+" and "+sourceTwo+" is ");
		}  
		model.addAttribute("name", "Simple Calculator");
		model.addAttribute("result", result);
		model.addAttribute("getAllCalculations", simpleCalculatorService.getAllCalculations());
		return "result";
    }
	
	/**
	*The code to calculate addition of two numbers
	 */
    public double add(int sourceOne, int sourceTwo) {
        logger.info("add::"+sourceOne+"  "+sourceTwo);
		return simpleCalculatorService.add(sourceOne, sourceTwo);
    }
 
	/**
	*The code to calculate subtraction of two numbers
	 */
    public double subtract(int sourceOne, int sourceTwo) {
		logger.info("subtract::"+sourceOne+"  "+sourceTwo);
        return simpleCalculatorService.subtract(sourceOne, sourceTwo);
    }
	
	/**
	*The code to calculate multiplication of two numbers
	 */
    public double multiply(int sourceOne, int sourceTwo) {
		logger.info("multiply::"+sourceOne+"  "+sourceTwo);
        return simpleCalculatorService.multiply(sourceOne, sourceTwo);
    }
	
	/**
	**The code to calculate multiplication of two numbers
	 */
    public double divide(int sourceOne, int sourceTwo) {
		logger.info("divide::"+sourceOne+"  "+sourceTwo);
        return simpleCalculatorService.divide(sourceOne, sourceTwo);
    }
}
