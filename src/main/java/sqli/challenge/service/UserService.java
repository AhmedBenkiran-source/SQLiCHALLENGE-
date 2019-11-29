package sqli.challenge.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import sqli.challenge.model.User;

public interface UserService {

	public Page<User> getAllUserPagination(PageRequest pageRequest);
	public List<User> getAllUser();
	public User createOrUpdateUser(User user);
	public Long deleteUser(Long id);
}
