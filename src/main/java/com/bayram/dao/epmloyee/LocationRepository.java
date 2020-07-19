package com.bayram.dao.epmloyee;

import java.util.List;

import com.bayram.model.employee.Location;


public interface LocationRepository {
	
	boolean saveLocation(Location location);

	boolean deleteLocation(Location location);

	Location updateLocation(Location location);

	Location findLocationById(long locationId);
	
	Location findLocationAndDepartmensById(long locationId);

	public List<Location> findAllLocations();

	

}
