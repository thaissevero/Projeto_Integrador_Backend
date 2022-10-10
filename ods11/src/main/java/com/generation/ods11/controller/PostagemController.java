/*
 Feito por @flrvia and @marirebecca.
 */

package com.generation.ods11.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ods11.model.Postagem;
import com.generation.ods11.repository.CategoriaRepository;
import com.generation.ods11.repository.PostagemRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	// Procurar por todas as postagens
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	// Procurar por id da postagem
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	// Procurar pelo titulo da postagem
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	// Procurar pelo autor da postagemm
	@GetMapping("/autor/{autor}")
	public ResponseEntity<List<Postagem>> getByAutor(@PathVariable String autor){
		return ResponseEntity.ok(postagemRepository.findAllByAutorContainingIgnoreCase(autor));
	}
	
	// Inserir uma postagem pelo id
	@PostMapping
	public ResponseEntity<Postagem> post (@Valid @RequestBody Postagem postagem){
		if (categoriaRepository.existsById(postagem.getCategoria().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(postagemRepository.save(postagem));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
	}
	
	//Alterar uma postagem pelo id
	@PutMapping
	public ResponseEntity<Postagem> put (@Valid @RequestBody Postagem postagem){
		if (postagemRepository.existsById(postagem.getId())) {
			if (categoriaRepository.existsById(postagem.getCategoria().getId())) {
				return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
				
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	//Deletar uma postagem pelo id
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id)")
	public void delete (@PathVariable Long id) {
		Optional<Postagem> postagem = postagemRepository.findById(id);
				
				if (postagem.isEmpty())
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				
			postagemRepository.deleteById(id);
	}

	
}
