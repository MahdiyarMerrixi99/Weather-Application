package com.example.weatherapplication.model;

import com.google.gson.annotations.SerializedName;

public class Rain{

	@SerializedName("1h")
	private Object jsonMember1h;

	public Object getJsonMember1h(){
		return jsonMember1h;
	}
}