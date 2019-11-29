package sqli.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sqli.challenge.model.Domaine;
import sqli.challenge.service.DomaineServiceImpl;

@RestController
@RequestMapping("/domaine")
public class DomaineController {

	@Autowired
	private DomaineServiceImpl domaineService;

	@SuppressWarnings("deprecation")
	@GetMapping("/all-pagination")
	public Page<Domaine> getAllDomainePagination(@RequestParam(defaultValue = "0") int page) {
		return domaineService.getAllDomainePagination(new PageRequest(page, 4));
	}

	@GetMapping("/all")
	public List<Domaine> getAllDomaine() {
		return domaineService.getAllDomaine();
	}

	@PutMapping
	public Domaine updateDomaine(@RequestBody Domaine domaine) {
		return domaineService.createOrUpdateDomaine(domaine);
	}

	@PostMapping
	public Domaine createDomaine(@RequestBody Domaine domaine) {
		return domaineService.createOrUpdateDomaine(domaine);
	}

	@DeleteMapping("{id}")
	public Long deleteDomaine(@PathVariable Long id) {
		domaineService.deleteDomaine(id);
		return id;
	}
}
