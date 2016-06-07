package com.emad.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emad.model.Tag;

@Repository
public interface TagDao extends CrudRepository<Tag, Long>{

	List<Tag> findByIdIn(List<Long> ids);

}
