package com.wftech.common.utls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.wftech.domain.common.Permission;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Daoliang Li
 *
 */
public class TreeUtils {

	public static JSONObject travesalParentTree(ParentTree nowTree,List<ParentTree> list){
		JSONObject nowObj = nowTree.execute(0);
		JSONArray array = null;
		if(nowTree.getType()==2&&!nowTree.getParentValue().equals("-1")){
			array = new JSONArray();
			JSONObject  obj = new JSONObject();
			obj.put("id",((Permission)(nowTree.getValue())).getPerm());
			obj.put("text","ทรฮส");
			obj.put("name", "permid");
			obj.put("value", ((Permission)(nowTree.getValue())).getPermid());
			obj.put("showcheck", true);
			obj.put("complete",true);
			obj.put("isexpand", true);
			obj.put("checkstate", 0);
			obj.put("hasChildren", false);
			array.add(obj);
		}
		for(ParentTree tree:list){
			if(((Permission)(nowTree.getValue())).getPerm().equals(tree.getParentValue())){
				
				if(array==null){
					array = new JSONArray();
					array.add(travesalParentTree(tree,list));
				}else{
					array.add(travesalParentTree(tree,list));
	//			      "hasChildren" : true,
	//			      "ChildNodes" : subarr
				}
			}
		}
		if(array==null){
			nowObj.put("hasChildren", false);
		}else{
			nowObj.put("hasChildren", true);
			nowObj.put("ChildNodes", array);
		}
		return nowObj;
	}
	
	public static JSONObject travesalParentTree(ParentTree nowTree,Set<ParentTree> set, List<ParentTree> list){
		JSONObject nowObj = null;
		int i;
		if(set.contains(nowTree)&&nowTree.getType()==1){
			i = 1;
		}else if(set.contains(nowTree)&&nowTree.getType()==2){
			i = 2;
		}else{
			i = 0;
		}
		
		JSONArray array = null;
		int special = -1;
		if(nowTree.getType()==2&&!nowTree.getParentValue().equals("-1")){
			array = new JSONArray();
			JSONObject  obj = new JSONObject();
			obj.put("id",((Permission)(nowTree.getValue())).getPerm());
			obj.put("text","ทรฮส");
			obj.put("name", "permid");
			obj.put("value", ((Permission)(nowTree.getValue())).getPermid());
			obj.put("showcheck", true);
			obj.put("complete",true);
			obj.put("isexpand", true);
			if(i!=0){
				obj.put("checkstate", 1);
				i = 1;
			}
			obj.put("hasChildren", false);
			array.add(obj);
			special = i;
		}
		int countChecked = 0,countUnChecked = 0,count = 0;
		for(ParentTree tree:list){
			if(((Permission)(nowTree.getValue())).getPerm().equals(tree.getParentValue())){
				JSONObject jsonObj = null;
				if(array==null){
					array = new JSONArray();
					 jsonObj = travesalParentTree(tree,set,list);
					array.add(jsonObj);
					
				}else{
					jsonObj = travesalParentTree(tree,set,list);
					array.add(jsonObj);
	//			      "hasChildren" : true,
	//			      "ChildNodes" : subarr
				}
				if(jsonObj.getString("isChecked")!=null){
					if(jsonObj.getString("isChecked").equals("1")){
						countChecked++;
					}else if(jsonObj.getString("isChecked").equals("0")){
						countUnChecked++;
					}
				}
				count++;
			}
		}
		if(nowTree.getType()==1){
			nowObj = nowTree.execute(i);
		}else{
			if(countChecked==count&&(special==-1||special==1)){
				nowObj = nowTree.execute(1);
				i = 1;
			}else if(countUnChecked==count&&(special==-1||special==0)){
				nowObj = nowTree.execute(0);
				i = 0;
			}else{
				nowObj = nowTree.execute(2);
				i = 2;
			}
		}
		if(array==null){
			nowObj.put("hasChildren", false);
			nowObj.put("isChecked", i);
		}else{
			nowObj.put("hasChildren", true);
			nowObj.put("ChildNodes", array);
			nowObj.put("isChecked", i);
		}
		return nowObj;
	}
}
