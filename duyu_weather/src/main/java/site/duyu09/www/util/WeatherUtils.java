package site.duyu09.www.util;

import site.duyu09.www.entity.Weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author zhaoYuFei
 */
public class WeatherUtils {

    public static void get(){
        try{
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101250601");
            InputStreamReader isReader =  new InputStreamReader(url.openStream(),"UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;
            while((str = br.readLine()) != null){
                String regex="\\p{Punct}+";
                String digit[]=str.split(regex);
                System.out.println('\n'+"城市:"+digit[22]+digit[18]);
                System.out.println('\n'+"时间:"+digit[11]+"年"+digit[14]+"月"+digit[52]+"日"+digit[54]);
                System.out.println('\n'+"温度:"+digit[46]+"~"+digit[48]);
                System.out.println('\n'+"天气:"+digit[68]+" "+digit[64]+digit[66]);
                System.out.println('\n'+digit[70]);
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
    }
    public static Weather getWeather(Integer code){
        Weather weather=new Weather();
        try{
            String urls="http://t.weather.itboy.net/api/weather/city/";
            URL url = new URL(urls+String.valueOf(code));
            InputStreamReader isReader =  new InputStreamReader(url.openStream(),"UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;

            while((str = br.readLine()) != null){
                String regex="\\p{Punct}+";
                String digit[]=str.split(regex);
                weather.setCity("城市:"+digit[22]+digit[18]);
                weather.setWeatherTime("时间:"+digit[11]+"年"+digit[14]+"月"+digit[52]+"日"+digit[54]);
                weather.setWeathers("天气:"+digit[68]+" "+digit[64]+digit[66]);
                weather.setTemperature("温度:"+digit[46]+"~"+digit[48]);
                weather.setNotice(digit[70]);
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
        return weather;
    }

}
