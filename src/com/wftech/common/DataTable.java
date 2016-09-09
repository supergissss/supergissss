package com.wftech.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author ws
 *
 */
public class DataTable {
	
	private int start; //起始项的序列号
	private int length; //每页的长度
	
	

	public int getStart() {
		return start;
	}



	public void setStart(int start) {
		this.start = start;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	/**
	 *把数据包装成JSON数据发送给DataTable
	 * @author Daoliang Li
	 * @param request 服务器请求
	 * @param response 服务器响应
	 * @param columnName 列名
	 * @param value 列值
	 * @param recordsTotal 总项数
	 */
	public void getTable(HttpServletRequest request,HttpServletResponse response,String[] columnName,String[][] value,int recordsTotal){
		int i,j;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		int recordsFiltered = recordsTotal;
		
		String draw = request.getParameter("draw");
		JSONArray array = new JSONArray();
		JSONObject data = null;
		for(i=0;i<value.length;i++){
			data = new JSONObject();
			for(j=0;j<columnName.length;j++){
				data.put(columnName[j], value[i][j]);
			}
			array.add(data);
		}
		JSONObject json = new JSONObject();
		json.put("draw", draw);
		json.put("recordsTotal", recordsTotal);
		json.put("recordsFiltered", recordsFiltered);
		json.put("data",array);
		try{
			out = response.getWriter();
			out.write(json.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
}
