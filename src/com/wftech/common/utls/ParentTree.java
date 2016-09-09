package com.wftech.common.utls;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Daoliang Li
 *
 */
public abstract class ParentTree extends Tree{

	protected Tree parent;
	
	public Tree getParent() {
		return parent;
	}
	public void setParent(Tree parent) {
		this.parent = parent;
	}
	
	abstract public Object getParentValue();
	
	abstract public JSONObject execute(int i);
	
	abstract public int getType();
	
}
