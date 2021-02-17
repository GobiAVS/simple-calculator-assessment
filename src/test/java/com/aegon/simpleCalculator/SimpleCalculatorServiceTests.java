package com.aegon.simpleCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.aegon.simpleCalculator.model.SimpleCalculatorModel;
import com.aegon.simpleCalculator.repository.SimpleCalculatorRepository;
import com.aegon.simpleCalculator.service.SimpleCalculatorService;



@SpringBootTest
class SimpleCalculatorServiceTests {

	
	@InjectMocks
	private SimpleCalculatorService service;
	
	@Mock 
	private SimpleCalculatorRepository repository;
		
	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
	}

	@Test
    public void testSimpleCalculatorAdd() {
		when(repository.save(Mockito.any())).thenReturn(new SimpleCalculatorModel());
		assertThat((double)75).isEqualTo(service.add(50 ,25));		
    }
	
	@Test
    public void testSimpleCalculatorSubtract() {
		when(repository.save(Mockito.any())).thenReturn(new SimpleCalculatorModel());
		assertThat((double)25).isEqualTo(service.subtract(50 ,25));
    }
	
	@Test
    public void testSimpleCalculatorMultiply() {
		when(repository.save(Mockito.any())).thenReturn(new SimpleCalculatorModel());
		assertThat((double)1250).isEqualTo(service.multiply(50 ,25));
    }
	
	@Test
    public void testSimpleCalculatorDivide() {
		when(repository.save(Mockito.any())).thenReturn(new SimpleCalculatorModel());
		assertThat((double)2).isEqualTo(service.divide(50 ,25));
    }
	
	
}
