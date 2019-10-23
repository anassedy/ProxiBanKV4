//package ma.jit.spring.dao;
//
//import ma.jit.entites.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class DbInit implements CommandLineRunner {
//	private UserRepository userRepository;
//
//	private PasswordEncoder passwordEncoder;
//
//
//	public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//		this.userRepository = userRepository;
//		this.passwordEncoder = passwordEncoder;
//
//	}
//
//	@Override
//	public void run(String... args) {
//		// Delete all
//		this.userRepository.deleteAll();
//
//
//
//
//		// Crete users
//		User anas = new User("anas", passwordEncoder.encode("anas"), "CONSEILLER",
//				"");
//		User hamza = new User("hamza", passwordEncoder.encode("hamza"), "GERANT", "");
//		User fz = new User("fz", passwordEncoder.encode("fz"), "MODERATEUR", "");
//
//		Employe conseiller = new ConseillerClient();
//		conseiller.setNom("anas");
//		conseiller.setPrenom("edchoury");
//
//
//		Employe gerant = new Gerant();
//		gerant.setNom("hamza");
//		gerant.setPrenom("omouh");
//
//		Employe moderateur = new Moderateur();
//		moderateur.setNom("fz");
//		moderateur.setPrenom("nouaim");
//
//		anas.setEmploye(conseiller);
//		hamza.setEmploye(gerant);
//		fz.setEmploye(moderateur);
//
//		List<User> users = Arrays.asList(anas, hamza, fz);
//
//		/*	Gerant g1 = gerantRepository.save(new Gerant("Thami","Lmekki","thami.lmekki@gmail.com","ain sebaa"));
//		ConseillerClient cc1 = conseillerRepository.save(new ConseillerClient("Bou","Khou", "bok@gmail.com", "29,fsjjd",  g1));
//		Client clt1 = clientRepository.save(new Client("ayoub", "idyous", "Idy@gmail.com", "29,gdhjdj", cc1));
//		Compte cpte1= compteRepository.save(new CompteCourant(new Date(),5000 ,clt1, 1000));
//		Compte cpte2= compteRepository.save(new CompteEpargne(new Date(),3000 ,clt1, 0.03));*/
//
//		// Save to db
//		this.userRepository.saveAll(users);
//
//	}
//}
