package com.utp.proyectoAcreditacion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entidad {
	
	@Id
	@Column(name = "codigo_entidad")
	private Integer codigoEntidad;
	
	@Column(name = "nombre_entidad")
	private String nombreEntidad;
	
	@Column(name = "codigo_tipo_entidad")
	private Integer codigoTipoEntidad;
	
}
