package com.wftech.service.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.common.DataTableColumn;
import com.wftech.common.TableUtils;
import com.wftech.common.utls.ParentTree;
import com.wftech.common.utls.TreeUtils;
import com.wftech.dao.common.IPermissionDao;
import com.wftech.dao.common.IRoleDao;
import com.wftech.domain.common.Permission;
import com.wftech.domain.common.Role;

/**
 * @author Daoliang Li
 *
 */
/**
 * @author Daoliang Li
 *
 */
@Service
public class RoleFacadeImpl implements IRoleFacade {
	
	@Autowired
	IRoleDao roleDao;
	
	@Autowired
	IPermissionDao permissionDao;

	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#addRole(java.lang.String, java.util.List, java.lang.String)
	 */
	public boolean addRole(String rolename,List<Permission> permission,String usernamenickname) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setCreator(usernamenickname);
		role.setRolename(rolename);
		String roleid = roleDao.addRole(role);
		if(roleid!=null){
			role.setRoleid(roleid);
			roleDao.addRolePermission(role,permission);
		}else{
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#getRoleList(int, int)
	 */
	@Override
	public String[][] getRoleList(int start, int length) {
		// TODO Auto-generated method stub
		int i = 0;
		List<Role> list = roleDao.getRoleList(start,length);
		String[][] result = new String[list.size()][DataTableColumn.getColumn(TableUtils.ROLE,null).length];
		for(Role role:list){
			result[i][0] = role.getRoleid();
			result[i][1] = role.getRole();
			result[i][2] = role.getRolename();
			result[i][3] = role.getCreator();
			result[i][4] = ""+role.getCreatetime();
			i++;
		}
		return result;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#getRoleNum()
	 */
	@Override
	public int getRoleNum() {
		// TODO Auto-generated method stub
		return roleDao.getRoleNum();
	}
	


	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#getRolePermission(java.lang.String)
	 */
	public JSONObject getRolePermission(String roleid) {
		// TODO Auto-generated method stub
		List<Permission> list = permissionDao.getPermission();
		List<ParentTree> parentList = new ArrayList<ParentTree>();
		Set<ParentTree> set = new HashSet<ParentTree>();
		List<Permission> rolePermissionList = roleDao.getRolePermission(roleid);
		for(Permission tree:list){
			parentList.add((ParentTree)tree);
		}
		for(Permission tree:rolePermissionList){
			set.add((ParentTree)tree);
		}
		JSONObject obj = null;
		for(Permission tree:list){
			if(tree.getParentValue().equals("-1")){
				obj = TreeUtils.travesalParentTree(tree, set, parentList);
			}
		}
		return obj;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#deleteRolePermission(java.lang.String)
	 */
	@Override
	public void deleteRolePermission(String rolename) {
		// TODO Auto-generated method stub
		roleDao.deleteRolePermission(rolename);
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#updateRolePermission(java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public void updateRolePermission(String roleid,
			List<Permission> permission, String usernickname) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setCreator(usernickname);
		if(roleid!=null){
			role.setRoleid(roleid);
			roleDao.addRolePermission(role,permission);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#deleteRole(java.lang.String)
	 */
	@Override
	public void deleteRole(String roleid) {
		// TODO Auto-generated method stub
		roleDao.deleteRole(roleid);
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#getRoleNameById(java.lang.String)
	 */
	@Override
	public String getRoleNameById(String roleid) {
		// TODO Auto-generated method stub
		return roleDao.getRoleNameById(roleid);
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRoleFacade#isRoleHasUser(java.lang.String)
	 */
	@Override
	public boolean isRoleHasUser(String roleid) {
		// TODO Auto-generated method stub
		return roleDao.isRoleHasUser(roleid);
	}
	
}
