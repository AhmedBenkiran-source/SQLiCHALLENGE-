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

import sqli.challenge.model.Activite;
import sqli.challenge.model.Domaine;
import sqli.challenge.repository.ActiviteRepository;
import sqli.challenge.repository.DomaineRepository;
@Service
public class ActiviteServiceImpl implements ActiviteService{
	
	@Autowired
	private ActiviteRepository activiteRepository;
	
	@Autowired
	private DomaineRepository domaineRepository;
	
	public Page<Activite> getAllActivitePagination(PageRequest pageRequest){
		return activiteRepository.findAll(pageRequest);
	}
	
	public List<Activite> getAllActivite() {
		return activiteRepository.findAll();
	}

	public Activite createOrUpdateActivite(String acti , String dom) throws JsonParseException, JsonMappingException, IOException {
		Activite activite = new ObjectMapper().readValue(acti, Activite.class);
		Optional<Domaine> domaine = domaineRepository.findById(Long.parseLong(dom));
		activite.setDomaine(domaine.get());
		return activiteRepository.save(activite);
	}
	
	public Long deleteActivite(Long id) {
		activiteRepository.deleteById(id);
		return id;
	}

}
