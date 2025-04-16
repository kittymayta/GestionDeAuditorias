package com.utp.proyectoAcreditacion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "normas_iso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormaIso {
	
	@Id
	@Column(name = "codigo_norma_iso")
	private int codigoNormaIso;
	
	@Column(name = "nombre_norma_iso")
	private String nombreNormaIso;
	
	@Column(name = "descripcion_norma_iso")
	private String descripcionNormaIso;
	
	@Column(name = "link_video")
	private String linkVideo;
	
	@Column(name = "nombre_video")
	private String nombreVideo;
	
}
