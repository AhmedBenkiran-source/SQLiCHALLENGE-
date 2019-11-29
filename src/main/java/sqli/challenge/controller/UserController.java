package sqli.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sqli.challenge.model.User;
import sqli.challenge.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	@SuppressWarnings("deprecation")
	@GetMapping("/all-pagination")
	public Page<User> getAllUserPagination(@RequestParam(defaultValue = "0") int page) {
		return userService.getAllUserPagination(new PageRequest(page, 4));
	}

	@GetMapping("/all")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}


	@DeleteMapping("{id}")
	public Long deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return id;
	}
}
