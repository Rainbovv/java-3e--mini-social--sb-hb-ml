package student.examples.minisocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.examples.minisocial.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
