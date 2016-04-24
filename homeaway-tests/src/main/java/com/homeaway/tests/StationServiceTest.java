package com.homeaway.tests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.homeaway.ws.rs.FuelStation;
import com.homeaway.ws.rs.StationResults;
import com.homeaway.ws.rs.StationServiceClient;

public class StationServiceTest {

	private StationServiceClient rsClient = null;

	public StationServiceTest() {
		this.rsClient = new StationServiceClient();
	}

	@Test
	public void getAllChargePointFuelStationsTest() {
		StationResults stationResults = rsClient
				.getAllChargePointFuelStations();
		FuelStation station = stationResults.getStationByName("HYATT AUSTIN");
		String stationName = (station != null) ? station.getStatioName() : null;
		Assert.assertEquals("HYATT AUSTIN", stationName);
	}

	@Test
	public void findFuelStationsById() {
		StationResults stationResults = rsClient
				.getAllChargePointFuelStations();
		FuelStation station = stationResults.getStationByName("HYATT AUSTIN");
		int stationId = (station != null) ? station.getStationId() : null;
		FuelStation stationResult = rsClient.getFuelStationById(stationId);
		String streetAddress = (stationResult != null) ? stationResult
				.getStreetAddress() : null;
		String city = (stationResult != null) ? stationResult.getCity() : null;
		String state = (stationResult != null) ? stationResult.getState()
				: null;
		String zip = (stationResult != null) ? stationResult.getZip() : null;

		Assert.assertEquals("208 Barton Springs Rd", streetAddress);
		Assert.assertEquals("Austin", city);
		Assert.assertEquals("TX", state);
		Assert.assertEquals("78704", zip);
	}

}
