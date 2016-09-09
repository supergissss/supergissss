package com.wftech.common;

import javax.jws.WebService;

import com.wftech.domain.common.Calculator;


/**
 * @author ws
 *
 */
@WebService
public class CalculateService implements ICalculateService{
	@Override
	public Calculator calculate(double a, double b) {
		// TODO Auto-generated method stub
		Calculator result = new Calculator();
		result.setPlus(a+b);
		result.setMinus(a-b);
		return result;
	}
	
	@Override
	public Calculator back(Calculator ca) {
		// TODO Auto-generated method stub
		return ca;
	}
}
