package br.com.rd.ved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido,Integer>{

}
