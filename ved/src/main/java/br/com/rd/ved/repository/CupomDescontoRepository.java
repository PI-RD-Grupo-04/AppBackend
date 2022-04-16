package br.com.rd.ved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.CupomDesconto;

@Repository
public interface CupomDescontoRepository extends CrudRepository<CupomDesconto,Integer>{

}
