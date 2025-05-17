package com.auditoriasys.SysAuditorias.service;

import com.auditoriasys.SysAuditorias.entity.MicroAuditoria;
import com.auditoriasys.SysAuditorias.repository.MicroAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return getMicroAuditorias().stream().filter(m -> m.getAuditoria()==id).toList();
    }

    public List<MicroAuditoria> findMicroAuditoriaByCodigoAuditor(Integer id) {
        return getMicroAuditorias().stream().filter( m -> m.getUsuario()== id).toList();
    }

    public List<MicroAuditoria> findMicroAuditoriaEnProcesoByCodigoAuditor(Integer id) {
        return findMicroAuditoriaByCodigoAuditor(id)
                .stream()
                .filter(p -> p.getAuditoria()==2)
                .toList();
    }

}
