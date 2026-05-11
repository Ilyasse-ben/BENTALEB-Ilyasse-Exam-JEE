package net.ilyasse.bentaleb.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ContratHabitation extends Contra{
    private String adresse;
    private Double superficie;
    private TypeLogement typeLogement;
}
