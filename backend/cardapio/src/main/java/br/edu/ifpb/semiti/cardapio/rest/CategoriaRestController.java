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

import br.edu.ifpb.semiti.cardapio.dao.impl.CategoriaDao;
import br.edu.ifpb.semiti.cardapio.domain.Categoria;

@RestController
@RequestMapping(value = "/categoria", produces = "application/json")
public class CategoriaRestController {

	@Autowired
	private CategoriaDao categoriaDao;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> buscarTodos() {
		List<Categoria> categorias = this.categoriaDao.findAll();

		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
		Categoria novaCategoria = categoriaDao.create(categoria);

		return new ResponseEntity<Categoria>(novaCategoria, HttpStatus.CREATED);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {

		Optional<Categoria> categoria = categoriaDao.findById(id);

		if (categoria.isPresent()) {
			return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		boolean wasDeleted = categoriaDao.delete(id);

		HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;

		return new ResponseEntity<>(responseStatus);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Categoria> updateOrder(@PathVariable Long id,
			@RequestBody Categoria categoriaAtualizada) {

		boolean wasUpdated = categoriaDao.update(id, categoriaAtualizada);

		if (wasUpdated) {
			return buscarPorId(id);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
}
