package com.auditoriasys.SysAuditorias.entity;

import jakarta.persistence.*;
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

    @JoinColumn(name = "codigo_tipo_usuario")
    private int tipoUsuario;

    @JoinColumn(name = "codigo_entidad")
    private int entidad;

    @Column(name = "estado_uso")
    private boolean estadoUso;
}
