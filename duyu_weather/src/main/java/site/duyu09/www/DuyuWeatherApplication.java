package site.duyu09.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("site.duyu09.www.mapper")
public class DuyuWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuyuWeatherApplication.class, args);
	}

}
