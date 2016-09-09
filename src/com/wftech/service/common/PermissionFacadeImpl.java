package com.wftech.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.common.utls.ParentTree;
import com.wftech.common.utls.TreeUtils;
import com.wftech.dao.common.IPermissionDao;
import com.wftech.domain.common.Permission;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Daoliang Li
 *
 */
@Service
public class PermissionFacadeImpl implements IPermissionFacade{

	@Autowired
	IPermissionDao permissionDao;
	
	@Override
	public JSONObject getPermission() {
		// TODO Auto-generated method stub
		List<Permission> list = permissionDao.getPermission();
		List<ParentTree> parentList = new ArrayList<ParentTree>();
		for(Permission tree:list){
			parentList.add((ParentTree)tree);
		}
		JSONObject obj = null;
		for(Permission tree:list){
			if(tree.getParentValue().equals("-1")){
				obj = TreeUtils.travesalParentTree(tree, parentList);
			}
		}
		return obj;
	}
	
	@Override
	public List<Permission> getPermissionList() {
		// TODO Auto-generated method stub
		return permissionDao.getPermission();
	}
}
