package com.example.weatherapplication;

import com.example.weatherapplication.model.CurrentWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
//    https://api.openweathermap.org/data/2.5/
    @GET("weather")
    Call<CurrentWeatherResponse> getCurrentWeatherResponse(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("appid") String appKey);
    @GET("weather")
    Call<CurrentWeatherResponse> getCurrentWeatherByCityResponse(
            @Query("q") String city,
            @Query("appid") String appKey);

}
