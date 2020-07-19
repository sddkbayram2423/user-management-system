package com.bayram.service.employee.Imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.dao.epmloyee.LocationRepository;
import com.bayram.model.employee.Location;
import com.bayram.service.employee.LocationService;
@Service
public class LocationServiceImp implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public boolean saveLocation(Location location) {
		return locationRepository.saveLocation(location);
	}

	@Override
	public boolean deleteLocation(Location location) {
		return locationRepository.deleteLocation(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepository.updateLocation(location);
	}

	@Override
	public Location findLocationById(long locationId) {
		return locationRepository.findLocationById(locationId);
	}

	@Override
	public List<Location> findAllLocations() {
		return locationRepository.findAllLocations();
	}

	@Override
	public Location findLocationAndDepartmensById(long locationId) {
		return locationRepository.findLocationAndDepartmensById(locationId);
	}

}
