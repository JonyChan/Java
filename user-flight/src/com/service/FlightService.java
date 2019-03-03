package com.service;

import java.util.List;

import com.entity.flight;

public interface FlightService {
	public void insert(flight f);
	public void update(int id);
	public void delete(int id);
	public flight selectOne(int id);
	public List<flight> selectAll();
}
