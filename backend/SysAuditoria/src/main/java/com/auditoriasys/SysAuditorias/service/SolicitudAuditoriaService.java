package com.auditoriasys.SysAuditorias.service;

import com.auditoriasys.SysAuditorias.entity.SolicitudAuditoria;
import com.auditoriasys.SysAuditorias.repository.SolicitudAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return getSolicitudAuditorias().stream().filter(s -> s.getUsuario()==id).toList();
    }
}
