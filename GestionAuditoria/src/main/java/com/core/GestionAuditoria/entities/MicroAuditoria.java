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
@Table(name = "micro_auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MicroAuditoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_micro_auditoria")
	private int codigoMicroAuditoria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_auditoria")
	private Auditoria auditoria;
	
	@Column(name = "fecha_auditar")
	private Date fechaAuditar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_sub_item")
	private SubItem subItem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_proceso")
	private Procesos proceso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;
}
