package student.examples.minisocial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import student.examples.minisocial.domain.entities.User;
import student.examples.minisocial.services.UserService;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User>  index() {
		 return userService.getUsersList();
	}

	@GetMapping("/users/")
	public User show(@RequestParam int id) {
		return userService.getUserById(id);
	}
}
