/**
 * 
 */
package br.edu.ifpb.semiti.cardapio.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.semiti.cardapio.dao.InMemoryRepository;
import br.edu.ifpb.semiti.cardapio.domain.Categoria;

/**
 * @author edsf
 *
 */
@Repository
public class CategoriaDao extends InMemoryRepository<Categoria> {

	@Override
	protected void updateIfExists(Categoria original, Categoria desired) {
		// TODO Auto-generated method stub		
	}

}
