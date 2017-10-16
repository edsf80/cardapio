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

import br.edu.ifpb.semiti.cardapio.dao.impl.PratoDao;
import br.edu.ifpb.semiti.cardapio.domain.Prato;

@RestController
@RequestMapping(value = "/prato", produces = "application/json")
public class PratoRestController {

	@Autowired
	private PratoDao pratoDao;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Prato>> buscarTodos() {
		List<Prato> pratos = this.pratoDao.findAll();

		return new ResponseEntity<List<Prato>>(pratos, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Prato> criar(@RequestBody Prato prato) {
		Prato novoPrato = pratoDao.create(prato);

		return new ResponseEntity<Prato>(novoPrato, HttpStatus.CREATED);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Prato> buscarPorId(@PathVariable Long id) {

		Optional<Prato> prato = pratoDao.findById(id);

		if (prato.isPresent()) {
			return new ResponseEntity<>(prato.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		boolean wasDeleted = pratoDao.delete(id);

		HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;

		return new ResponseEntity<>(responseStatus);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Prato> updateOrder(@PathVariable Long id,
			@RequestBody Prato pratoAtualizado) {

		boolean wasUpdated = pratoDao.update(id, pratoAtualizado);

		if (wasUpdated) {
			return buscarPorId(id);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
}
