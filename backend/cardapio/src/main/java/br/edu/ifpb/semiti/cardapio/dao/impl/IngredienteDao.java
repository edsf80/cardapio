/**
 * 
 */
package br.edu.ifpb.semiti.cardapio.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.semiti.cardapio.dao.InMemoryRepository;
import br.edu.ifpb.semiti.cardapio.domain.Ingrediente;

/**
 * @author edsf
 *
 */
@Repository
public class IngredienteDao extends InMemoryRepository<Ingrediente>  {

	@Override
	protected void updateIfExists(Ingrediente original, Ingrediente desired) {
				
	}

}
