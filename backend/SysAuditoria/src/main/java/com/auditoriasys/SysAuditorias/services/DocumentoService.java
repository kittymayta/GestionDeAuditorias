package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Documento;
import com.auditoriasys.SysAuditorias.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> getDocumentos() {
        return documentoRepository.findAll();
    }

    public Documento createDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    public Documento updateDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    public void deleteDocumento(Integer id) {
        documentoRepository.deleteById(id);
    }

    public Optional<Documento> findDocumentoById(Integer id) {
        return documentoRepository.findById(id);
    }

    public List<Documento> findByCodigoSubItem(Integer id) {
        return documentoRepository.findByCodigoSubItem(id);
    }
}
