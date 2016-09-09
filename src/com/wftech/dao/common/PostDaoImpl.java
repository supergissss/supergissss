package com.wftech.dao.common;

import java.io.Reader;
import java.io.StringReader;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
@Repository
public class PostDaoImpl extends JdbcDaoSupport implements IPostDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private LobHandler lobHandler;

	public void addPost(Post post){
		final String posttype = post.getPosttype();
		final int posttheme = post.getPosttheme();
		final int authorid = post.getAuthorid();
		final Date createtime = post.getCreatetime();
		String postcontent = post.getPostcontent();
		final Reader reader = new StringReader(postcontent);
		final int length = postcontent.length();
		final String authornickname = post.getAuthornickname();
		String sql = "INSERT INTO t_post(posttype,posttheme,"
				+ "postcontent,authorid,createtime,authornickname) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.execute(sql,new AbstractLobCreatingPreparedStatementCallback(lobHandler){
			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1,posttype);
				ps.setInt(2,posttheme);
				lobCreator.setClobAsCharacterStream(ps,3,reader,length);
				ps.setInt(4, authorid);
				ps.setTimestamp(5, new Timestamp(createtime.getTime()));//.setDate(5, createtime);
				ps.setString(6,authornickname);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.dao.common.IPostDao#getPost(int, int, int)
	 */
	public List<Post> getPost(int id,int first,int last){
		String sql = "SELECT tb.* FROM(SELECT rownum rn,tc.* FROM (SELECT * FROM t_post t WHERE posttheme = ? ORDER BY createtime) tc ) tb WHERE rn>? AND rn<?";
		List<Post> list = (List<Post>)jdbcTemplate.query(sql,new Object[]{id,first-1,last+1}, new ResultSetExtractor(){
			
			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Post post;
				Clob clob;
				List<Post> list = new ArrayList<Post>();
				while(rs.next()){
					post = new Post();
					post.setPostid(rs.getInt("postid"));
					post.setPosttype(rs.getString("posttype"));
					clob = rs.getClob("postcontent");
					post.setPostcontent(clob.getSubString(1, (int)clob.length()));
					post.setAuthorid(rs.getInt("authorid"));
					post.setCreatetime(rs.getTimestamp("createtime"));
					post.setAuthornickname(rs.getString("authornickname"));
					list.add(post);
				}
				return list;
			}
			
		});
		return list;
	}
	
	public int getPostNumByTheme(int themeid){
		String sql = "SELECT count(*) FROM t_post WHERE posttheme = ?";
		int num = jdbcTemplate.queryForInt(sql,new Object[]{themeid});
		return num;
	}
	
}
