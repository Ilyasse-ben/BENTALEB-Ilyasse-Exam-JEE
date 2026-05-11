package net.ilyasse.bentaleb.backend.DTOs;

import lombok.Data;

@Data
public class ContratAutoDto extends ContraDto {
    private String immatriculation;
    private String marque;
    private String modele;
}
