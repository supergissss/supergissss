package com.wftech.common;

import com.wftech.domain.common.Calculator;

/**
 * @author ws
 *
 */
public interface ICalculateService {
	Calculator calculate(double a,double b);
	
	Calculator back(Calculator ca);
}
