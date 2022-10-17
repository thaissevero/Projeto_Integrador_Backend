//Feito por @lidianeangelo

package com.generation.ods11.model;

public class UsuarioLogin {
private Long id;
private String username;
private String email;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
