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
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_usuario")
	private Integer codigoUsuario;
	
	@Column(name = "nombre")
	private String nombreUsuario;
	
	@Column(name = "apellido_pat")
	private String apellidoPat;
	
	@Column(name = "apellido_mat")
	private String apellidoMat;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "correo_electronico")
	private String correoElectronico;
	
	@Column(name = "telefono")
	private String telefono;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_entidad")
	private Entidad entidad;
	
	@Column(name = "estado_uso")
	private boolean estadoUso;
}
