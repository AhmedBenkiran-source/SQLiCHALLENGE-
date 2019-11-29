package sqli.challenge.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import sqli.challenge.model.Note;
import sqli.challenge.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@SuppressWarnings("deprecation")
	@GetMapping("/all-pagination")
	public Page<Note> getAllNotePagination(@RequestParam(defaultValue = "0") int page) {
		return noteService.getAllNotePagination(new PageRequest(page, 4));
	}

	@GetMapping("/all")
	public List<Note> getAllNote() {
		return noteService.getAllNote();
	}

	@PutMapping
	public Note updateNote(@RequestParam("activite") String activite,@RequestParam("sejour") String sejour,@RequestParam("description") String description) throws JsonParseException, JsonMappingException, IOException {
		return noteService.createOrUpdateNote(activite,sejour,description);
	}
	@PostMapping
	public Note createNote(@RequestParam("activite") String activite,@RequestParam("sejour") String sejour,@RequestParam("description") String description) throws JsonParseException, JsonMappingException, IOException {
		return noteService.createOrUpdateNote(activite,sejour,description);
	}

	
}
