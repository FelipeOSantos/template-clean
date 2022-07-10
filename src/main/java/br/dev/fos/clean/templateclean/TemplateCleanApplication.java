package br.dev.fos.clean.templateclean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.fos.clean.templateclean.usecase.customer.find.FindCustomerUseCase;
import br.dev.fos.clean.templateclean.usecase.customer.find.dto.InputFindCustomerDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TemplateCleanApplication implements CommandLineRunner {

	@Autowired
	private FindCustomerUseCase findCustomerUseCase;

	public static void main(String[] args) {
		SpringApplication.run(TemplateCleanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.debug(">> run()");

		InputFindCustomerDTO inputFindCustomerDTO = new InputFindCustomerDTO();
		inputFindCustomerDTO.setId("123");

		findCustomerUseCase.execute(inputFindCustomerDTO);

		log.debug("<< run()");
	}

}
