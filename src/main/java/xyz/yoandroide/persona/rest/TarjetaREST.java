package xyz.yoandroide.persona.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.yoandroide.persona.model.Tarjeta;
import xyz.yoandroide.persona.repository.TarjetaRepository;

@RestController
@RequestMapping ("/tarjeta/")
public class TarjetaREST {
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	//lista las tarjetas
	@GetMapping
	private ResponseEntity<List<Tarjeta>> getAllTarjeta(){
		return ResponseEntity.ok(tarjetaRepository.findAll());
	}
	
	//Encuentra la tarjeta por numero
	@GetMapping ("numero/{numero}")
	private ResponseEntity<Optional<Tarjeta>> getById(@PathVariable Long numero){
		return ResponseEntity.ok(tarjetaRepository.findById(numero));}

}
