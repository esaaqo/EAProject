package mum.cs544.project.serviceImpl;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.project.domain.Car;
import mum.cs544.project.repository.CarSearchRepository;
import mum.cs544.project.service.CarSearchService;


@Service
@Transactional
public class CarSearchServiceImpl implements CarSearchService {
	@Autowired
	CarSearchRepository carSearchRepository;
	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return (List<Car>) carSearchRepository.search();
	}
	@Override
	public Car findById(Integer id){
		return carSearchRepository.findOne(id);
	}
	@Override
	public JSONArray search(String fromLocation, String toLocation, Date fromDate, Date toDate) {
		JSONArray CarsAvailable = new JSONArray();
		try {
			// List<Car> Cars = carSearchRepository.search(fromLocation,
			// toLocation, fromDate, toDate);
			List<Car> Cars = getAll();
			for (int i = 0; i < Cars.size(); i++) {
				Car car = (Car) Cars.get(i);
				JSONObject currentCar = new JSONObject();
				currentCar.put("id", car.getId());
				currentCar.put("name", car.getName());
				currentCar.put("price", car.getPricePerDay());
				currentCar.put("seats", car.getCarType().getNoOfPerson());
				currentCar.put("imageLink", car.getImageLink());
				currentCar.put("year", car.getYear());
				CarsAvailable.add(currentCar);
			}
		} catch (Exception E) {

		}
		return CarsAvailable;
	}
}
