package br.com.byamada.register;

import br.com.byamada.register.model.entity.Perfil;
import br.com.byamada.register.model.entity.User;
import br.com.byamada.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class RegisterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		Perfil perfil = new Perfil(null,"ADMIN");
		Set<Perfil> perfis = new HashSet<>();

		User user = new User(null,"user@email.com", passwordEncoder.encode("123456"), perfis);
		userRepository.save(user);




	}
}
