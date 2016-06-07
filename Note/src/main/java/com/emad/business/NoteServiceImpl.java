package com.emad.business;

import java.util.Date;
import java.util.List;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emad.dao.NoteDao;
import com.emad.dao.TagDao;
import com.emad.model.Note;
import com.emad.model.Tag;

@Service
public class NoteServiceImpl implements NoteService{

	
	@Autowired
	private NoteDao noteDao;
	@Autowired
	private TagDao tagDao;

	@Override
	public Note createNote(Note note) {
		return noteDao.save(note);
		
	}

	@Override
	public List<Note> getAllNotes() {
		return (List<Note>) noteDao.findAll();
	}

	@Override
	public List<Note> getNotesByDate(Date date) {
		return (List<Note>) noteDao.findByCreatedDate(date);
	}
	@Override
	public List<Note> getNotesByTag(Long id) {
		return (List<Note>) noteDao.findNotesByTag(id);
	}

	@Override
	public Note getNote(Long id) {
	 
		return noteDao.findOne(id);
	}
	 

	 

}
