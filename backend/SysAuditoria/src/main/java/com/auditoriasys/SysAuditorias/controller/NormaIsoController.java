package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.NormaIso;
import com.auditoriasys.SysAuditorias.service.NormaIsoService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/normasIso")
public class NormaIsoController {
	
	@Autowired
	NormaIsoService normaIsoService;
	
	@GetMapping
	public List<NormaIso> listarNormasIso() {
		return normaIsoService.getNormasIso();
	}
	
	@GetMapping("/{id}")
	public Optional<NormaIso> buscarPorId(@PathVariable Integer id) {
		return normaIsoService.findNormaIsoById(id);
	}
	
	@PostMapping("create")
	public NormaIso crear(@RequestBody NormaIso normaIso) {
		return normaIsoService.createNormaIso(normaIso);
	}
	
	@PostMapping("update/{id}")
	public NormaIso actualizar(@RequestBody NormaIso normaIso, @PathVariable Integer id) {
		normaIso.setCodigoNormaIso(id);
		return normaIsoService.updateNormaIso(normaIso);
	}
	
	@DeleteMapping("delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		normaIsoService.deleteNormaIso(id);
	}
}
