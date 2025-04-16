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
@Table(name = "tipo_link")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoLink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_tipo_link")
	private int codigoTipoLink;
	
	@Column(name = "tipo_link")
	private String tipoLink;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "codigo_sub_item")
	private int codigoSubItem;
}
