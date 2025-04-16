package com.utp.proyectoAcreditacion.entities;

import java.util.Date;

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
@Table(name = "solicitud_auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudAuditoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_solicitud_auditoria")
	private int codigoSolicitudAuditoria;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_solicitud_auditoria")
	private Date fechaSolicitudAuditoria;
	
	@Column(name = "estado_asignacion")
	private boolean estadoAsignacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;
}
