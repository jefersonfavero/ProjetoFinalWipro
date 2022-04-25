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
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping(path = "/client")
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private ClientService clientService;
//		@Autowired
//		private EnderecoclientService clientServiceEndereco;

	@GetMapping
	public ResponseEntity<List<Client>> GetAll() {
		List<Client> clients = clientService.findAll();
		return ResponseEntity.ok().body(clients);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> GetById(@PathVariable Long id) {
		Client obj = clientService.findById(id);
		return ResponseEntity.status(200).body(obj);//ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Client> Post(@RequestBody Client Client) {
		Client Obj = clientService.create(Client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Obj.getId()).toUri();
		System.out.println(uri);
//			return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(Client));
		return ResponseEntity.created(uri).build();
	}

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

	@PutMapping("/{id}")
	public ResponseEntity<Client> Put(@PathVariable Long id, @RequestBody Client client) {
		Client obj = clientService.update(id, client);
		return ResponseEntity.status(200).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
