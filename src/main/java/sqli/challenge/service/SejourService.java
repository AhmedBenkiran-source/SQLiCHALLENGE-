package sqli.challenge.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import sqli.challenge.model.Sejour;

public interface SejourService {

	public Page<Sejour> getAllSejourPagination(PageRequest pageRequest);
	public List<Sejour> getAllSejour();
	public Sejour createOrUpdateSejour(String sej , String use) throws JsonParseException, JsonMappingException, IOException;
	public Long deleteSejour(Long id);
}
