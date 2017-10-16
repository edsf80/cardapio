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
public class Categoria implements Identifiable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String descricao;
	
	private Set<Prato> pratos = new HashSet<>();

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

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the pratos
	 */
	public Set<Prato> getPratos() {
		return pratos;
	}

	/**
	 * @param pratos the pratos to set
	 */
	public void setPratos(Set<Prato> pratos) {
		this.pratos = pratos;
	}
	
	/**
	 * @param prato
	 */
	public void addPrato(Prato prato) {
		this.pratos.add(prato);
	}

}
