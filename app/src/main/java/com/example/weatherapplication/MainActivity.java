package com.example.weatherapplication;

import static android.view.View.TEXT_ALIGNMENT_CENTER;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import com.example.weatherapplication.databinding.ActivityMainBinding;
import com.example.weatherapplication.model.CurrentWeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ApiInterface apiInterface;
    private String cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        binding.edittextCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                cityName = editable.toString();
            }
        });

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callApiCity(cityName, Const.WEATHER_APP_KEY);
            }
        });
    }
    private void callApiCity(String city, String apiKey) {
        Call<CurrentWeatherResponse> currentByCity = apiInterface.getCurrentWeatherByCityResponse(city, apiKey);
        currentByCity.enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                CurrentWeatherResponse currentWeatherResponse = response.body();
                binding.textviewCityName.setText(currentWeatherResponse.getName());
                binding.descriptation.setText(currentWeatherResponse.getWeather().get(0).getDescription());
                //max temp
                binding.deg.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                binding.deg.setTextSize(30);
                binding.t3Titile.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                binding.t3Titile.setText("Max Temp");
                binding.t3Titile.setTextSize(20);
                binding.deg.setText(String.valueOf(currentWeatherResponse.getMain().getTempMax()));
                //humedity
                binding.humeditytext.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                binding.humeditytext.setTextSize(30);
                binding.titilehumedity.setText("Humidity");
                binding.titilehumedity.setTextSize(20);
                binding.titilehumedity.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                binding.humeditytext.setText(String.valueOf(currentWeatherResponse.getMain().getHumidity()));
                //wind
                binding.textwind.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                binding.textwind.setTextSize(30);
                binding.textwind.setText(currentWeatherResponse.getWind().getSpeed().toString());
                binding.t2Titiel.setTextSize(20);
                binding.t2Titiel.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                binding.t2Titiel.setText("Wind Speed");
                //min temp
                binding.mintemptext.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                binding.mintemptext.setTextSize(30);
                binding.mintemptext.setText(currentWeatherResponse.getMain().getTempMin().toString());
                binding.t4Titile.setTextSize(20);
                binding.t4Titile.setText("Min Temp");
                binding.t4Titile.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                //animation
                //humidity
                binding.humedityAnim.setAnimation(R.raw.animation_humedelty);
                binding.humedityAnim.playAnimation();
                binding.humedityAnim.loop(true);
                //max temp
                binding.t3Anim.setAnimation(R.raw.animation_temp);
                binding.t3Anim.playAnimation();
                binding.t3Anim.loop(true);
                //wind
                binding.t2Anim.setAnimation(R.raw.animation_wind);
                binding.t2Anim.playAnimation();
                binding.t2Anim.loop(true);
                //min temp
                binding.t4Anim.setAnimation(R.raw.animation_temptmin);
                binding.t4Anim.playAnimation();
                binding.t4Anim.loop(true);
                //topanim
                binding.weatherAnim.setAnimation(R.raw.animation_cloudy2);
                binding.t4Anim.playAnimation();
                binding.t4Anim.loop(true);

            }
            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}

