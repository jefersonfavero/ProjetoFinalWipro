package Wipro.servicee;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import Wipro.model.Client;
import Wipro.repository.ClientRepository;

public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ResponseEntity<Client> findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		}
		return ResponseEntity.notFound().build();
	}
	

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	
//	public Client update(String id, Client obj) {
//		Client newObj = findById(id);
//		
//		newObj.setNome(obj.getNome());
//		newObj.setSobrenome(obj.getSobrenome());
//		newObj.setEmail(obj.getEmail());
//		newObj.setSenha(obj.getSenha());
//		return clientRepository.save(newObj);
//	}
//	
//	public Client create(Client obj) {
//		return clientRepository.save(obj);
//	}
//	
//	public void delete(String id) {
//		findById(id); 
//		clientRepository.deleteById(id);
//	}
}
