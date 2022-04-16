package br.com.rd.ved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.HistoricoPedido;

@Repository
public interface HistoricoPedidoRepository extends CrudRepository<HistoricoPedido,Integer>{

}
