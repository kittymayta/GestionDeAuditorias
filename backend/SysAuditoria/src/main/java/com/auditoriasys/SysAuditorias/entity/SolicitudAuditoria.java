package com.auditoriasys.SysAuditorias.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "solicitud_auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_solicitud_auditoria")
    private int codigoSolicitudAuditoria;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_solicitud_auditoria")
    private Date fechaSolicitudAuditoria;

    @Column(name = "estado_asignacion")
    private boolean estadoAsignacion;

    @JoinColumn(name = "codigo_usuario")
    private Integer usuario;
}
