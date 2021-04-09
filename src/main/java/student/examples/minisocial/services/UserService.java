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
		return userRepository.findById(id).orElse(null);
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

	public List<User> getUsersFriendsList(int id) {
		return userRepository.findById(id)
				.map(User::getFriendTo).orElse(null);
	}


	public void addUserFriend(User user, User friend) {
		user.addFriend(friend);
		userRepository.save(user);
	}

	public void removeUserFriend(User user, User friend) {
		user.removeFriend(friend);
		userRepository.save(user);
	}

	public String checkFriends(int id, int friendId, Operation operation) {
		if (id == friendId)
			return "The user and friend id cannot be identical!";

		User user = getUserById(id);
		User friend = getUserById(friendId);

		if (user == null) return "No user with such id - " + id;
		if (friend == null) return "No friend with such id - " + friendId;

		return proceedWithOperation(user, friend, operation);
	}

	private String proceedWithOperation(User user, User friend, Operation operation) {
		boolean areFriends = user.getFriendTo().contains(friend);

		switch (operation) {
			case ADD:
				if (areFriends)
					return "Users are friends already!";

				addUserFriend(user,friend);
				return "Users " + user.getId() + " and " +
						friend.getId() + " have become friends";
			case REMOVE:
				if (!areFriends)
					return "Users are not friends!";

				removeUserFriend(user, friend);
				return "Users " + user.getId() + " and " +
						friend.getId() + " are no more friends";
			default:
				return "No such operation";
		}
	}

	public enum Operation {
		REMOVE,
		ADD
	}
}