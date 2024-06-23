package site.duyu09.www.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import site.duyu09.www.entity.Weather;
import java.util.ArrayList;

@Mapper
public interface WeatherMapper {

    @Select("INSERT INTO weather_table (id, city, weatherTime, temperature, weathers, notice) " + "VALUES (#{id}, #{city}, #{weatherTime}, #{temperature}, #{weathers}, #{notice})")
    void addWeather(Weather weather);

    @Select("SELECT * FROM weather_table")
    ArrayList<Weather> getWeathersList();

    @Select("SELECT * FROM weather_table WHERE id = #{id}")
    Weather getWeatherById(int id);

    @Select("DELETE FROM weather_table WHERE id = #{id}")
    void deleteWeatherById(int id);
}
