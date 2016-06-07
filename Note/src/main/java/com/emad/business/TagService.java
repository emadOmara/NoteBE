package com.emad.business;

import java.util.List;

import com.emad.model.Tag;


public interface TagService {

	Tag createTag(Tag  tag);
	public List<Tag>getAllTags();
	public List<Tag>getTagsWitIds(List<Long> ids);
	 
}
