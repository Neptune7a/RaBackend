package com.example.demo.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Data;

 @Entity
 @Data
 @Table(name="usuario")
public class Usuario {
	 	@Id
	 	@Column(name="codigo")
	    private Long codigo;
	 	@Column(name="nombre")
	    private String nombre;
	 	@Column(name="correo")
	    private String correo;
	 	@Column(name="contraseña")
	    private String contraseña;
	 	@Column(name="rol")
	    private String rol;
	 	
	 	 @OneToMany(mappedBy = "director")
	     private Set<Prueba> pruebasCreadas;

	     @ManyToMany
	     @JoinTable(
	         name = "usuario_prueba",
	         joinColumns = @JoinColumn(name = "usuario_id"),
	         inverseJoinColumns = @JoinColumn(name = "prueba_id")
	     )
	     private Set<Prueba> pruebasInscritas;

	     @ManyToMany
	     @JoinTable(
	         name = "jurado_prueba",
	         joinColumns = @JoinColumn(name = "jurado_id"),
	         inverseJoinColumns = @JoinColumn(name = "prueba_id")
	     )
	     private Set<Prueba> pruebasACalificar;
	 	
		public Usuario() {
			super();
		}
		
		
		public Usuario(Long codigo, String nombre, String correo, String contraseña, String rol) {
			super();
			this.codigo = codigo;
			this.nombre = nombre;
			this.correo = correo;
			this.contraseña = contraseña;
			this.rol = rol;
		}


		public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
		public String getRol() {
			return rol;
		}
		public void setRol(String rol) {
			this.rol = rol;
		}
	 	
	 	
}
