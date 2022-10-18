//Feito por @lidianeangelo

package com.generation.ods11.model;

public class UsuarioLogin {
	
	private Long id;
	private String userName;
	private String usuario;
	private String senha;
	private String fotoUser;
	private String tipoUser;
	private String token;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFotoUser() {
		return fotoUser;
	}
	public void setFotoUser(String fotoUser) {
		this.fotoUser = fotoUser;
	}
	public String getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
