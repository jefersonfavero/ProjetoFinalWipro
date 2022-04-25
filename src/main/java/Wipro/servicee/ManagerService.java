package Wipro.servicee;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import Wipro.model.Manager;
import Wipro.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	//@GetMapping getAll
	public List<Manager> findAll() {
		return managerRepository.findAll();
	}

	//@GetMapping getById
	public ResponseEntity<Manager> findById(Integer id) {
		Optional<Manager> obj = managerRepository.findById(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		}
		return ResponseEntity.notFound().build();
	}

	//@PostMapping post
	public Manager create(Manager obj) {
		return managerRepository.save(obj);
	}
	
	//@PutMapping put
	public Manager update(Integer id, Manager manager) {
		Manager obj = managerRepository.getById(id);
		obj.setName(manager.getName());
		obj.setCPF(manager.getCPF());
		obj.setAddress(manager.getAddress());
		return managerRepository.save(obj);

//		Manager.setName(obj.getName());
//		Manager.setCPF(obj.getCPF());
//		Manager.setAddress(obj.getAddress());
//		
//		return managerRepository.save(Manager);
	}

	//@DeleteMapping delete
	public ResponseEntity<Manager> delete(Integer id) {
		Optional<Manager> optional = managerRepository.findById(id);
		if (optional.isPresent()) {
			managerRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
//		findById(id); 
//		managerRepository.deleteById(id);
	}
}
