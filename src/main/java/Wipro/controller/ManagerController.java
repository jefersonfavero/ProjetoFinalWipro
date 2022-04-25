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

import Wipro.model.Manager;
import Wipro.servicee.ManagerService;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping(path = "/Manager")
@CrossOrigin("*")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
//		@Autowired
//		private EnderecomanagerService managerServiceEndereco;

	@GetMapping
	public ResponseEntity<List<Manager>> GetAll() {
		List<Manager> managers = managerService.findAll();
		return ResponseEntity.ok().body(managers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Manager> GetById(@PathVariable Integer id) {
		Manager obj = managerService.findById(id);
		return ResponseEntity.status(200).body(obj);//ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Manager> Post(@RequestBody Manager manager) {
		Manager Obj = managerService.create(manager);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Obj.getId()).toUri();
		System.out.println(uri);
//			return ResponseEntity.status(HttpStatus.CREATED).body(managerService.create(Manager));
		return ResponseEntity.created(uri).build();
	}

//		@PostMapping("/associarEnderecoManager/{id}")
//		public ResponseEntity<Manager> associarCurso(@PathVariable Integer idEndereco, @RequestBody Manager Manager) {
//			
//			Endereco endereco = managerServiceEndereco.findById(idEndereco);
//			Manager = managerService.findById(Manager.getId());
//			
//			endereco.getManagers().add(Manager);
//			managerServiceEndereco.create(endereco);
//			
//			return ResponseEntity.status(200).body(Manager);
//			
//		}

	@PutMapping("/{id}")
	public ResponseEntity<Manager> Put(@PathVariable Integer id, @RequestBody Manager manager) {
		Manager obj = managerService.update(id, manager);
		return ResponseEntity.status(200).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Integer id) {
		managerService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
