package com.wftech.dao.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.wftech.domain.common.Permission;

/**
 * @author Daoliang Li
 *
 */
@Repository
public class PermissionDaoImpl implements IPermissionDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IPermissionDao#getPermission()
	 */
	@Override
	public List<Permission> getPermission() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM permission";
		List<Permission> list = (List<Permission>)jdbcTemplate.query(sql,new ResultSetExtractor(){
			
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				List<Permission> list = new ArrayList<Permission>();
				while(rs.next()){
					Permission permission = new Permission();
					permission.setPermid(rs.getString("permid"));
					permission.setPermname(rs.getString("permname"));
					permission.setPerm(rs.getString("perm"));
					permission.setCreator(rs.getString("creator"));
					permission.setCreatetime(rs.getDate("createtime"));
					permission.setPermtypeid(rs.getInt("permtypeid"));
					permission.setParentnode(rs.getString("parentnode"));
					list.add(permission);
				}
				return list;
			}
		});
		return list;
	}
}
