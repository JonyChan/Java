package com.Dao;

import java.util.List;

import com.entity.flight;

public interface FlightDao {
	
	public flight insert(flight f);
	public void delete(int id);
	public flight selectOne(int id);
	public List<flight> selectAll();
	public void update(int id);
	
}
