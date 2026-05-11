package net.ilyasse.bentaleb.backend.DTOs;

import jakarta.persistence.Entity;
import lombok.Data;
import net.ilyasse.bentaleb.backend.entity.NiveauCouverture;

@Data
public class ContratSanteDto extends ContraDto {
    private Integer nbPersonnesCouvertes;
    private NiveauCouverture niveau;
}
