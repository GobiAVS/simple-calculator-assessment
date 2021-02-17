package com.aegon.simpleCalculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "SIMPLE_CALCULATOR")
public class SimpleCalculatorModel {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Integer sourceOne;
	private Integer sourceTwo;
	private String operation;
	private Double result;
	
	public SimpleCalculatorModel(){
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "sourceOne", nullable = false)
	public Integer getSourceOne() {
		return sourceOne;
    }
	public void setSourceOne(Integer sourceOne) {
		this.sourceOne = sourceOne;
    }
	@Column(name = "sourceTwo", nullable = false)
	public Integer getSourceTwo() {
		return sourceTwo;
    }
	public void setSourceTwo(Integer sourceTwo) {
		this.sourceTwo = sourceTwo;
    }
	@Column(name = "operation", nullable = false)
	public String getOperation() {
		return operation;
    }
	public void setOperation(String operation) {
		this.operation = operation;
    }
	@Column(name = "result", nullable = false)
	public Double getResult() {
		return result;
    }
	public void setResult(Double result) {
		this.result = result;
    }
	
	
}
