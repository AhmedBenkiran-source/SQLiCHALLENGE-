package sqli.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import sqli.challenge.model.User;
import sqli.challenge.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User> getAllUserPagination(PageRequest pageRequest){
		return userRepository.findAll(pageRequest);
	}
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	@Override
	public User createOrUpdateUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public Long deleteUser(Long id) {
		userRepository.deleteById(id);
		return id;
	}

}
