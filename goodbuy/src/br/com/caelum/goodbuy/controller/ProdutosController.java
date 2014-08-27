package br.com.caelum.goodbuy.controller;

import java.util.List;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class ProdutosController {
	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Restrito
	@Get("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}
	
	@Restrito
	@Post("/produtos")
	public void adiciona(final Produto produto) {
		validator.validate(produto);
		
		validator.onErrorUsePageOf(this).formulario();
		
		dao.salva(produto);
		result.redirectTo(this).lista();
	}
	
	@Restrito
	@Get("/produtos/novo")
	public void formulario() {
	}
	
	@Restrito
	@Get("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}
	
	@Restrito
	@Put("/produtos/{produtos.id}")
	public void altera(Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(this).edita(produto.getId());
		
		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}
	
	@Restrito
	@Delete("/produtos/{id}")
	public void remove(Long id) {
		Produto produto = dao.carrega(id);
		dao.remove(produto);

		result.redirectTo(this).lista();
	}
	
	@Restrito
	@Get("/produtos/busca")
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

}
