package student.examples.minisocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.examples.minisocial.dao.UserRepository;
import student.examples.minisocial.domain.entities.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getUsersList() {
		return userRepository.getUsersList();
	}
}
