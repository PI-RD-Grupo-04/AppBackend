package br.com.rd.ved.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.enums.StatusPedido;
import br.com.rd.ved.exception.PedidoNaoEncontradoException;
import br.com.rd.ved.exception.RegraNegocioException;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.ItemPedidoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository,
			ProdutoRepository produtoRepository, ItemPedidoRepository itemPedidoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
		this.produtoRepository = produtoRepository;
		this.itemPedidoRepository = itemPedidoRepository;
	}

	@Transactional
    public Pedido salvar( PedidoDTO dto ) {
        Integer idCliente = dto.getCliente().getId();
        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setData(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemsPedido);
        pedido.setItemPedidos(itemsPedido);
        return pedido;
    }

	@Transactional
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidoRepository.findByIdFetchItems(id);
    }

    
    @Transactional
    public void atualizaStatus( Integer id, StatusPedido statusPedido ) {
        pedidoRepository
                .findById(id)
                .map( pedido -> {
                    pedido.setStatus(statusPedido);
                    return pedidoRepository.save(pedido);
                }).orElseThrow(() -> new PedidoNaoEncontradoException() );
    }

    @Transactional
    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }

        return items
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtoRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de produto inválido: "+ idProduto
                                    ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());

    }

}
