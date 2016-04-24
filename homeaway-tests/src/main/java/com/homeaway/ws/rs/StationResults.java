package com.homeaway.ws.rs;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationResults {

	@JsonProperty("total_results")
	private int totalResults;

	@JsonProperty("fuel_stations")
	private List<FuelStation> fuelStations;

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public FuelStation getStationByName(String stationName) {
		for (FuelStation fs : fuelStations)
			if (fs.getStatioName().equalsIgnoreCase(stationName))
				return fs;

		return null;
	}

	@Override
	public String toString() {
		return "StationResults [totalResults=" + totalResults
				+ ", fuelStations=" + fuelStations + "]";
	}
}
