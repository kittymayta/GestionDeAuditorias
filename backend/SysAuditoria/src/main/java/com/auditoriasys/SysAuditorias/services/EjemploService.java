package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Ejemplo;
import com.auditoriasys.SysAuditorias.repositories.EjemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjemploService {

    @Autowired
    private EjemploRepository ejemploLinkRepository;

    public List<Ejemplo> getEjemplos() {
        return ejemploLinkRepository.findAll();
    }

    public Ejemplo createEjemplo(Ejemplo ejemploLink) {
        return ejemploLinkRepository.save(ejemploLink);
    }

    public Ejemplo updateEjemplo(Ejemplo ejemploLink) {
        return ejemploLinkRepository.save(ejemploLink);
    }

    public void deleteEjemplo(Integer id) {
        ejemploLinkRepository.deleteById(id);
    }

    public Optional<Ejemplo> findEjemploById(Integer id) {
        return ejemploLinkRepository.findById(id);
    }

    public List<Ejemplo> findByCodigoSubItem(Integer id) {
        return ejemploLinkRepository.findByCodigoSubItem(id);
    }
}