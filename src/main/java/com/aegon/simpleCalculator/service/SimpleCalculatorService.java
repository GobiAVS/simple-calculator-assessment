package com.aegon.simpleCalculator.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.simpleCalculator.model.SimpleCalculatorModel;
import com.aegon.simpleCalculator.repository.SimpleCalculatorRepository;
 
@Service
public class SimpleCalculatorService {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleCalculatorService.class);
 
    @Autowired
    private SimpleCalculatorRepository simpleCalculatorRepository;	
   
	/**
	*The code to calculate addition of two numbers
	 */
    public double add(final int sourceOne, final int sourceTwo) {
		SimpleCalculatorModel simpleCalculatorModel = buildSimpleCalculatorModel(sourceOne, sourceTwo, "Add");
		simpleCalculatorModel.setResult(Double.valueOf(sourceOne + sourceTwo));
        simpleCalculatorRepository.save(simpleCalculatorModel);
		return simpleCalculatorModel.getResult();
    }
	
	/**
	*The code to calculate subtraction of two numbers
	 */
    public double subtract(final int sourceOne, final int sourceTwo) {
        SimpleCalculatorModel simpleCalculatorModel = buildSimpleCalculatorModel(sourceOne, sourceTwo, "Subtract");
		simpleCalculatorModel.setResult(Double.valueOf(sourceOne - sourceTwo));
        simpleCalculatorRepository.save(simpleCalculatorModel);
		return simpleCalculatorModel.getResult();
    }
	
	/**
	*The code to calculate multiplication of two numbers
	 */
    public double multiply(final int sourceOne, final int sourceTwo) {
        SimpleCalculatorModel simpleCalculatorModel = buildSimpleCalculatorModel(sourceOne, sourceTwo, "Multiply");
		simpleCalculatorModel.setResult(Double.valueOf(sourceOne * sourceTwo));
        simpleCalculatorRepository.save(simpleCalculatorModel);
		return simpleCalculatorModel.getResult();
    }
	
	/**
	**The code to calculate multiplication of two numbers
	 */
    public double divide(final int sourceOne, final int sourceTwo) {
        SimpleCalculatorModel simpleCalculatorModel = buildSimpleCalculatorModel(sourceOne, sourceTwo, "Divide");
		try{
			simpleCalculatorModel.setResult(Double.valueOf(sourceOne / sourceTwo));
			simpleCalculatorRepository.save(simpleCalculatorModel);
		} catch (ArithmeticException e) {
			logger.info(e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw e;
		}        
		return simpleCalculatorModel.getResult();
    }

	/**
	**The code to get all saved entries
	 */
    public List<SimpleCalculatorModel> getAllCalculations() {   
		List<SimpleCalculatorModel> simpleCalculatorModelList = new ArrayList<SimpleCalculatorModel>();
		simpleCalculatorRepository.findAll().forEach(simpleCalculatorModelList::add);;
		return simpleCalculatorModelList;
    }
	
	public SimpleCalculatorModel buildSimpleCalculatorModel(final int sourceOne, final int sourceTwo, final String operation){
		SimpleCalculatorModel simpleCalculatorModel = new SimpleCalculatorModel();
		simpleCalculatorModel.setSourceOne(sourceOne);
		simpleCalculatorModel.setSourceTwo(sourceTwo);
		simpleCalculatorModel.setOperation(operation);
		return simpleCalculatorModel;
	}

}
