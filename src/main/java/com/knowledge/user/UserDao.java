package com.knowledge.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;

public class UserDao extends KnowledgeDao<User> {

	@Override
	public int deleteEntity(User t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//TODO arc read
	public User readEntity(User t) {
		String sql = "SELECT username, id, userpass, role, regTime FROM knowledge_user WHERE username = ? AND userpass = ?";
		Object[] args = {t.getUsername(), t.getUserpass()};
		
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), args);
	}

	@Override
	public int updateEntity(User t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.knowledge.arc.KnowledgeDao#create(com.knowledge.arc.KnowledgeEntity)
	 * 
	 * user register with role
	 */
	@Override
	public int create(User t) {
		String sql = "INSERT INTO knowledge_user (id, username, userpass, role) VALUES(?, ?, ?, ?)";
		Object[] args = {t.getId(), t.getUsername(), t.getUserpass(), t.getRole()};
		
		return jdbcTemplate.update(sql, args);
	}
}

class UserRowMapper implements RowMapper<User> {
	/*
	 * (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 * mapper all column to user
	 */
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setId(rs.getString("id"));
		user.setUsername(rs.getString("username"));
		user.setUserpass(rs.getString("userpass"));
		user.setRole(rs.getInt("role"));
		user.setRegTime(rs.getTimestamp("regTime"));
		
		return user;
	}
	
}
