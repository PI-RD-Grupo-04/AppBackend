package br.com.rd.ved.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoStatus;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>, CrudRepository<Pedido,Integer>{

	 List<Pedido> findByClienteId(Integer idCliente);
	
	 @Query(value = "select * from cliente where id_cliente = id ",
			nativeQuery = true)
	 Cliente encontrarClientePorId(@Param("id") Integer id);
	 
	 @Query(value = "select * from Cupom_desconto where id_cupom_desconto = id ",
				nativeQuery = true)
	 CupomDesconto encontrarCupomPorId(@Param("id") Integer id);
	 
	 @Query(value = "select * from pedido_status where id_pedido_status = id ",
				nativeQuery = true)
	 PedidoStatus encontrarStatusPorId(@Param("id") Integer id);
	 
	 @Query(value = "select * from frete where id_frete = id ",
				nativeQuery = true)
	 Frete encontrarFretePorId(@Param("id") Integer id);
	 
	 @Query(value = "select * from endereco where id_endereco = id ",
				nativeQuery = true)
	 Endereco encontrarEnderecoPorId(@Param("id") Integer id);
	 
}
