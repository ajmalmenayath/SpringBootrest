package com.Ajmal.Rest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;


import com.Ajmal.Rest.Model.restModel;

@Repository
public class restDao {
	
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	
	// @Override
	    public int count() {
	        return jdbcTemplate
	                .queryForObject("select count(*) from city", Integer.class);
	    }
	    
	    
	    public restModel select_id(int id)
	    {
	 
	    	
	    	 String sql = "SELECT * FROM emp WHERE ID = ?";


	         return jdbcTemplate.queryForObject(
	                 sql, restModel.class, new Object[]{id});
	    }
	    
	    
	 //   @Override
	    public int save(restModel rm) {
	        return jdbcTemplate.update(
	                "insert into emp (name, address) values(?,?)",
	                rm.getName(), rm.getAddress());
	    }
	    
	    
	    public List<restModel> findAll() {
	    	
	    	return jdbcTemplate.query("select *from emp", new <restModel>RowMapper() {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					restModel ob=new restModel();
					//ob.setUsername(rs.getString("username"));
				//	ob.setPassword(rs.getString("password"));
					ob.setId(rs.getInt("id"));
					ob.setName(rs.getString("name"));
					ob.setAddress(rs.getString("address"));
					return ob;
				}
			});
	    }

	    
	    
	 
	

}
