package com.generation.ods11.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "Não pode deixar a postagem sem Titulo!!!")
	@Size (min = 15, max = 200, message = "Deve conter no minimo 15 e no máximo 200 caracteres")
	private String titulo;
	
	@NotBlank (message = "Não pode deixar a postagem sem o Subtitulo!!!")
	@Size (min = 15, max = 1200, message = "Deve conter no minimo 15 e no máximo 1200 caracteres")
	private String subtitulo;

	@NotNull (message = "Imagem é ideal para que sua mensagem seja transmitida com mais clareza.")
	private String imagem;
	
	@NotBlank (message = "O preenchimento do nome do/da Autore é obrigatório!")
	private String autor;
		
	@NotNull (message = "A data e o horário da onde você se encontra é essencial para evitar confusão entre as notícias.")
	private LocalDateTime data;
	
	@NotNull (message = "Se possivel, coloque audio de leitura da postagem, assim ajudará quem precisa, vamos fazer o mundo mais acessivel!")
	private String audio;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}
}
