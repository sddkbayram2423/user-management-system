package com.bayram.service.employee;

import java.util.List;

import com.bayram.model.employee.Location;

public interface LocationService {
	
	boolean saveLocation(Location location);

	boolean deleteLocation(Location location);

	Location updateLocation(Location location);

	Location findLocationById(long locationId);

	public List<Location> findAllLocations();
	
	Location findLocationAndDepartmensById(long locationId);

}
