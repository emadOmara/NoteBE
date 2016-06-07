package com.emad.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emad.dao.TagDao;
import com.emad.model.Tag;

@Service
public class TagServiceImpl implements TagService{

	 
	@Autowired
	private TagDao tagDao;

	@Override
	public Tag createTag(Tag tag) {
		return tagDao.save(tag);
	}

	@Override
	public List<Tag> getAllTags() {
		return (List<Tag>) tagDao.findAll();
	}

	@Override
	public List<Tag> getTagsWitIds(List<Long> ids) {
		return tagDao.findByIdIn(ids);

	}
 
	 

}
