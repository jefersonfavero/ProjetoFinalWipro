package Wipro.servicee;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import Wipro.model.Client;
import Wipro.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	//@GetMapping getAll
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	//@GetMapping getById
	public ResponseEntity<Client> findById(Integer id) {
		Optional<Client> obj = clientRepository.findById(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		}
		return ResponseEntity.notFound().build();
	}

	//@PostMapping post
	public Client create(Client obj) {
		return clientRepository.save(obj);
	}
	
	//@PutMapping put
	public Client update(Long id, Client client) {
		Client obj = clientRepository.getById(id);
		obj.setName(client.getName());
		obj.setCPF(client.getCPF());
		obj.setAddress(client.getAddress());
		return clientRepository.save(obj);

//		client.setName(obj.getName());
//		client.setCPF(obj.getCPF());
//		client.setAddress(obj.getAddress());
//		
//		return clientRepository.save(client);
	}

	//@DeleteMapping delete
	public ResponseEntity<Client> delete(Long id) {
		Optional<Client> optional = clientRepository.findById(id);
		if (optional.isPresent()) {
			clientRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
//		findById(id); 
//		clientRepository.deleteById(id);
	}
}
