/**
 * 
 */
package br.edu.ifpb.semiti.cardapio.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.semiti.cardapio.dao.InMemoryRepository;
import br.edu.ifpb.semiti.cardapio.domain.Prato;

/**
 * @author edsf
 *
 */
@Repository
public class PratoDao extends InMemoryRepository<Prato> {

	@Override
	protected void updateIfExists(Prato original, Prato desired) {
		// TODO Auto-generated method stub
		
	}

}
