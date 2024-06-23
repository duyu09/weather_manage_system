package site.duyu09.www.controller;

import org.springframework.web.bind.annotation.*;
import site.duyu09.www.service.WeatherService;
import site.duyu09.www.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/getWeather")
    public Map<String, Object> getWeather(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        Weather weather = weatherService.getWeather(code);
        Map<String, Object> response = new HashMap<>();
        if (weather != null) {
            response.put("status", 0);
            response.put("code", code);
            response.put("city", weather.getCity());
            response.put("weatherTime", weather.getWeatherTime());
            response.put("temperature", weather.getTemperature());
            response.put("weathers", weather.getWeathers());
            response.put("notice", weather.getNotice());
            response.put("message", "Success.");
        } else {
            response.put("status", 1);
            response.put("message", "Error code or other error situation.");
        }
        return response;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/addWeather")
    public Map<String, Object> addWeather(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        Map<String, Object> response = new HashMap<>();
        Weather weather_comp = weatherService.getWeatherById(Integer.parseInt(code));
        if (weather_comp != null)
        {
            response.put("status", 1);
            response.put("message", "City already exists.");
        }
        Weather weather = weatherService.getWeather(code);
        weather.setId(Integer.parseInt(code));
        weatherService.addWeather(weather);
        response.put("status", 0);
        return response;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/getWeathersList")
    public Map<String, Object> getWeathersList() {
        Map<String, Object> response = new HashMap<>();
        ArrayList<Map<String, Object>> weathersArray = new ArrayList<>();
        ArrayList<Weather> weathers = weatherService.getWeathersList();
        for (Weather weather : weathers) {
            Map<String, Object> weathersMap = new HashMap<>();
            weathersMap.put("id", weather.getId());
            weathersMap.put("city", weather.getCity());
            weathersMap.put("weatherTime", weather.getWeatherTime());
            weathersMap.put("temperature", weather.getTemperature());
            weathersMap.put("weathers", weather.getWeathers());
            weathersMap.put("notice", weather.getNotice());
            weathersMap.put("message", "Success.");
            weathersArray.add(weathersMap);
        }
        response.put("status", 0);
        response.put("weathersArray", weathersArray);
        return response;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/deleteWeather")
    public Map<String, Object> deleteWeather(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        weatherService.deleteWeatherById(Integer.parseInt(code));
        Map<String, Object> response = new HashMap<>();
        response.put("status", 0);
        return response;
    }
}
