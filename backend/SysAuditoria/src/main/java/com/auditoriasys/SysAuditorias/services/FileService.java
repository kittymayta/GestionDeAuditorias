package com.auditoriasys.SysAuditorias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private ImagenService imagenService;
    @Autowired
    private EjemploService ejemploService;


    private final String directorio_files = "src/main/resources/files/";
    private final String directorio_imgs = "src/main/resources/img/";


}