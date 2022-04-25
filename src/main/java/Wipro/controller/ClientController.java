package Wipro.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Wipro.model.Client;
import Wipro.servicee.ClientService;

@RestController
@RequestMapping(path = "/Client")
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private ClientService clientService;
//		@Autowired
//		private EnderecoclientService clientServiceEndereco;

	@GetMapping
	public List<Client> GetAll() {
		List<Client> clients = clientService.findAll();
		return clients ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> GetById(@PathVariable Long id) {
		ResponseEntity<Client> obj = this.clientService.findById(id);
		return ResponseEntity.ok(obj.getBody());//ResponseEntity.ok().body(obj);
	}

//	@PostMapping
//	public ResponseEntity<Client> Post(@RequestBody Client Client) {
//		Client newObj = clientService.create(Client);
//
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
//		System.out.println(uri);
//
////			return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(Client));
//		return ResponseEntity.created(uri).build();
//	}

//		@PostMapping("/associarEnderecoClient/{id}")
//		public ResponseEntity<Client> associarCurso(@PathVariable Integer idEndereco, @RequestBody Client Client) {
//			
//			Endereco endereco = clientServiceEndereco.findById(idEndereco);
//			Client = clientService.findById(Client.getId());
//			
//			endereco.getClients().add(Client);
//			clientServiceEndereco.create(endereco);
//			
//			return ResponseEntity.status(200).body(Client);
//			
//		}

//	@PutMapping("/{id}")
//	public ResponseEntity<Client> Put(@PathVariable String id, @RequestBody Client obj) {
//		Client newClient = clientService.update(id, obj);
//		return ResponseEntity.status(200).body(newClient);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> Delete(@PathVariable String id) {
//		clientService.delete(id);
//		return ResponseEntity.noContent().build();
//	}

}
