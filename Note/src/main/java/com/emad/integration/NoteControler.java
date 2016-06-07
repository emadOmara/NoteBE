package com.emad.integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emad.business.NoteService;
import com.emad.business.TagService;
import com.emad.model.Note;
import com.emad.model.NoteDTO;
import com.emad.model.Tag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/notes/")

public class NoteControler {

	@Autowired
	private NoteService noteService;
	@Autowired
	private TagService tagService;

	// TODO remove dto and use custom deserializer
	@RequestMapping(method = RequestMethod.POST)
	public void createNote(@RequestBody NoteDTO noteDto) {
		Note n = new Note();
		n.setCreatedDate(noteDto.getCreatedDate());
		n.setDescription(noteDto.getDescription());
		n.setTitle(noteDto.getTitle());
		List<Tag> tags = tagService.getTagsWitIds(noteDto.getTag());
		n.setTags(tags);
		n = noteService.createNote(n);
		System.out.println("NoteControler.createNote()");
	}
	 

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody NoteDTO getNote(@PathVariable(value = "id") Long id) {
		  Note note = noteService.getNote(id);
		  return convertToDTO(note);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<NoteDTO> getAllNotes() {
		  List<Note> allNotes = noteService.getAllNotes();
		  List<NoteDTO>result=new ArrayList<NoteDTO>();
		  for (Note note : allNotes) {
			  result.add(convertToDTO(note));
			
		}
		  return result;
	}

	@RequestMapping(value = "/date/{date}", method = RequestMethod.GET)
	public @ResponseBody List<NoteDTO> getNotesByDate(@PathVariable(value = "date") Date date) {
		 List<Note> allNotes = noteService.getNotesByDate(date);
		  List<NoteDTO>result=new ArrayList<NoteDTO>();
		  for (Note note : allNotes) {
			  result.add(convertToDTO(note));
			
		}
		  return result;
		  
	}

	@RequestMapping(value = "/{tag}", method = RequestMethod.GET)
	public @ResponseBody List<NoteDTO> getNotesByDate(@PathVariable(value = "tag") Long tag) {
		 List<Note> allNotes = noteService.getNotesByTag(tag);
		  List<NoteDTO>result=new ArrayList<NoteDTO>();
		  for (Note note : allNotes) {
			  result.add(convertToDTO(note));
			
		}
		  return result;
		  
	}

	private NoteDTO convertToDTO(Note note) {
		NoteDTO dto = new NoteDTO();
		dto.setCreatedDate(note.getCreatedDate());
		dto.setDescription(note.getDescription());
		dto.setId(note.getId());
		dto.setTitle(note.getTitle());
		List<Tag> tags = note.getTags();
		List<Long> ids = new ArrayList<Long>();
		for (Tag t : note.getTags()) {
			ids.add(t.getId());
		}
		dto.setTag(ids);
		return dto;
	}
}
