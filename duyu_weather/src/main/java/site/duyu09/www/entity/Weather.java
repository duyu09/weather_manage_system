package site.duyu09.www.entity;

/**
 * @author zhaoYuFei
 */
public class Weather {
    private Integer id;
    private String city;
    private String weatherTime;
    private String temperature;
    private String weathers;
    private String notice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeatherTime() {
        return weatherTime;
    }

    public void setWeatherTime(String weatherTime) {
        this.weatherTime = weatherTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeathers() {
        return weathers;
    }

    public void setWeathers(String weathers) {
        this.weathers = weathers;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
