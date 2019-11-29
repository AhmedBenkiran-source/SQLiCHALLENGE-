package sqli.challenge.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sqli.challenge.model.Sejour;
import sqli.challenge.model.User;
import sqli.challenge.repository.SejourRepository;
import sqli.challenge.repository.UserRepository;
@Service
public class SejourServiceImpl implements SejourService {
	
	@Autowired
	private SejourRepository sejourRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public Page<Sejour> getAllSejourPagination(PageRequest pageRequest){
		return sejourRepository.findAll(pageRequest);
	}
	@Override
	public List<Sejour> getAllSejour() {
		return sejourRepository.findAll();
	}
	@Override
	public Sejour createOrUpdateSejour(String sej , String use) throws JsonParseException, JsonMappingException, IOException {
		Sejour sejour = new ObjectMapper().readValue(sej, Sejour.class);
		Optional<User> user = userRepository.findById(Long.parseLong(use));
		sejour.setUser(user.get());
		return sejourRepository.save(sejour);
	}
	@Override
	public Long deleteSejour(Long id) {
		sejourRepository.deleteById(id);
		return id;
	}

}
