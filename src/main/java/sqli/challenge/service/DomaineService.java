package sqli.challenge.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import sqli.challenge.model.Domaine;

public interface DomaineService {

	public Page<Domaine> getAllDomainePagination(PageRequest pageRequest);
	public List<Domaine> getAllDomaine();
	public Domaine createOrUpdateDomaine(Domaine domaine);
	public Long deleteDomaine(Long id);
}
