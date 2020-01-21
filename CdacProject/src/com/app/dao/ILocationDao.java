package com.app.dao;

import java.util.List;

import com.app.pojos.Location;

public interface ILocationDao {

	List<Location> getLocationList();

	Location getLocationById(int Id);

}
