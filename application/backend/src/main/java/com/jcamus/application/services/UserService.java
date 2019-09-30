/**
 * 
 */
package com.jcamus.application.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jcamus.application.entities.User;
import com.jcamus.application.repositories.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author camusj
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserService implements IUserService<User, Long> {

	@Autowired
	private final IUserRepository userRepository;
	
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@GetMapping("/users")
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	@GetMapping("/users/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> var1) {
		return (List<S>) userRepository.saveAll(var1);
	}

	@Override
	@PostMapping("/users")
	public <S extends User> S save(@RequestBody S var1) {
		return userRepository.save(var1);
	}

	@Override
	@DeleteMapping("/users/{id}")
	public User delete(@PathVariable(name = "id") Long var1) {
		User user = this.findById(var1);
		userRepository.deleteById(var1);
		return user;
	}

	@Override
	public Map<String, List<User>> findAllGroupByGroupId() {
		Map<String, List<User>> map = new HashMap<>();
		this.findAll().forEach(user -> {
			map.computeIfAbsent(user.getGroupId(), k -> new ArrayList<User>()).add(user);
		});
		return map;
	}

	@GetMapping("/users/groupedbyid")
	public List<User> listAllGroupByGroupId() {
		Map<String, List<User>> map = findAllGroupByGroupId();
		List<User> users = new ArrayList<>();
		for (String k : map.keySet()) {
			users.addAll(map.get(k));
		}
		return users;
	}
}
