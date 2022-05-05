package br.com.rd.ved.exception;

public class PedidoNaoEncontradoException extends RuntimeException{

	 private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException() {
	        super("Pedido não Encontrado");
	    }
}
