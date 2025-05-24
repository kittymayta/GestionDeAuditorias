package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.SolicitudAuditoria;
import com.auditoriasys.SysAuditorias.service.SolicitudAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/solicitudAuditorias")
public class SolicitudAuditoriaController {
    @Autowired
    private SolicitudAuditoriaService solicitudAuditoriaService;

    @GetMapping
    public List<SolicitudAuditoria> listarSolicitudAuditorias() {
        return solicitudAuditoriaService.getSolicitudAuditorias();
    }

    @GetMapping("/{id}")
    public Optional<SolicitudAuditoria> buscarPorId(@PathVariable Integer id) {
        return solicitudAuditoriaService.findSolicitudAuditoriaById(id);
    }

    @PostMapping("create")
    public SolicitudAuditoria crear(@RequestBody SolicitudAuditoria solicitudAuditoria) {
        return solicitudAuditoriaService.createSolicitudAuditoria(solicitudAuditoria);
    }

    @PostMapping("update/{id}")
    public SolicitudAuditoria actualizar(@RequestBody SolicitudAuditoria solicitudAuditoria, @PathVariable Integer id) {
        solicitudAuditoria.setCodigoSolicitudAuditoria(id);
        return solicitudAuditoriaService.updateSolicitudAuditoria(solicitudAuditoria);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Integer id) {
        solicitudAuditoriaService.deleteSolicitudAuditoria(id);
    }

    @GetMapping("/usuario/{codigoUsuario}")
    public List<SolicitudAuditoria> findByCodigoUsuario(@PathVariable Integer codigoUsuario) {
        return solicitudAuditoriaService.findByCodigoUsuario(codigoUsuario);
    }
}
