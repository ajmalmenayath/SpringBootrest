package com.Ajmal.Rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ajmal.Rest.Dao.restDao;
import com.Ajmal.Rest.Model.restModel;

@Service
public class restService {
	@Autowired restDao rd;
	
	public int count()
	{
		return rd.count();
	}
	public int save(restModel rm)
	{
		return rd.save(rm);
	}
	public restModel select_id(int id)
	{
		return rd.select_id(id);
	}
	
	
	public List<restModel> fechall()
	{
		return rd.findAll();
	}
	

}
