package com.ifms.br.projeto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="balconista")
public class Balconista implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false, length=80)
	private String nomeusuario;
	@Column(nullable = false, length = 15) 
	private String senha;
	@Column(nullable = false, length = 50) 
	private  String nivelacesso;
	

	public Balconista() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelacesso() {
		return nivelacesso;
	}

	public void setNivelacesso(String nivelacesso) {
		this.nivelacesso = nivelacesso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nivelacesso, nomeusuario, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balconista other = (Balconista) obj;
		return Objects.equals(id, other.id) && Objects.equals(nivelacesso, other.nivelacesso)
				&& Objects.equals(nomeusuario, other.nomeusuario) && Objects.equals(senha, other.senha);
	}
	
}
