package com.wftech.dao.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.wftech.domain.common.Permission;
import com.wftech.domain.common.Role;

/**
 * @author Daoliang Li
 *
 */
@Repository
public class RoleDaoImpl implements IRoleDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IRoleDao#addRole(com.wftech.domain.common.Role)
	 */
	@Override
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM rol WHERE rolname = ?";
		int num = jdbcTemplate.queryForInt(sql,new Object[]{role.getRolename()});
		final Role finalrole = role;
		String result = null;
		if(num>0){
			return null;
		}else{
			
			result = (String)jdbcTemplate.execute(new ConnectionCallback(){
				@Override
				public Object doInConnection(Connection conn)
						throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					String sql = "INSERT INTO rol(rolname,creator,createtime,rol) VALUES (?,?,sysdate,?)";
					PreparedStatement ps = conn.prepareStatement(sql,new String[]{"rolid"});
					ps.setString(1, finalrole.getRolename());
					ps.setString(2, finalrole.getCreator());
					ps.setString(3, finalrole.getRole());
					ps.execute();
					ResultSet rs = ps.getGeneratedKeys();
					if(rs!=null&&rs.next()){
						return rs.getString(1);
					}
					return null;
				}
			});
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IRoleDao#addRolePermission(java.lang.String, java.util.List)
	 */
	@Override
	public void addRolePermission(Role role, List<Permission> list) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO permissionrol(rolid,permid,creator,createtime) VALUES (?,?,?,sysdate)";
		final List<Object[]> array = new ArrayList<Object[]>();
		String roleid = role.getRoleid();
		String creator = role.getCreator();
		for(Permission permission:list){
			array.add(new Object[]{roleid,permission.getPermid(),creator});
		}
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter(){
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return array.size();
			}
			
			@Override
			public void setValues(PreparedStatement ps, int ind)
					throws SQLException {
				// TODO Auto-generated method stub
				Object[] obj = array.get(ind);
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1, obj[i]);
				}
			}
		});
	}
	
	@Override
	public List<Role> getRoleList(int start, int length) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM (SELECT b.* , rownum r FROM(SELECT * FROM rol a ORDER BY createtime DESC) b) WHERE r > ? AND r < ?";
		List<Role> list = (List<Role>)jdbcTemplate.query(sql, new Object[]{ start,start+length+1},new ResultSetExtractor(){
			
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				List<Role> list = new ArrayList<Role>();
				Role role;
				while(rs.next()){
					role = new Role();
					role.setRoleid(rs.getString("rolid"));
					role.setRole(rs.getString("rol"));
					role.setRolename(rs.getString("rolname"));
					role.setCreator(rs.getString("creator"));
					role.setCreatetime(rs.getDate("createtime"));
					list.add(role);
				}
				return list;
			}
		});
		return list;
	}
	
	@Override
	public int getRoleNum() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM rol";
		int num = jdbcTemplate.queryForInt(sql);
		return num;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IRoleDao#getRolePermission(int)
	 */
	@Override
	public List<Permission> getRolePermission(String roleid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM permissionrol a LEFT JOIN permission b ON a.permid = b.permid WHERE rolid = ?";
		List<Permission> list = (List<Permission>)jdbcTemplate.query(sql,new Object[]{roleid},new ResultSetExtractor(){
			
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
					list.add(permission);
				}
				return list;
			}
		});
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IRoleDao#deleteRolePermission(java.lang.String)
	 */
	@Override
	public void deleteRolePermission(String roleid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM permissionrol WHERE rolid = ?";
		jdbcTemplate.update(sql,new Object[]{roleid});
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IRoleDao#deleteRole(java.lang.String)
	 */
	@Override
	public void deleteRole(String roleid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM rol WHERE rolid = ?";
		jdbcTemplate.update(sql,new Object[]{roleid});
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IRoleDao#isRoleHasUser(java.lang.String)
	 */
	@Override
	public boolean isRoleHasUser(String roleid) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM userrol WHERE rolid = ?";
		int num = jdbcTemplate.queryForInt(sql,new Object[]{roleid});
		if(num==0){
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IRoleDao#getRoleNameById(java.lang.String)
	 */
	@Override
	public String getRoleNameById(String roleid) {
		// TODO Auto-generated method stub
		String sql = "SELECT rolname FROM rol WHERE rolid = ?";
		String rolename = (String)jdbcTemplate.query(sql,new Object[]{roleid},new ResultSetExtractor(){
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				String rolename = null;
				if(rs.next()){
					rolename = rs.getString(1);
				}
				return rolename;
			}
		});
		return rolename;
	}
	
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return getRoleList(0,Integer.MAX_VALUE-1);
	}
}
