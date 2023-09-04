package com.example.weatherapplication.model;

import com.google.gson.annotations.SerializedName;

public class Wind{

	@SerializedName("deg")
	private int deg;

	@SerializedName("speed")
	private Object speed;

	@SerializedName("gust")
	private Object gust;

	public int getDeg(){
		return deg;
	}

	public Object getSpeed(){
		return speed;
	}

	public Object getGust(){
		return gust;
	}
}