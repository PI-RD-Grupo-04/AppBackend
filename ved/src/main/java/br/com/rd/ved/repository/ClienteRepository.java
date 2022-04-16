package br.com.rd.ved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer>{

}
