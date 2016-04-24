package com.homeaway.ws.rs;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

// Station service REST client providing methods calls to retrieve all fuel stations and find
// fuel station by ID
public class StationServiceClient {

	public StationServiceClient() {
		// set certificate store to place secure calls
		String jksFilePath = getClass().getResource("/certs/mycerts.jks")
				.getPath();

		System.setProperty("javax.net.ssl.keyStore", jksFilePath);
		System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
		System.setProperty("javax.net.ssl.trustStore", jksFilePath);
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
	}

	// method to retrieve all chargepoint fuel stations
	public StationResults getAllChargePointFuelStations() {
		String targetUrl = "https://api.data.gov/nrel/alt-fuel-stations/v1.json?api_key=7NgEN9TMS2aHlotPmxihjzXQ3YXeZtiL7EIpkQ7y&location=Austin+TX&ev_network=ChargePoint+Network";
		Client restClient = ClientBuilder.newClient();

		WebTarget target = restClient.target(targetUrl);
		Response response = target.request().get();
		StationResults stationResults = response
				.readEntity(StationResults.class);
		response.close();
		restClient.close();

		return stationResults;
	}

	// method to retrieve fuel station by ID
	public FuelStation getFuelStationById(int stationId) {
		String targetUrl = "https://api.data.gov/nrel/alt-fuel-stations/v1/"
				+ stationId
				+ ".json?api_key=7NgEN9TMS2aHlotPmxihjzXQ3YXeZtiL7EIpkQ7y";
		Client restClient = ClientBuilder.newClient();

		WebTarget target = restClient.target(targetUrl);
		Response response = target.request().get();
		FuelStationDetails fuelStation = response
				.readEntity(FuelStationDetails.class);
		response.close();
		restClient.close();

		return ((fuelStation != null) ? fuelStation.getAltFuelStation() : null);
	}

}
