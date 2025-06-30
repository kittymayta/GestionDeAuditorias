package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.MicroAuditoria;
import com.auditoriasys.SysAuditorias.repositories.MicroAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroAuditoriaService {

    @Autowired
    private MicroAuditoriaRepository microAuditoriaRepository;

    public List<MicroAuditoria> getMicroAuditorias() {
        return microAuditoriaRepository.findAll();
    }

    public MicroAuditoria createMicroAuditoria(MicroAuditoria microAuditoria) {
        return microAuditoriaRepository.save(microAuditoria);
    }

    public MicroAuditoria updateMicroAuditoria(MicroAuditoria microAuditoria) {
        return microAuditoriaRepository.save(microAuditoria);
    }

    public void deleteMicroAuditoria(Integer id) {
        microAuditoriaRepository.deleteById(id);
    }

    public Optional<MicroAuditoria> findMicroAuditoriaById(Integer id) {
        return microAuditoriaRepository.findById(id);
    }

    public List<MicroAuditoria> findMicroAuditoriaByCodigoAuditoria(Integer id) {
        return getMicroAuditorias().stream().filter(m -> m.getAuditoria().getCodigoAuditoria()==id).toList();
    }

    public List<MicroAuditoria> findMicroAuditoriaByCodigoAuditor(Integer id) {
        return getMicroAuditorias().stream().filter( m -> m.getUsuario().getCodigoUsuario()== id).toList();
    }

    public List<MicroAuditoria> findMicroAuditoriaEnProcesoByCodigoAuditor(Integer id) {
        return findMicroAuditoriaByCodigoAuditor(id)
                .stream()
                .filter(p -> p.getAuditoria().getCodigoEstadoAuditoria()==2)
                .toList();
    }

}