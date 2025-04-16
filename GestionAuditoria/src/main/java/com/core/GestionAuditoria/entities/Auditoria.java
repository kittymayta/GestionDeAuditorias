package com.utp.proyectoAcreditacion.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auditoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_auditoria")
	private int codigoAuditoria;
	
	@Column(name = "nombre_auditoria")
	private String nombreAuditoria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_norma_iso")
	private NormaIso normaIso;
	
	@Column(name = "codigo_estado_auditoria")
	private int codigoEstadoAuditoria;
	
	@Column(name = "fechaInicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_final")
	private Date fechaFinal;
	
	@Column(name = "codigo_entidad")
	private int codigoEntidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;
}
