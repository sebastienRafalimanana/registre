package org.registre.mg;
import nu.pattern.OpenCV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MgApplication.class, args);
		OpenCV.loadLocally();
	}

}
