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
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_item")
	private int codigoItem;
	
	@Column(name = "nombre_item")
	private String nombreItem;
	
	@Column(name = "codigo_norma_iso")
	private int codigoNormaIso;
	
	@Column(name = "estado_uso")
	private boolean estadoUso;
}
