package com.wftech.dao.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wftech.domain.common.Permission;
import com.wftech.domain.common.RegisterInfo;
import com.wftech.domain.common.Role;
import com.wftech.domain.common.User;

/**
 * 用户表打交道的dao
 * @author ws
 *
 */
public interface IUserDao {
	
	/**
	 *是否用户
	 * @author Daoliang Li
	 * @param username 用户名
	 * @param password 密码
	 * @return 是否用户
	 */
	public boolean isUser(String username,String password);
	

	/**
	 *创建用户
	 * @author Daoliang Li
	 * @param user 用户
	 */
	public void createUser(User user);
	
	/**
	 *是否有重复的用户名称
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return 是否
	 */
	public boolean hasUsername(String username);
	
	/**
	 *是否有重复的用户昵称
	 * @author Daoliang Li
	 * @param usernickname 用户昵称
	 * @return 是否
	 */
	public boolean hasUsernickname(String usernickname);
	
	/**
	 *获取用户等级
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return 用户等级
	 */
	public int getUserlevel(String username);
	
	/**
	 *获取用户昵称
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return 用户昵称
	 */
	public String getUsernickname(String username);
	
	/**
	 *获取用户id
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return 用户id
	 */
	public int getUserid(String username);
	
	/**
	 *增加主题和帖子的数目
	 * @author Daoliang Li
	 * @param userid 用户id
	 */
	public void addThemeAndPostNum(int userid);
	
	/**
	 *获取用户名字
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @return 用户名字
	 */
	public String getUsername(int userid);
	
	/**
	 *获取用户id和用户昵称
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return  用户昵称和用户id的map
	 */
	public Map getUseridAndUsernickname(String username);
	
	/**
	 *获取用户id
	 * @author Daoliang Li
	 * @param usernickname 用户昵称
	 * @return 用户id
	 */
	public int getUseridByUsernickname(String usernickname);
	
	/**
	 *当发帖时更新用户数据
	 * @author Daoliang Li
	 * @param userid 用户id
	 */
	public void updateByPost(int userid);
	
	/**
	 *判断积分看用户是否需要升级
	 * @author Daoliang Li
	 * @param userid 用户id
	 */
	public void updateLevel(int userid);
	
	/**
	 *获取用户 list
	 * @author Daoliang Li
	 * @param useridArray 用户id数组
	 * @return 用户list
	 */
	public List<User> getUser(int[] useridArray);
	
	/**
	 *获取用户列表
	 * @author Daoliang Li
	 * @param start 起始
	 * @param length 长度
	 * @return 用户数据
	 */
	public List<User> getUserList(int start, int length);
	
	/**
	 *获取用户数量
	 * @author Daoliang Li
	 * @return 用户数量
	 */
	public int getUserNum();
	
	/**
	 *获取用户角色集合
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @return 角色集合
	 */
	public Set<Role> getUserRole(int userid);
	
	/**
	 *获取用户
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @return 用户
	 */
	public User getUser(int userid);
	
	/**
	 *删除用户的id
	 * @author Daoliang Li
	 * @param userid 用户id
	 */
	public void deleteUserRole(String userid);
	
	/**
	 *更新用户的角色信息
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @param id 角色id
	 */
	public void updateUserRole(String userid, String[] id);
	
	/**
	 *获取用户权限
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @return 权限集合
	 */
	public Set<Permission> getPermission(int userid);
}
