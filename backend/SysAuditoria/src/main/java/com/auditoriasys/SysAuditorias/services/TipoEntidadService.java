package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.TipoEntidad;
import com.auditoriasys.SysAuditorias.repositories.TipoEntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEntidadService {

    @Autowired
    private TipoEntidadRepository tipoEntidadRepository;

    public List<TipoEntidad> getTipoEntidades() {
        return tipoEntidadRepository.findAll();
    }

    public TipoEntidad createTipoEntidad(TipoEntidad TipoEntidad) {
        return tipoEntidadRepository.save(TipoEntidad);
    }

    public TipoEntidad updateTipoEntidad(TipoEntidad TipoEntidad) {
        return tipoEntidadRepository.save(TipoEntidad);
    }

    public void deleteTipoEntidad(Integer id) {
        tipoEntidadRepository.deleteById(id);
    }

    public Optional<TipoEntidad> findTipoEntidadById(Integer id) {
        return tipoEntidadRepository.findById(id);
    }

}