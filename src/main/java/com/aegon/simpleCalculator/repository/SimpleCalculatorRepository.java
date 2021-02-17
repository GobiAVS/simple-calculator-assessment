package com.aegon.simpleCalculator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aegon.simpleCalculator.model.SimpleCalculatorModel;
 
@Repository
public interface SimpleCalculatorRepository extends CrudRepository<SimpleCalculatorModel, Long> {}
