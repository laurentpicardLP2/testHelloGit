package oneToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import oneToOne.model.Profile;


public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
