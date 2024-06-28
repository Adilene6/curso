package com.persona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persona.modelo.Persona;
import com.persona.repository.PersonaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



/*RECURSOS, ENDPOINTS, CONTRATO DE INTERFAZ, VERBOS
 * 
 * GET    PUT       DELETE         POST        OPTIONS
 * list    update     delete        save         ----
 * select   update      delete       insert      ----
 * 
 * */
@CrossOrigin(origins = "http://localhost:4200/",  maxAge = 3600)
@RestController
@RequestMapping({ "personas"})
public class PersonaController {
	
	@Autowired
	private PersonaRepository repository;
	
	
	
	@GetMapping("listar")
	public List<Persona> listPersonas() {
		List<Persona> personas=
				(List<Persona>) repository.findAll();
		return personas;
	}
	
	
	//ENDPOINT, RECURSO
	//URI: http://localhost:7575/personas/  method post
	@PostMapping
	public Persona agregarPersona(@RequestBody Persona persona) {
		return repository.save(persona);
		
	}
	
	@GetMapping("{id}")
	public Optional<Persona> getPersonaById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	//ENDPOINT, RECURSO
	//URI: http://localhost:7575/personas/id
	
	@PutMapping("/{id}")
	public Persona modificaPersona(@RequestBody int id, @PathVariable Persona persona) {
		persona.setId(id);
		//TODO: process PUT request
		
		return repository.save(persona);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarpersona(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	

}
