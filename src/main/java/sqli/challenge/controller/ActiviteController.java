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

import sqli.challenge.model.Activite;
import sqli.challenge.service.ActiviteServiceImpl;

@RestController
@RequestMapping("/activite")
public class ActiviteController {

	@Autowired
	private ActiviteServiceImpl activiteService;

	@SuppressWarnings("deprecation")
	@GetMapping("/all-pagination")
	public Page<Activite> getAllActivitePagination(@RequestParam(defaultValue = "0") int page) {
		return activiteService.getAllActivitePagination(new PageRequest(page, 4));
	}

	@GetMapping("/all")
	public List<Activite> getAllActivite() {
		return activiteService.getAllActivite();
	}

	@PutMapping
	public Activite updateActivite(@RequestParam("activite") String activite,@RequestParam("domaine") String domaine) throws JsonParseException, JsonMappingException, IOException {
		return activiteService.createOrUpdateActivite(activite,domaine);
	}

	@PostMapping
	public Activite createActivite(@RequestParam("activite") String activite,@RequestParam("domaine") String domaine) throws JsonParseException, JsonMappingException, IOException {
		return activiteService.createOrUpdateActivite(activite,domaine);
	}

	@DeleteMapping("{id}")
	public Long deleteActivite(@PathVariable Long id) {
		activiteService.deleteActivite(id);
		return id;
	}
}
