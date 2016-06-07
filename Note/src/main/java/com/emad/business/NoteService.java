package com.emad.business;

import java.util.Date;
import java.util.List;

import com.emad.model.Note;
import com.emad.model.Tag;


public interface NoteService {

	Note createNote(Note note);
	public List<Note>getAllNotes();
	List<Note> getNotesByDate(Date date);
	Note getNote(Long id);
	List<Note> getNotesByTag(Long tag);
}
