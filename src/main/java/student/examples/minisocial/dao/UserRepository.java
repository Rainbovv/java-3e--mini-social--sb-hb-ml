package student.examples.minisocial.dao;

import org.springframework.stereotype.Repository;
import student.examples.minisocial.domain.entities.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

	public List<User> getUsersList() {
		return new ArrayList<>();
	}
}
