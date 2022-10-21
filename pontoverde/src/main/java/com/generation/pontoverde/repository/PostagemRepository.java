package com.generation.pontoverde.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.pontoverde.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	public List<Postagem> findAllByAutorContainingIgnoreCase(@Param("autor") String autor);

}
