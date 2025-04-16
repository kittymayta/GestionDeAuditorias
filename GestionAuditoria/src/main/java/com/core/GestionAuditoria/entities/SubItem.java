package com.utp.proyectoAcreditacion.entities;

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
@Table(name = "sub_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_sub_item")
	private int codigoSubItem;
	
	@Column(name = "nombre_sub_item")
	private String nombreSubItem;
	
	@Column(name = "descripcion_sub_item")
	private String descripcionSubItem;
	
	@Column(name = "interpretacion_sub_item")
	private	String interpretacionSubItem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_item")
	private Item Item;
	
	@Column(name = "estado_uso")
	private boolean estadoUso;
}
