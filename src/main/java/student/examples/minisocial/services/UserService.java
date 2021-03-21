package student.examples.minisocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.examples.minisocial.dao.UserRepository;
import student.examples.minisocial.domain.entities.User;

import java.util.List;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> getUsersList() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {

		var ref = new Object() {
			User user = null;
		};

		userRepository.findById(id).ifPresent(value -> ref.user = value);

		return ref.user;
	}

	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(int id, User user) {
		userRepository.deleteById(id);
		user.setId(id);
		userRepository.save(user);
	}
}
