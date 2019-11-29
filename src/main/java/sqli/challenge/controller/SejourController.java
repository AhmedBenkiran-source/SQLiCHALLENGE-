package sqli.challenge.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import sqli.challenge.model.Sejour;
import sqli.challenge.service.SejourServiceImpl;

@RestController
@RequestMapping("/sejour")
public class SejourController {

	@Autowired
	private SejourServiceImpl sejourService;

	@SuppressWarnings("deprecation")
	@GetMapping("/all-pagination")
	public Page<Sejour> getAllDomainePagination(@RequestParam(defaultValue = "0") int page) {
		return sejourService.getAllSejourPagination(new PageRequest(page, 4));
	}

	@GetMapping("/all")
	public List<Sejour> getAllSejour() {
		return sejourService.getAllSejour();
	}

	@PutMapping
	public Sejour updateSejour(@RequestParam("sejour") String sejour,@RequestParam("user") String user) throws JsonParseException, JsonMappingException, IOException {
		return sejourService.createOrUpdateSejour(sejour,user);
	}

	@PostMapping
	public Sejour createSejour(@RequestParam("sejour") String sejour,@RequestParam("user") String user) throws JsonParseException, JsonMappingException, IOException {
		return sejourService.createOrUpdateSejour(sejour,user);
	}

	@DeleteMapping("{id}")
	public Long deleteSejour(@PathVariable Long id) {
		sejourService.deleteSejour(id);
		return id;
	}
}
