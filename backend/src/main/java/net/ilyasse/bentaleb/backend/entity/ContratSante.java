package net.ilyasse.bentaleb.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ContratSante extends Contra{
    private Integer nbPersonnesCouvertes;
    private NiveauCouverture niveau;
}
