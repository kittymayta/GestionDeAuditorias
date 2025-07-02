package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.SolicitudAuditoria;
import com.auditoriasys.SysAuditorias.repositories.SolicitudAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudAuditoriaService {

    @Autowired
    private SolicitudAuditoriaRepository solicitudAuditoriaRepository;

    public List<SolicitudAuditoria> getSolicitudAuditorias() {
        return solicitudAuditoriaRepository.findAll();
    }

    public SolicitudAuditoria createSolicitudAuditoria(SolicitudAuditoria solicitudAuditoria) {
        return solicitudAuditoriaRepository.save(solicitudAuditoria);
    }

    public SolicitudAuditoria updateSolicitudAuditoria(SolicitudAuditoria solicitudAuditoria) {
        return solicitudAuditoriaRepository.save(solicitudAuditoria);
    }

    public void deleteSolicitudAuditoria(Integer id) {
        solicitudAuditoriaRepository.deleteById(id);
    }

    public Optional<SolicitudAuditoria> findSolicitudAuditoriaById(Integer id) {
        return solicitudAuditoriaRepository.findById(id);
    }

    public List<SolicitudAuditoria> findByCodigoUsuario(Integer id) {
        return getSolicitudAuditorias().stream().filter(s -> s.getUsuario().getCodigoUsuario()==id).toList();
    }
}
