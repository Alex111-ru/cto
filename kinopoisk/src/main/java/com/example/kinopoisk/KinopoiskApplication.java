package com.example.kinopoisk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//папку target не надо комитить. Это генерируемые при билде файлы
@SpringBootApplication
public class KinopoiskApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinopoiskApplication.class, args);
	}

}
