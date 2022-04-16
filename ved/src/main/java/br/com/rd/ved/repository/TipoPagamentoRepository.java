package br.com.rd.ved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.TipoPagamento;

@Repository
public interface TipoPagamentoRepository extends CrudRepository<TipoPagamento,Integer>{

}
