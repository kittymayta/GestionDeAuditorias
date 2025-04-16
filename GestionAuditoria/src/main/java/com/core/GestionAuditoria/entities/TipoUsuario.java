package com.utp.proyectoAcreditacion.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_tipo_usuario")
	private Integer codigoTipoUsuario;
	
	@Column(name = "nombre_tipo_usuario")
	private String nombreTipoUsuario;
	
}
