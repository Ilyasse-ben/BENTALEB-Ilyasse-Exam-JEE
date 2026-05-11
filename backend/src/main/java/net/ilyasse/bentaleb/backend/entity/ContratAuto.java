package net.ilyasse.bentaleb.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ContratAuto extends Contra{
    private String immatriculation;
    private String marque;
    private String modele;
}
