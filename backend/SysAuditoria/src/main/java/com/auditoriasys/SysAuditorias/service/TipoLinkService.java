package com.auditoriasys.SysAuditorias.service;
import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entity.TipoLink;
import com.auditoriasys.SysAuditorias.repository.TipoLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoLinkService {

    @Autowired
    private TipoLinkRepository tipoLinkRepository;

    public List<TipoLink> getTipoLinks() {
        return tipoLinkRepository.findAll();
    }

    public TipoLink createTipoLink(TipoLink tipoLink) {
        return tipoLinkRepository.save(tipoLink);
    }

    public TipoLink updateTipoLink(TipoLink tipoLink) {
        return tipoLinkRepository.save(tipoLink);
    }

    public void deleteTipoLink(Integer id) {
        tipoLinkRepository.deleteById(id);
    }

    public Optional<TipoLink> findTipoLinkById(Integer id) {
        return tipoLinkRepository.findById(id);
    }

    public List<TipoLink> findLinksBySubItem(Integer id) {
        return getTipoLinks().stream().filter(t -> t.getCodigoSubItem() == id).toList();
    }

    public List<TipoLink> findLinksDocumentos() {
        return getTipoLinks().stream().filter(d -> d.getTipoLink().equalsIgnoreCase("documento")).toList();
    }

    public List<TipoLink> findLinksEjemplos() {
        return getTipoLinks().stream().filter(d -> d.getTipoLink().equalsIgnoreCase("ejemplo")).toList();
    }

    public List<TipoLink> findLinksDocumentosBySubItem(Integer id) {
        return findLinksBySubItem(id).stream().filter(d -> d.getTipoLink().equalsIgnoreCase("documento")).toList();
    }

    public List<TipoLink> findLinksEjemploBySubItem(Integer id) {
        return findLinksBySubItem(id).stream().filter(d -> d.getTipoLink().equalsIgnoreCase("ejemplo")).toList();
    }
}