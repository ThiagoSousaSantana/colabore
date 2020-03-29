package br.com.colabore;

import br.com.colabore.models.Empresa;
import br.com.colabore.models.Usuario;
import br.com.colabore.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class ColaboreApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ColaboreApplication.class, args);
	}

	@Override
	public void run(String... args) {

		var user = new Usuario();
		var empresa = new Empresa();
		user.setNome("Teste");
		user.setDataCadastro(LocalDateTime.now());
		user.setDataNascimento(LocalDate.now());

		empresa.setCnpj("234234234");
		empresa.setNomeFantasia("Teste");
		empresa.setRazaoSocial("asdfasfafd");

		user.setEmpresa(empresa);

		repository.save(user);

	}
}
