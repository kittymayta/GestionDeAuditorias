package com.auditoriasys.SysAuditorias.entity;

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
@Table(name = "tipo_entidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoEntidad {
	
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_tipo_entidad")
	private Integer codigoTipoEntidad;
	
	@Column(name = "nombre_tipo_entidad")
	private String nombreTipoEntidad;
}
