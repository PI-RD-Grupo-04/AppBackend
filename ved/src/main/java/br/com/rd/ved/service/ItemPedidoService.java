package br.com.rd.ved.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.formdto.ItemPedidoForm;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ItemPedidoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.ProdutoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(readOnly = true)
	public List<ItemPedidoDTO> findAll() {
		List<ItemPedido> list = itemPedidoRepository.findAll();
		return list.stream().map(x -> new ItemPedidoDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public ItemPedidoDTO insert(ItemPedidoForm form) {
		ItemPedido entity = new ItemPedido();
		Optional<Pedido> pedido = pedidoRepository.findById(Integer.parseInt(form.getPedido()));
		Optional<Produto> produto = produtoRepository.findById(Integer.parseInt(form.getProduto()));		
		entity.setPedido(pedido.get());
		entity.setProduto(produto.get());
		entity.setQuantidade(Integer.parseInt(form.getQuantidade()));
		entity.setPorcentagemIcms(Double.parseDouble(form.getPorcentagemIcms()));
		entity.setValorIcms(Double.parseDouble(form.getValorIcms()));
		System.out.println(entity);
		entity = itemPedidoRepository.save(entity);
		
		return new ItemPedidoDTO(entity);
	}
	
}
