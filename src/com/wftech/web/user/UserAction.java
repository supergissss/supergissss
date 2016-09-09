package com.wftech.web.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.xml.ws.Response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wftech.common.DataTable;
import com.wftech.common.DataTableColumn;
import com.wftech.common.TableUtils;
import com.wftech.domain.common.Permission;
import com.wftech.domain.common.Role;
import com.wftech.service.common.IPermissionFacade;
import com.wftech.service.common.IRoleFacade;
import com.wftech.service.common.IUserFacade;

/**
 * @author Daoliang Li
 *
 */
@Controller
@RequestMapping("user")
public class UserAction {
	
	@Autowired
	IPermissionFacade permissionFacade;
	
	@Autowired
	IRoleFacade roleFacade;
	
	@Autowired
	IUserFacade userFacade;

	@RequestMapping("userlist")
	public String getUserList(HttpServletResponse response ,HttpServletRequest request){
		return "user/userlist";
	}
	
	@RequestMapping("rolelist")
	public String getRoleList(){
		return "user/rolelist";
	}
	
	@RequestMapping("getpermission")
	public @ResponseBody JSONObject getPermission(){
		return permissionFacade.getPermission();
	}
	
	@RequestMapping("getrolepermission")
	public @ResponseBody JSONObject getRolePermission(String roleid){
		return roleFacade.getRolePermission(roleid);
	}
	
	@RequestMapping("updaterolepermission")
	public @ResponseBody String updateRolePermission(Role role,String ids,HttpServletRequest request){
		roleFacade.deleteRolePermission(role.getRoleid());
		HttpSession session = request.getSession();
		String usernickname = (String)session.getAttribute("usernickname");
		List<Permission> list = new ArrayList<Permission>();
		String[] id = ids.split(",");
		Permission permission;
		for(int i=0;i<id.length;i++){
			permission = new Permission();
			permission.setPermid(id[i]);
			list.add(permission);
		}
		if(id.length==0){
			return "zero";
		}
		roleFacade.updateRolePermission(role.getRoleid(), list, usernickname);
		return "success";
		
	}
	
	@RequestMapping("addrolefill")
	public String addRoleFill(){
		return "user/addrolefill";
	}
	
	@RequestMapping("addrole")
	public @ResponseBody String addRole(Role role,String ids,HttpServletRequest request){
		HttpSession session = request.getSession();
		String usernickname = (String)session.getAttribute("usernickname");
		List<Permission> list = new ArrayList<Permission>();
		String[] id = ids.split(",");
		Permission permission;
		for(int i=0;i<id.length;i++){
			permission = new Permission();
			permission.setPermid(id[i]);
			list.add(permission);
		}
		boolean tag = false;
		if(id.length==0){
			return "zero";
		}
		tag = roleFacade.addRole(role.getRolename(), list, usernickname);
		if(tag){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping("getuserdata")
	public @ResponseBody JSONObject getUserData(int userid){
		JSONObject obj = userFacade.getUserData(userid);
		return obj;
	}
	
	@RequestMapping("getrolelist")
	public String getrolelist(DataTable dataTable,  HttpServletRequest request,HttpServletResponse response){
		String[] columnName = DataTableColumn.getColumn(TableUtils.ROLE, null);
		String[][] value = roleFacade.getRoleList(dataTable.getStart(),dataTable.getLength());
		int recordsTotal = roleFacade.getRoleNum();
		dataTable.getTable(request, response, columnName, value, recordsTotal);
		return null;
	}
	
	@RequestMapping("getuserlist")
	public String getUserList(DataTable dataTable, HttpServletRequest request, HttpServletResponse response){
		String[] columnName = DataTableColumn.getColumn(TableUtils.USER, null);
		String[][] value = userFacade.getUserList(dataTable.getStart(),dataTable.getLength());
		int recordsTotal = userFacade.getUserNum();
		dataTable.getTable(request, response, columnName, value, recordsTotal);
		return null;
	}
	
	@RequestMapping("deleterole")
	public @ResponseBody String deleteRole(String ids){
		String[] id = ids.split(",");
		StringBuffer buffer = new StringBuffer("");
		if(id.length!=0){
			for(int i=0;i<id.length;i++){
				if(!roleFacade.isRoleHasUser(id[i])){
					roleFacade.deleteRolePermission(id[i]);
					roleFacade.deleteRole(id[i]);
				}else{
					String rolename = roleFacade.getRoleNameById(id[i]);
					buffer.append(rolename+",");
				}
			}
		}
		if(!buffer.toString().equals("")){
			return buffer.toString().substring(0,buffer.toString().length()-1);
		}
		return "success";
	}
	
	@RequestMapping("updateuserrole")
	public @ResponseBody String updateUserRole(String userid,String ids){
		String[] id = ids.split(",");
		userFacade.updateUserRole(userid,id);
		return "success";
	}
}
