package com.wftech.dao.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
@Repository
public class ThemeDaoImpl implements IThemeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IThemeDao#createTheme(com.wftech.domain.common.Theme)
	 */
	public int createTheme(Theme theme){
		final String themetype = theme.getThemetype();
		final String themeName = theme.getTheme();
		final Timestamp createtime = theme.getCreatetime();
		final int replay = theme.getReplay();
		final int look = theme.getLook();
		final int lastexpressuser = theme.getLastexpressuser();
		final Timestamp lastexpresstime = theme.getLastexpresstime();
		final int authorid = theme.getAuthorid();
		final String authornickname = theme.getAuthornickname();
		final String lastnickname = theme.getLastnickname();
		int result = (int)jdbcTemplate.execute(new ConnectionCallback(){
			@Override
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO t_theme(themetype,theme,createtime,replay,look,"
						+ "lastexpressuser,lastexpresstime,authorid,authornickname,lastnickname) VALUES (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"themeid"});
				ps.setString(1,themetype);
				ps.setString(2,themeName);
				ps.setTimestamp(3, createtime);
				ps.setInt(4,replay);
				ps.setInt(5,look);
				ps.setInt(6, lastexpressuser);
				ps.setTimestamp(7,lastexpresstime);
				ps.setInt(8,authorid);
				ps.setString(9,authornickname);
				ps.setString(10, lastnickname);
				ps.executeUpdate(); 
				ResultSet rs = ps.getGeneratedKeys();
				if (rs != null && rs.next()){
					return rs.getInt(1);
				}
				return 0;
			}
		});
		return result;
	}
	
	
	public List<Theme> getTheme(String type,int first,int last){
		String sql = "SELECT tb.* FROM(SELECT rownum rn,tc.* FROM (SELECT * FROM t_theme t WHERE themetype = ? ORDER BY lastexpresstime DESC) tc ) tb WHERE rn>? AND rn<?";
		List<Theme> list = (List<Theme>)jdbcTemplate.query(sql,new Object[]{type,first-1,last+1}, new ResultSetExtractor(){
			
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Theme theme;
				List<Theme> list = new ArrayList<Theme>();
				while(rs.next()){
					theme = new Theme();
					theme.setThemeid(rs.getInt("themeid"));
					theme.setThemetype(rs.getString("themetype"));
					theme.setTheme(rs.getString("theme"));
					theme.setCreatetime(rs.getTimestamp("createtime"));
					theme.setReplay(rs.getInt("replay"));
					theme.setLook(rs.getInt("look"));
					theme.setLastexpressuser(rs.getInt("lastexpressuser"));
					theme.setLastexpresstime(rs.getTimestamp("lastexpresstime"));
					theme.setAuthorid(rs.getInt("authorid"));
					theme.setLastnickname(rs.getString("lastnickname"));
					theme.setAuthornickname(rs.getString("authornickname"));
					list.add(theme);
				}
				return list;
			}
			
		});
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IThemeDao#getThemeNum(java.lang.String)
	 */
	public int getThemeNum(String type){
		String sql = "SELECT count(*) FROM t_theme WHERE themetype = ?";
		int num = jdbcTemplate.queryForInt(sql,new Object[]{type});
		return num;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IThemeDao#hasTheme(int)
	 */
	public boolean hasTheme(int themeid){
		String sql = "SELECT count(*) FROM t_theme WHERE themeid = ?";
		int i = jdbcTemplate.queryForInt(sql,new Object[]{themeid});
		if(i==0){
			return false;
		}else{
			return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IThemeDao#updateTheme(com.wftech.domain.common.Post)
	 */
	@Override
	public void updateTheme(Post post) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_theme SET replay = replay+1,lastexpressuser = ?,lastexpresstime = ?,"
				+ "lastnickname = ? WHERE themeid = ?";
		jdbcTemplate.update(sql,new Object[]{post.getAuthorid(),post.getCreatetime(),post.getAuthornickname(),post.getPosttheme()});
	}
}
