package oneToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import oneToOne.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
