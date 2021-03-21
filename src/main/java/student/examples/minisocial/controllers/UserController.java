package student.examples.minisocial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

	@GetMapping("/users/{id}")
	public User show(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	public String destroy(@PathVariable int id) {
		userService.deleteUserById(id);
		return "User with id=" + id + " deleted!";
	}

	@PostMapping(value = "/users/new", consumes = MediaType.APPLICATION_JSON_VALUE)
		public String create(@RequestBody User user) {
		userService.saveUser(user);
		return "User: " + user.toString() + " \ncreated!";
	}

	@PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody User user, @PathVariable int id) {
		userService.updateUser(id, user);
		return "User with id=" + id + " updated!";
	}
}
