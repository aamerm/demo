package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private MusicPlayerService musicPlayerService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Spring Boot Caffeine Caching Example Configuration");

		play("guitar");
		play("piano");
		play("guitar");
		play("flute");
		play("flute");
		play("flute");
		play("guitar");
	}

	private void play(String instrument){
		log.info("Calling: " + MusicPlayerService.class.getSimpleName() + ".play(\"" + instrument + "\");");
		musicPlayerService.play(instrument);
	}
}
