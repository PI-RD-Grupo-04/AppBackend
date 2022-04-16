package br.com.rd.ved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,Integer>{

}
