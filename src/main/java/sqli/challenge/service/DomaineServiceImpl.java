package sqli.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import sqli.challenge.model.Domaine;
import sqli.challenge.repository.DomaineRepository;
@Service
public class DomaineServiceImpl implements DomaineService {
	
	@Autowired
	private DomaineRepository domaineRepository;
	@Override
	public Page<Domaine> getAllDomainePagination(PageRequest pageRequest){
		return domaineRepository.findAll(pageRequest);
	}
	@Override
	public List<Domaine> getAllDomaine() {
		return domaineRepository.findAll();
	}
	@Override
	public Domaine createOrUpdateDomaine(Domaine domaine) {
		return domaineRepository.save(domaine);
	}
	@Override
	public Long deleteDomaine(Long id) {
		domaineRepository.deleteById(id);
		return id;
	}

}
