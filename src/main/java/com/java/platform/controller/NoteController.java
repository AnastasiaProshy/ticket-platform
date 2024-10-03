package com.java.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.platform.model.Note;
import com.java.platform.service.NoteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/notes")
public class NoteController {
	
	private @Autowired NoteService noteService;
	
	//CREATE
	
	@GetMapping("/create")
	public String note(Model model)
	{
		model.addAttribute("note", new Note());
		return "/notes";
	}

	
	
	//STORE
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("note") Note formNote,
						BindingResult bindingResult,
						RedirectAttributes attributes,
						Model model)
	{
		if (bindingResult.hasErrors())
		{
			return "/notes";
		}
		else
		{
			noteService.create(formNote);
			
			attributes.addFlashAttribute("typeAlert", "success");
			attributes.addFlashAttribute("messageAlert", "Great news! '" + formNote.getTitle() + "' has been added successfully");
			
			return "redirect:/notes";
		}	
	}


}
