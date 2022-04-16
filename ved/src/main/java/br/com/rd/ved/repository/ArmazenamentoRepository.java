package br.com.rd.ved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.Armazenamento;

@Repository
public interface ArmazenamentoRepository extends CrudRepository<Armazenamento,Integer>{

}
