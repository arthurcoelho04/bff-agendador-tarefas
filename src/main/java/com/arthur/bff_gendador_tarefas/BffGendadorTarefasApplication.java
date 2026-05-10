package com.arthur.bff_gendador_tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BffGendadorTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffGendadorTarefasApplication.class, args);
	}

}
