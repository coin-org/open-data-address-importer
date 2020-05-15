package org.coin.jusomanager;

import org.coin.jusomanager.service.JusomanagerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JusomanagerApplication implements CommandLineRunner {
	
	private final JusomanagerService jusomanagerService;
	
	public JusomanagerApplication(JusomanagerService jusomanagerService) {
		this.jusomanagerService = jusomanagerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JusomanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jusomanagerService.run(args.length == 0 ? "" : args[0]);
	}
}
