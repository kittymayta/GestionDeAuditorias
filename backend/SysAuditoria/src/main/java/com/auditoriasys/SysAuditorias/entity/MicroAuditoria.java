package com.auditoriasys.SysAuditorias.entity;
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

import java.util.Date;

@Entity
@Table(name = "micro_auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MicroAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_micro_auditoria")
    private int codigoMicroAuditoria;

    @JoinColumn(name = "codigo_auditoria")
    private int auditoria;

    @Column(name = "fecha_auditar")
    private Date fechaAuditar;

    @JoinColumn(name = "codigo_sub_item")
    private int subItem;

    @JoinColumn(name = "codigo_proceso")
    private int proceso;

    @JoinColumn(name = "codigo_usuario")
    private int usuario;
}
