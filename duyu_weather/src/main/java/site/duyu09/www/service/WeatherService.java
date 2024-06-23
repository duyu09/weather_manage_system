package site.duyu09.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import site.duyu09.www.util.WeatherUtils;
import site.duyu09.www.entity.Weather;
import org.springframework.stereotype.Service;
import site.duyu09.www.mapper.WeatherMapper;

import java.util.ArrayList;

@Service
public class WeatherService {

    @Autowired
    private WeatherMapper weatherMapper;

    public Weather getWeather(String code) {
        return WeatherUtils.getWeather(Integer.parseInt(code));
    }

    public void addWeather(Weather weather) {
        weatherMapper.addWeather(weather);
    }

    public ArrayList<Weather> getWeathersList() {
        return weatherMapper.getWeathersList();
    }

    public Weather getWeatherById(int id) {
        return weatherMapper.getWeatherById(id);
    }

    public void deleteWeatherById(int id) {
        weatherMapper.deleteWeatherById(id);
    }
}
