package com.auditoriasys.SysAuditorias.service;

import com.auditoriasys.SysAuditorias.entity.Entidad;
import com.auditoriasys.SysAuditorias.repository.EntidadRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EntidadService {
	
	@Autowired
	private EntidadRepository entidadRepository;
	
	public List<Entidad> getEntidades() {
		return entidadRepository.findAll();
	}
	
	public Entidad createEntidad(Entidad Entidad) {
		return entidadRepository.save(Entidad);
	}
	
	public Entidad updateEntidad(Entidad Entidad) {
		return entidadRepository.save(Entidad);
	}
	
	public void deleteEntidad(Integer id) {
		entidadRepository.deleteById(id);
	}
	
	public Optional<Entidad> findEntidadById(Integer id) {
		return entidadRepository.findById(id);
	}
}
