package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.NormaIso;
import com.auditoriasys.SysAuditorias.repositories.NormaIsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NormaIsoService {

    @Autowired
    private NormaIsoRepository normaIsoRepository;

    public List<NormaIso> getNormasIso() {
        return normaIsoRepository.findAll();
    }

    public NormaIso createNormaIso(NormaIso normaIso) {
        return normaIsoRepository.save(normaIso);
    }

    public NormaIso updateNormaIso(NormaIso normaIso) {
        return normaIsoRepository.save(normaIso);
    }

    public void deleteNormaIso(Integer id) {
        normaIsoRepository.deleteById(id);
    }

    public Optional<NormaIso> findNormaIsoById(Integer id) {
        return normaIsoRepository.findById(id);
    }
}