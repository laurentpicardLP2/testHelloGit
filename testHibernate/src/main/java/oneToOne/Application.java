package oneToOne;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oneToOne.model.Profile;
import oneToOne.model.Profile.Gender;
import oneToOne.model.User;
import oneToOne.repository.ProfileRepository;
import oneToOne.repository.UserRepository;



@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		userRepository.deleteAllInBatch();
		profileRepository.deleteAllInBatch();


		// Create a User instance
		User user1 = new User("toto", "toto@simplon.co");
		User user2 = new User("boubou", "boubou@simplon.co");

		// Create a UserProfile instance
		LocalDate dob = LocalDate.of(1980, 06, 01);
		Profile profile = new Profile(
				"55 rue de Vincennes, 93100 Montreuil",
				dob, "0636122523",Gender.M
			);
		Profile emptyProfile = new Profile(
				"",
				dob, "",Gender.M
			);
		
		user1.setProfile(profile);
		user2.setProfile(emptyProfile);
		userRepository.save(user1);
		userRepository.save(user2);
		
		
		// Save profile will also save user
		profileRepository.save(profile);
		profileRepository.save(emptyProfile);
			
		
		userRepository.delete(user1);
	}


}