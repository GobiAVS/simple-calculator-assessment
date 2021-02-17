package com.aegon.simpleCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aegon.simpleCalculator.controller.SimpleCalculator;

@SpringBootTest
class SimpleCalculatorApplicationTests {
	
	@Autowired
	private SimpleCalculator controller;
	
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	

	@Test
    public void testSimpleCalculatorAdd() {
		assertThat((double)75).isEqualTo(controller.add(50 ,25));
    }
	
	@Test
    public void testSimpleCalculatorSubtract() {
		assertThat((double)25).isEqualTo(controller.subtract(50 ,25));
    }
	
	@Test
    public void testSimpleCalculatorMultiply() {
		assertThat((double)1250).isEqualTo(controller.multiply(50 ,25));
    }
	
	@Test
    public void testSimpleCalculatorDivide() {
		assertThat((double)2).isEqualTo(controller.divide(50 ,25));
    }
	
}
