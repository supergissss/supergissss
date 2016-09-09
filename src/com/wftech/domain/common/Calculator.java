package com.wftech.domain.common;

import java.io.Serializable;

/**
 * @author ws
 *
 */
public class Calculator implements Serializable{
	
	private static final long serialVersionUID = 677484458789332877L;

	private double plus;
	private double minus;
	
	public double getPlus() {
		return plus;
	}
	public void setPlus(double plus) {
		this.plus = plus;
	}
	public double getMinus() {
		return minus;
	}
	public void setMinus(double minus) {
		this.minus = minus;
	}
	
	
}
