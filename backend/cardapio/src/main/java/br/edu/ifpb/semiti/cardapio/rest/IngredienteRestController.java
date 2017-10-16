/**
 * 
 */
package br.edu.ifpb.semiti.cardapio.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.semiti.cardapio.dao.impl.IngredienteDao;
import br.edu.ifpb.semiti.cardapio.domain.Ingrediente;

/**
 * @author edsf
 *
 */
@RestController
@RequestMapping(value = "/ingrediente", produces = "application/json")
public class IngredienteRestController {

	@Autowired
	private IngredienteDao ingredienteDao;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Ingrediente>> buscarTodos() {
		List<Ingrediente> ingredientes = this.ingredienteDao.findAll();

		return new ResponseEntity<List<Ingrediente>>(ingredientes, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Ingrediente> criar(@RequestBody Ingrediente ingrediente) {
		Ingrediente novoIngrediente = ingredienteDao.create(ingrediente);

		return new ResponseEntity<Ingrediente>(novoIngrediente, HttpStatus.CREATED);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ingrediente> buscarPorId(@PathVariable Long id) {

		Optional<Ingrediente> ingrediente = ingredienteDao.findById(id);

		if (ingrediente.isPresent()) {
			return new ResponseEntity<>(ingrediente.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		boolean wasDeleted = ingredienteDao.delete(id);

		HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;

		return new ResponseEntity<>(responseStatus);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Ingrediente> updateOrder(@PathVariable Long id,
			@RequestBody Ingrediente ingredienteAtualizado) {

		boolean wasUpdated = ingredienteDao.update(id, ingredienteAtualizado);

		if (wasUpdated) {
			return buscarPorId(id);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
}
