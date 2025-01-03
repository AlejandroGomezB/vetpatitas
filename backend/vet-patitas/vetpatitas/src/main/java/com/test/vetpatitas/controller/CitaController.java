package com.test.vetpatitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.vetpatitas.entity.CitaEntity;
import com.test.vetpatitas.service.CitaService;

@RestController
public class CitaController {
	
	@Autowired
	public CitaService citaService;
	
	@GetMapping(value= "/citas", produces = "application/json")
	public ResponseEntity<List<CitaEntity>> obtenerCitas(){
		List<CitaEntity> citas = citaService.getCita();
		if(citas != null && !citas.isEmpty()) {
			return new ResponseEntity<List<CitaEntity>>(citas, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<CitaEntity>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/citas/{id_cita}", produces = "application/json")
	public ResponseEntity<CitaEntity> obtenerCita(@PathVariable("id_cita") int id){
		CitaEntity cita = citaService.getCitaId(id);
		if(cita != null ) {
			return new ResponseEntity<CitaEntity>(cita, HttpStatus.OK);
		}else {
			return new ResponseEntity<CitaEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value= "/citas",consumes ="application/json",  produces = "application/json")
	public ResponseEntity<CitaEntity> registrarCita(@RequestBody CitaEntity citaNueva ){
		CitaEntity cita = citaService.setCita(citaNueva);
		if(cita != null ) {
			return new ResponseEntity<CitaEntity>(cita, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<CitaEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value= "/citas/{id_cita}")
	public ResponseEntity<CitaEntity> eliminarCita(@PathVariable("id_cita") int id ){
		CitaEntity cita = citaService.deleteCita(id);
		if(cita == null ) {
			return new ResponseEntity<CitaEntity>(cita, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<CitaEntity>(HttpStatus.NOT_FOUND);
		}
	}
}
