package br.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.edu.infnet.domain.model"})
@EnableJpaRepositories(basePackages = {"br.edu.infnet.domain.repository"})
public class VenturaHrEmpresaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenturaHrEmpresaApplication.class, args);
    }

}
