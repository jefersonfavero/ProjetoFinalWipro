package Wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Wipro.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
