package com.wftech.dao.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.wftech.domain.common.Permission;
import com.wftech.domain.common.RegisterInfo;
import com.wftech.domain.common.Role;
import com.wftech.domain.common.User;

/**
 * @author Daoliang Li
 *
 */
@Repository
public class UserDaoImpl implements IUserDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#isUser(java.lang.String, java.lang.String)
	 */
	public boolean isUser(String username,String password){
		boolean tag;
		int num;
		String sql = "SELECT count(*) FROM t_user WHERE username = ? AND userpassword = ?";
		num = jdbcTemplate.queryForInt(sql,new Object[]{username,password});
		if(num==0){
			tag = false;
		}else{
			tag = true;
		}
		return tag;
	}
	

	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#createUser(com.wftech.domain.common.User)
	 */
	public void createUser(User user){
		String sql = "INSERT INTO t_user(username,usernickname,userpassword,usercredits,userlevel,usergold,userthemenum,userpostnum,createtime,lastvisttime,lastip,email) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
		jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getUsernickname(),user.getPassword(),
				user.getUsercredits(),user.getUserlevel(),user.getUsergold(),user.getUserthemenum(),user.getUserpostnum(),
				user.getCreatetime(),user.getLastvisttime(),user.getLastip(),user.getEmail()});
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#hasUsername(java.lang.String)
	 */
	public boolean hasUsername(String username){
		String sql = "SELECT count(*) FROM t_user WHERE username = ?";
		int count = jdbcTemplate.queryForInt(sql,new Object[]{username});
		if(count==0){
			return false;
		}else{
			return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#hasUsernickname(java.lang.String)
	 */
	public boolean hasUsernickname(String usernickname){
		String sql = "SELECT count(*) FROM t_user WHERE usernickname = ?";
		int count = jdbcTemplate.queryForInt(sql,new Object[]{usernickname});
		if(count==0){
			return false;
		}else{
			return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUserlevel(java.lang.String)
	 */
	@Cacheable(value="user",key="'userlevel'+#username")
	public int getUserlevel(String username){
		String sql = "SELECT userlevel FROM t_user WHERE username = ?";
		int level = jdbcTemplate.queryForInt(sql,new Object[]{username});
		return level;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUsernickname(java.lang.String)
	 */
	@Cacheable(value="user",key="'usernickname'+#username")
	public String getUsernickname(String username){
		String sql = "SELECT usernickname FROM t_user WHERE username = ?";
		String usernickname = (String)jdbcTemplate.query(sql,new Object[]{username},new ResultSetExtractor(){
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				rs.next();
				return rs.getString(1);
			}
		});
		return usernickname;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUserid(java.lang.String)
	 */
	@Cacheable(value="user",key="'userid'+#username")
	public int getUserid(String username){
		String sql = "SELECT userid FROM t_user WHERE username = ?";
		int userid = jdbcTemplate.queryForInt(sql,new Object[]{username});
		return userid;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#addThemeAndPostNum(int)
	 */
	public void addThemeAndPostNum(int userid){
		String sql = "UPDATE t_user SET userthemenum = userthemenum+1 ,userpostnum = userpostnum+1 WHERE userid = ?";
		jdbcTemplate.update(sql,new Object[]{userid});
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUsername(int)
	 */
	public String getUsername(int userid){
		String sql = "SELECT username FROM t_user WHERE userid = ?";
		String username = jdbcTemplate.query(sql, new Object[]{userid},new ResultSetExtractor(){
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				String result = "";
				if(rs.next()){
					result = rs.getString(1);
				}
				return result;
			}
		});
		return username;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUseridAndUsernickname(java.lang.String)
	 */
	public Map getUseridAndUsernickname(String username){
		String sql = "SELECT userid,usernickname FROM t_user WHERE username = ?";
		Map map = (Map)jdbcTemplate.query(sql,new Object[]{username},new ResultSetExtractor(){
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Map map = new HashMap();
				if(rs.next()){
					map.put("userid",rs.getInt(1));
					map.put("usernickname",rs.getString(2));
				}
				return map;
			}
		});
		return map;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUseridByUsernickname(java.lang.String)
	 */
	public int getUseridByUsernickname(String usernickname){
		String sql = "SELECT userid FROM t_user WHERE usernickname = ?";
		int userid = jdbcTemplate.queryForInt(sql,new Object[]{usernickname});
		return userid;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#updateByPost()
	 */
	@Override
	public void updateByPost(int userid) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_user SET usercredits = usercredits+1,usergold = usergold+1,"
				+ "userpostnum = userpostnum+1 WHERE userid = ?";
		jdbcTemplate.update(sql,new Object[]{userid});
		updateLevel(userid);
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#updateLevel(int)
	 */
	public void updateLevel(int userid){
		String sql = "SELECT usercredits,userlevel FROM t_user WHERE userid = ?";
		final int finaluserid = userid;
		jdbcTemplate.query(sql,new Object[]{userid},new ResultSetExtractor(){
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next()){
					if(rs.getInt(1)>=10){
						int nowlevel = (int)(Math.log(rs.getInt(1)/(double)10)/Math.log(2));
						if(nowlevel!=rs.getInt(2)){
							String sql = "UPDATE t_user SET userlevel = ? WHERE userid = ?";
							jdbcTemplate.update(sql,new Object[]{nowlevel,finaluserid});
						}
					}
				}
				return null;
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUser(int[])
	 */
	@Override
	public List<User> getUser(int[] useridArray) {
		// TODO Auto-generated method stub
		int i;
		List<User> list = null; 
		final int[] finalUseridArray = useridArray;
		final int length = useridArray.length;
		if(length!=0){
			Object[] obj = new Object[length];
			StringBuffer sql = new StringBuffer("SELECT userid,usercredits,userlevel,usergold,userthemenum,userpostnum,lastvisttime FROM t_user WHERE userid in (");
			for(i=0;i<length;i++){
				sql.append("?,");
				obj[i] = useridArray[i];
			}
			StringBuffer newsql = new StringBuffer();
			newsql.append(sql.toString().substring(0,sql.toString().length()-1));
			newsql.append(")");
			list = (List<User>)jdbcTemplate.query(newsql.toString(), obj ,new ResultSetExtractor(){
				@Override
				public Object extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					// TODO Auto-generated method stub
					//"userthemenum","userpostnum","usercredits","userlevel","usergold","lastvisttime"
					List<User> list = new ArrayList<User>();
					Map map = new HashMap();
					int i;
					User user;
					while(rs.next()){
						user = new User();
						user.setUserid(rs.getInt(1));
						user.setUsercredits(rs.getInt(2));
						user.setUserlevel(rs.getInt(3));
						user.setUsergold(rs.getInt(4));
						user.setUserthemenum(rs.getInt(5));
						user.setUserpostnum(rs.getInt(6));
						user.setLastvisttime(rs.getDate(7));
						map.put(user.getUserid(),user);
					}
					for(i=0;i<length;i++){
						list.add((User)map.get(finalUseridArray[i]));
					}
					return list;
				}
			});
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUserList(int, int)
	 */
	@Override
	public List<User> getUserList(int start, int length) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ( SELECT a.* , rownum r FROM (SELECT * FROM t_user ORDER BY createtime DESC) a) WHERE r > ? AND r < ? ";
		List<User> list = (List<User>)jdbcTemplate.query(sql,new Object[]{start,start+length+1},new ResultSetExtractor(){
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				List<User> list = new ArrayList<User>();
				while(rs.next()){
					//"userid","username","usercredits","userlevel","usergold","userthemenum","userpostnum","createtime","usernickname","email"
					User user = new User();
					user.setUserid(rs.getInt("userid"));
					user.setUsername(rs.getString("username"));
					user.setUsercredits(rs.getInt("usercredits"));
					user.setUserlevel(rs.getInt("userlevel"));
					user.setUsergold(rs.getInt("usergold"));
					user.setUserthemenum(rs.getInt("userthemenum"));
					user.setUserpostnum(rs.getInt("userpostnum"));
					user.setCreatetime(rs.getDate("createtime"));
					user.setUsernickname(rs.getString("usernickname"));
					user.setEmail(rs.getString("email"));
					list.add(user);
				}
				return list;
			}
		});
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUserNum()
	 */
	@Override
	public int getUserNum() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM t_user";
		int userNum = jdbcTemplate.queryForInt(sql);
		return userNum;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUser(int)
	 */
	@Override
	public User getUser(int userid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_user WHERE userid = ?";
		User user = (User)jdbcTemplate.query(sql, new Object[]{userid}, new ResultSetExtractor(){
			
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				
				User user = null;
				if(rs.next()){
					user = new User();
					user.setUserid(rs.getInt("userid"));
					user.setUsername(rs.getString("username"));
					user.setUsercredits(rs.getInt("usercredits"));
					user.setUserlevel(rs.getInt("userlevel"));
					user.setUsergold(rs.getInt("usergold"));
					user.setUserthemenum(rs.getInt("userthemenum"));
					user.setUserpostnum(rs.getInt("userpostnum"));
					user.setCreatetime(rs.getDate("createtime"));
					user.setUsernickname(rs.getString("usernickname"));
					user.setEmail(rs.getString("email"));
				}
				return user;
			}
		});
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getUserRole(int)
	 */
	@Override
	public Set<Role> getUserRole(int userid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM userrol a LEFT JOIN rol b ON a.rolid = b.rolid WHERE userid = ?";
		Set<Role> set = (Set<Role>)jdbcTemplate.query(sql, new Object[]{userid}, new ResultSetExtractor(){
			
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Set<Role> set = new HashSet<Role>();
				while(rs.next()){
					Role role = new Role();
					role.setRoleid(rs.getString("rolid"));
					role.setRolename(rs.getString("rolname"));
					set.add(role);
				}
				return set;
			}
		});
		return set;
	}
	

	@Override
	public void deleteUserRole(String userid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM userrol WHERE userid = ?";
		jdbcTemplate.update(sql, new Object[]{userid});
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#updateUserRole(java.lang.String, java.lang.String[])
	 */
	@Override
	public void updateUserRole(String userid, String[] id) {
		// TODO Auto-generated method stub
		final List<Object[]> list = new ArrayList<Object[]>(id.length);
		for(int i=0;i<id.length;i++){
			list.add(new Object[]{userid,id[i]});
		}
		String sql = "INSERT INTO userrol (userid, rolid) VALUES (?, ?)";
		jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
			
			@Override
			public void setValues(PreparedStatement ps, int ind)
					throws SQLException {
				// TODO Auto-generated method stub
				Object[] obj = list.get(ind);
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1, obj[i]);
				}
			}
		});//.batchUpdate(sql,new)
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IUserDao#getPermission(int)
	 */
	@Override
	public Set<Permission> getPermission(int userid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM (SELECT * FROM userrol a LEFT JOIN permissionrol b ON a.rolid = b.rolid WHERE userid = ? ) c LEFT JOIN permission d ON c.permid = d.permid";
		Set<Permission> set = (Set<Permission>)jdbcTemplate.query(sql, new Object[]{userid},new ResultSetExtractor(){
			
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Set<Permission> set = new HashSet<Permission>();
				while(rs.next()){
					Permission permission = new Permission();
					permission.setPermid(rs.getString("permid"));
					permission.setPermname(rs.getString("permname"));
					permission.setPerm(rs.getString("perm"));
					permission.setCreator(rs.getString("creator"));
					permission.setCreatetime(rs.getDate("createtime"));
					permission.setPermtypeid(rs.getInt("permtypeid"));
					permission.setParentnode(rs.getString("parentnode"));
					set.add(permission);
				}
				return set;
			}
		});
		return set;
	}
}
