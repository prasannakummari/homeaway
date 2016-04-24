package com.homeaway.ws.rs;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FuelStationDetails {

	@JsonProperty("alt_fuel_station")
	private FuelStation altFuelStation;

	public FuelStation getAltFuelStation() {
		return altFuelStation;
	}

	public void setAltFuelStation(FuelStation altFuelStation) {
		this.altFuelStation = altFuelStation;
	}

	@Override
	public String toString() {
		return "FuelStationDetails [altFuelStation=" + altFuelStation + "]";
	}

}
