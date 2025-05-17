package com.auditoriasys.SysAuditorias.controller;
import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entity.TipoLink;
import com.auditoriasys.SysAuditorias.service.TipoLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tipoLink")
public class TipoLinkController {

    @Autowired
    TipoLinkService tipoLinkService;

    @GetMapping
    public List<TipoLink> listarLinks() {
        return tipoLinkService.getTipoLinks();
    }

    @GetMapping("/{id}")
    public Optional<TipoLink> buscarPorId(@PathVariable Integer id) {
        return tipoLinkService.findTipoLinkById(id);
    }

    @PostMapping("create")
    public TipoLink crear(@RequestBody TipoLink tipoLink) {
        return tipoLinkService.createTipoLink(tipoLink);
    }

    @PostMapping("update/{id}")
    public TipoLink actualizar(@RequestBody TipoLink tipoLink, @PathVariable Integer id) {
        tipoLink.setCodigoTipoLink(id);
        return tipoLinkService.updateTipoLink(tipoLink);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Integer id) {
        tipoLinkService.deleteTipoLink(id);
    }

    @GetMapping("/subItem/{codigo_subItem}")
    public List<TipoLink> obtenerLinksSubItem(@PathVariable Integer codigo_subItem){
        return tipoLinkService.findLinksBySubItem(codigo_subItem);
    }

    @GetMapping("/linkDocumentos")
    public List<TipoLink> obtenerLinksDocumentos(){
        return tipoLinkService.findLinksDocumentos();
    }

    @GetMapping("/linkEjemplos")
    public List<TipoLink> obtenerLinksEjemplos(){
        return tipoLinkService.findLinksEjemplos();
    }

    @GetMapping("/linkDocumentos/subItem/{codigo_subItem}")
    public List<TipoLink> obtenerLinksDocumentosBySubItem(@PathVariable Integer codigo_subItem){
        return tipoLinkService.findLinksDocumentosBySubItem(codigo_subItem);
    }

    @GetMapping("/linkEjemplos/subItem/{codigo_subItem}")
    public List<TipoLink> obtenerLinksEjemplosBySubItem(@PathVariable Integer codigo_subItem){
        return tipoLinkService.findLinksEjemploBySubItem(codigo_subItem);
    }
}