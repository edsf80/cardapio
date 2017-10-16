/**
 * 
 */
package br.edu.ifpb.semiti.cardapio.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author edsf
 *
 */
public class Prato implements Identifiable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6786166993700916301L;

	private Long id;

	private String descricao;
	
	private Set<Ingrediente> ingredientes = new HashSet<>();	

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.ifpb.semiti.cardapio.domain.Identifiable#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.ifpb.semiti.cardapio.domain.Identifiable#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void addIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}
}
