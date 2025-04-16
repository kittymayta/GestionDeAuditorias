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
@Table(name = "documentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_documento")
	private int codigoDocumento;
	
	@Column(name = "nombre_documento")
	private String nombreDocumento;
	
	@Column(name = "codigo_sub_item")
	private int codigoSubItem;
	
}
