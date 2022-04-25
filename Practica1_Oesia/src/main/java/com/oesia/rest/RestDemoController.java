package com.oesia.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oesia.model.Fecha;
import com.oesia.repo.IFechaRepo;

@RestController
@RequestMapping("/fechas")
public class RestDemoController {
	
	@Autowired
	private IFechaRepo repo;
	
	//Get -> Obtencion de datos
	//Post -> Insercion de datos
	//Put -> Actualizacion total de datos
	//Delete -> Eliminacion de datos
	@GetMapping
	public List<Fecha> listar(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody Fecha per){
		repo.save(per);
	}
	
	@PutMapping
	public void modificar(@RequestBody Fecha per){
		repo.save(per);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}
}
