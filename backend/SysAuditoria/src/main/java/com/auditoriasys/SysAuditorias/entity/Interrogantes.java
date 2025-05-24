package com.auditoriasys.SysAuditorias.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interrogantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interrogantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_interrogante")
    private int codigoInterrogante;

    @Column(name = "nombre_interrogante")
    private String nombreInterrogante;

    @Column(name = "observacion_interrogante")
    private String observacionInterrogante;

    @Column(name = "codigo_micro_auditoria")
    private int codigoMicroAuditoria;

    @Column(name = "estado")
    private String estado;
}
