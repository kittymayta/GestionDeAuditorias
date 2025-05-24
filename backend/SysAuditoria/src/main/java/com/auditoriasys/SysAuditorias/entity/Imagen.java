package com.auditoriasys.SysAuditorias.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "imagenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_imagen")
    private int codigoImagen;

    @Column(name = "nombre_imagen")
    private String nombreImagen;

    @Column(name = "descripcion_imagen")
    private String descripcionImagen;

    @Column(name = "codigo_norma_iso")
    private int codigoNormaIso;
}
