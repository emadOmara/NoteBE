package com.emad.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emad.model.Note;

@Repository
public interface NoteDao extends CrudRepository<Note, Long>{

	List<Note> findByCreatedDate(Date date);

	 @Query("select n from Note n join n.tags t where t.id = :id")
	List<Note> findNotesByTag(@Param("id") Long  id);

}
