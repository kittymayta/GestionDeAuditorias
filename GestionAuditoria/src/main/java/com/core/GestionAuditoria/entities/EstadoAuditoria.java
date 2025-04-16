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
@Table(name = "estado_auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoAuditoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_estado_auditoria")
	private int codigoEstadoAuditoria;
	
	@Column(name = "nombre_estado_auditoria")
	private String nombreEstadoAuditoria;
	
}
