package com.devjag.sdw24;

import com.devjag.sdw24.application.AskChampUseCase;
import com.devjag.sdw24.application.ListChampUseCase;
import com.devjag.sdw24.domain.ports.ChampRepository;
import com.devjag.sdw24.domain.ports.GenerativeAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class sdw24Application {

	public static void main(String[] args) {
		SpringApplication.run(sdw24Application.class, args);
	}

	@Bean
	public ListChampUseCase provideListChampUseCase(ChampRepository repository) {
		return new ListChampUseCase(repository);
	}
	@Bean
	public AskChampUseCase provideAskChampUseCase(ChampRepository repository, GenerativeAiService genAiService) {
		return new AskChampUseCase(repository, genAiService);
	}

}
