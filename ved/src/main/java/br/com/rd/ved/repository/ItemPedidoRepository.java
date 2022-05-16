package br.com.rd.ved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.PedidoProdutoID;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, PedidoProdutoID>, CrudRepository<ItemPedido,PedidoProdutoID>{

}
