package com.java.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.platform.model.Ticket;
import com.java.platform.service.TicketService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tickets")
public class TicketController
{	// repository field con autowired per d.i.
	// private @Autowired TicketRepository ticketRepository;
	
	private @Autowired TicketService ticketService;
	
	@GetMapping()
	public  String index (Model model, @RequestParam(required = false) String search) 
	{
		model.addAttribute("ticketSearch", search);
		
		List<Ticket> ticketList;
		
		if (search != null && !search.isEmpty())
		{
			model.addAttribute("ticketSearch", search);
			ticketList = ticketService.findByTitle(search);
		}
		else
		{
			ticketList = ticketService.findAllSortedByRecent();
		}
		
		model.addAttribute("tickets", ticketList);
		
		return "/tickets/index";
	}
	
	
	@GetMapping ("/findByTitle/{title}")
	public String findByTitle(@PathVariable("title") String title, Model model)
	{
		model.addAttribute("tickets", ticketService.findAllByTitle(title));
		return "/tickets/index";
	}
	
	
	
	//SHOW
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model model)
	{
		model.addAttribute("ticket", ticketService.getById(id));
		return "/tickets/show";
	}

	
	//CREATE
	
	@GetMapping("/create")
	public String ticket(Model model)
	{
		model.addAttribute("ticket", new Ticket());
		return "/tickets/create";
	}

	
	
	//STORE
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("ticket") Ticket formTicket,
						BindingResult bindingResult,
						RedirectAttributes attributes,
						Model model)
	{
		if (bindingResult.hasErrors())
		{
			return "/tickets/create";
		}
		else
		{
			ticketService.create(formTicket);
			
			attributes.addFlashAttribute("typeAlert", "success");
			attributes.addFlashAttribute("messageAlert", "Great news! '" + formTicket.getTitle() + "' has been added successfully");
			
			return "redirect:/tickets";
		}	
	}
	
	
	
	//EDIT & UPDATE
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model)
	{
		model.addAttribute("ticket", ticketService.getById(id));
		return "/tickets/edit";
	}
	
	
	
	@PostMapping("/edit/{id}")
	public String update( //@PathVariable("id") Integer id, 
						@Valid @ModelAttribute("ticket") Ticket updatedformTicket,
						BindingResult bindingResult,
						Model model,
						RedirectAttributes redirectAttributes)
	{
		
		// If there are validation errors, stay on the edit page
		if(bindingResult.hasErrors())
		{
			//model.addAttribute("ticket", updatedformTicket);
			return "/tickets/edit";
		}
		
		//updatedformTicket.setId(id); 
		// Update the ticket
		ticketService.update(updatedformTicket);
		
		// Add success message to flash attributes
		redirectAttributes.addFlashAttribute("typeAlert", "warning");
		redirectAttributes.addFlashAttribute("messageAlert", "The ticket " + updatedformTicket.getTitle() + " has been updated successfully");

		// Redirect to the tickets index page after successful update
		return "redirect:/tickets";
	}
	
	
	//DELETE
	
	@PostMapping ("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes)
	{
		ticketService.deleteById(id);
		
		redirectAttributes.addFlashAttribute("typeAlert", "danger");
		redirectAttributes.addFlashAttribute("messageAlert", "The ticket has been removed successfully");
		
		return "redirect:/tickets";
	}


	
}
