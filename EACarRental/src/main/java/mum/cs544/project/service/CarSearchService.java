package mum.cs544.project.service;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;

import mum.cs544.project.domain.Car;

public interface CarSearchService {
	public Car findById(Integer id);
	public List<Car> getAll();
	public JSONArray search(String fromLocation, String toLocation, Date fromDate, Date toDate);
}
