package sqli.challenge.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import sqli.challenge.model.Activite;

public interface ActiviteService {

	public Page<Activite> getAllActivitePagination(PageRequest pageRequest);
	public List<Activite> getAllActivite();
	public Activite createOrUpdateActivite(String acti , String dom) throws JsonParseException, JsonMappingException, IOException;
	public Long deleteActivite(Long id);
}
