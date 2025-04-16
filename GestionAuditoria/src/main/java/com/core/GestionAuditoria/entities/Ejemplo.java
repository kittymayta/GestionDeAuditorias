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
@Table(name = "ejemplos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ejemplo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_ejemplo")
	private int codigoEjemplo;

	@Column(name = "nombre_ejemplo")
	private String nombreEjemplo;
	
	@Column(name = "codigo_sub_item")
	private int codigoSubItem;
	
}
