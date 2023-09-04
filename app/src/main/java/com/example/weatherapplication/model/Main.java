package com.example.weatherapplication.model;

import com.google.gson.annotations.SerializedName;

public class Main{

	@SerializedName("temp")
	private Object temp;

	@SerializedName("temp_min")
	private Object tempMin;

	@SerializedName("grnd_level")
	private int grndLevel;

	@SerializedName("humidity")
	private int humidity;

	@SerializedName("pressure")
	private int pressure;

	@SerializedName("sea_level")
	private int seaLevel;

	@SerializedName("feels_like")
	private Object feelsLike;

	@SerializedName("temp_max")
	private Object tempMax;

	public Object getTemp(){
		return temp;
	}

	public Object getTempMin(){
		return tempMin;
	}

	public int getGrndLevel(){
		return grndLevel;
	}

	public int getHumidity(){
		return humidity;
	}

	public int getPressure(){
		return pressure;
	}

	public int getSeaLevel(){
		return seaLevel;
	}

	public Object getFeelsLike(){
		return feelsLike;
	}

	public Object getTempMax(){
		return tempMax;
	}
}