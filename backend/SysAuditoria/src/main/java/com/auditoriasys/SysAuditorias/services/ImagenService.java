package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Imagen;
import com.auditoriasys.SysAuditorias.repositories.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> getImagen() {
        return imagenRepository.findAll();
    }

    public Imagen createImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public Imagen updateImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public void deleteImagen(Integer id) {
        imagenRepository.deleteById(id);
    }

    public Optional<Imagen> findImagenById(Integer id) {
        return imagenRepository.findById(id);
    }

    public List<Imagen> findByCodigoNormaIso(Integer id) {
        return imagenRepository.findByCodigoNormaIso(id);
    }
}
