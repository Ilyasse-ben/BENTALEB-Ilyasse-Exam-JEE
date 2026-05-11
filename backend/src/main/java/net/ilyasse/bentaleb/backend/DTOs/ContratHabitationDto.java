package net.ilyasse.bentaleb.backend.DTOs;

import jakarta.persistence.Entity;
import lombok.Data;
import net.ilyasse.bentaleb.backend.entity.TypeLogement;

@Entity
@Data
public class ContratHabitationDto extends ContraDto {
    private String adresse;
    private Double superficie;
    private TypeLogement typeLogement;
}
