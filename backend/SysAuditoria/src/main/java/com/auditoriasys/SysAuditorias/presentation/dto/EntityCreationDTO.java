package com.auditoriasys.SysAuditorias.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record EntityCreationDTO(
        String codigo,
        String nombre
) {
}
