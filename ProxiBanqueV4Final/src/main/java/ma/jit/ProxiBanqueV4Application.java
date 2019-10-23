package ma.jit;

import ma.jit.spring.dao.IClientRepository;
import ma.jit.spring.dao.ICompteRepository;
import ma.jit.spring.dao.IConseillerRepository;
import ma.jit.spring.dao.IGerantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxiBanqueV4Application implements CommandLineRunner {
	@Autowired
	IClientRepository clientRepository;
	@Autowired
	IConseillerRepository conseillerRepository;
	@Autowired
	IGerantRepository gerantRepository;
	@Autowired
	ICompteRepository compteRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProxiBanqueV4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
	
	
}
