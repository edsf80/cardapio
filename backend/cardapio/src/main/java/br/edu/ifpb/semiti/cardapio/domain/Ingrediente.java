package br.edu.ifpb.semiti.cardapio.domain;

public class Ingrediente implements Identifiable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6495117094117185669L;

	private Long id;
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

	@Override
	public Long getId() {
		return this.id;
	}

}
