package com.java.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.platform.model.Note;
import com.java.platform.repository.NoteRepository;


@Service	// the one who @serves the controller, puts between the controller and repository, so no longer have the repository in controller but in service
public class NoteService {
	
	private @Autowired NoteRepository noteRepository;
	
	
	public Note create(Note note)
	{
		return noteRepository.save(note);
	}
	
	
	public Note update(Note note)
	{
		return noteRepository.save(note);
	}
	
	
	public void deleteById(Integer id)
	{
		noteRepository.deleteById(id);
	}

	
}
