package sqli.challenge.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sqli.challenge.model.Activite;
import sqli.challenge.model.Note;
import sqli.challenge.model.Sejour;
import sqli.challenge.repository.NoteRepository;
@Service
public class NoteServiceImpl implements NoteService{

	
	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public Page<Note> getAllNotePagination(PageRequest pageRequest) {
		return noteRepository.findAll(pageRequest);
	}

	@Override
	public List<Note> getAllNote() {
		return noteRepository.findAll();
	}

	@Override
	public Note createOrUpdateNote(String acti, String sej, String description) throws JsonParseException, JsonMappingException, IOException {
		Activite activite = new ObjectMapper().readValue(acti, Activite.class);
		Sejour sejour = new ObjectMapper().readValue(sej, Sejour.class);
		Note note = new Note();
		note.setDescription(description);
		note.getPk().setActivite(activite);
		note.getPk().setSejour(sejour);
		return noteRepository.save(note);
	}

}
