package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Auditoria;
import com.auditoriasys.SysAuditorias.repositories.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {

    @Autowired
    AuditoriaRepository auditoriaRepository;

    public List<Auditoria> getAuditorias() {
        return auditoriaRepository.findAll();
    }

    public Auditoria createAuditoria(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    public Auditoria updateAuditoria(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    public void deleteAuditoria(Integer id) {
        auditoriaRepository.deleteById(id);
    }

    public Optional<Auditoria> findAuditoriaById(Integer id) {
        return auditoriaRepository.findById(id);
    }

    public List<Auditoria> findAuditoriasConAuditorLider() {
        return getAuditorias()
                .stream()
                .filter(a -> a.getUsuario()
                        .getTipoUsuario()
                        .getCodigoTipoUsuario()==4)
                .toList();
    }

    public List<Auditoria> findAuditoriasByCodigoAuditorLider(Integer id) {
        return findAuditoriasConAuditorLider().stream().filter(a -> a.getUsuario().getCodigoUsuario() == id).toList();
    }
}