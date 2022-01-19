package xyz.yoandroide.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.yoandroide.persona.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
