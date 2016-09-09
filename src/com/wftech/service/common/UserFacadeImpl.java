package com.wftech.service.common;

import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.common.DataTableColumn;
import com.wftech.common.TableUtils;
import com.wftech.dao.common.IRoleDao;
import com.wftech.dao.common.IUserDao;
import com.wftech.domain.common.Permission;
import com.wftech.domain.common.Role;
import com.wftech.domain.common.User;

/**
 * @author Daoliang Li
 *
 */
@Service
public class UserFacadeImpl implements IUserFacade {
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IRoleDao roleDao;

	/* (non-Javadoc)
	 * @see com.wftech.service.common.IUserFacade#getUserList(int, int)
	 */
	@Override
	public String[][] getUserList(int start, int length) {
		// TODO Auto-generated method stub
		List<User> list = userDao.getUserList(start,length);
		String[][] userList = new String[list.size()][DataTableColumn.getColumn(TableUtils.USER, null).length];
		int userCount = 0;
		//{"userid","username","usercredits","userlevel","usergold","userthemenum","userpostnum","createtime","usernickname","email"};
		for(User user:list){
			userList[userCount][0] = ""+user.getUserid();
			userList[userCount][1] = user.getUsername();
			userList[userCount][2] = ""+user.getUsercredits();
			userList[userCount][3] = ""+user.getUserlevel();
			userList[userCount][4] = ""+user.getUsergold();
			userList[userCount][5] = ""+user.getUserthemenum();
			userList[userCount][6] = ""+user.getUserpostnum();
			userList[userCount][7] = ""+user.getCreatetime();
			userList[userCount][8] = user.getUsernickname();
			userList[userCount][9] = user.getEmail();
			userCount++;
		}
		return userList;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IUserFacade#getUserNum()
	 */
	@Override
	public int getUserNum() {
		// TODO Auto-generated method stub
		return userDao.getUserNum();
		
	}
	
	@Override
	public JSONObject getUserData(int userid) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(userid);
		List<Role> roleList = roleDao.getAllRole();
		Set<Role> userRoleSet = userDao.getUserRole(userid);
		JSONObject obj = new JSONObject();
		obj.put("usernickname", user.getUsernickname());
		obj.put("createtime", ""+user.getCreatetime());
		JSONArray array = new JSONArray();
		for(Role role:roleList){
			JSONObject treeObj = new JSONObject();
			treeObj.put("id",role.getRoleid());
			treeObj.put("text",role.getRolename());
			treeObj.put("name", role.getRoleid());
			treeObj.put("value",role.getRoleid());
			treeObj.put("showcheck", true);
			treeObj.put("complete",true);
			treeObj.put("isexpand", true);
			treeObj.put("hasChildren", false);
			if(userRoleSet.contains(role)){
				treeObj.put("checkstate", 1);
			}else{
				treeObj.put("checkstate",0);
			}
			array.add(treeObj);
		}
		obj.put("role",array);
		return obj;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IUserFacade#updateUserRole(java.lang.String, java.lang.String[])
	 */
	@Override
	public void updateUserRole(String userid, String[] id) {
		// TODO Auto-generated method stub
		userDao.deleteUserRole(userid);
		userDao.updateUserRole(userid,id);
	}
	
	@Override
	public Set<Permission> getPermission(int userid) {
		// TODO Auto-generated method stub
		
		return userDao.getPermission(userid);
	}
}
