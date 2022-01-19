package xyz.yoandroide.persona.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.yoandroide.persona.model.Cliente;
import xyz.yoandroide.persona.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente/")
public class ClienteREST {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Lista todos
	@GetMapping
	private ResponseEntity<List<Cliente>> getAllCliente (){
		return ResponseEntity.ok(clienteRepository.findAll());
		
	}
	
	//Busca por id
	@GetMapping ("{id}")
	private ResponseEntity<Optional<Cliente>> getById (@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(clienteRepository.findById(id));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

	}
	
	//Crear
	@PostMapping
	private ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
		try {
			Cliente clienteGuardada=clienteRepository.save(cliente);
			return ResponseEntity.created(new URI("/cliente/"+clienteGuardada.getId())).body(clienteGuardada);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
	}

	//Edita
	@PutMapping ("{id}")
	public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente clienteNewDetails) {
		Cliente cliente=clienteRepository.findById(id);
		cliente.setNombre(clienteNewDetails.getNombre());
		cliente.setApellido(clienteNewDetails.getApellido());
	}

	
	//Elimina
	@DeleteMapping ("{id}")
	private ResponseEntity<Optional<Cliente>> delete(@PathVariable Long id){
		try {
			clienteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

}
