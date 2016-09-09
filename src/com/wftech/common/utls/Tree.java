package com.wftech.common.utls;
/**
 * @author Daoliang Li
 *
 */
public abstract class Tree {

	protected Tree firstChild;
	protected Tree nextSibling;
	
	abstract public Object getValue() ;
	abstract public void setValue(Object value);
	
	public Tree getFirstChild() {
		return firstChild;
	}
	public void setFirstChild(Tree firstChild) {
		this.firstChild = firstChild;
	}
	public Tree getNextSibling() {
		return nextSibling;
	}
	public void setNextSibling(Tree nextSibling) {
		this.nextSibling = nextSibling;
	}
	
	
}
