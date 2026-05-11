package net.ilyasse.bentaleb.backend.DTOs;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.ilyasse.bentaleb.backend.entity.StatutContra;

import java.util.Date;
import java.util.List;

public abstract class ContraDto {
    private Long id;
    private Date dateSouscription;
    private StatutContra statut ;
    private Date dateValidation;
    private double cotisation;
    private int dure;
    private double tauxCouverture;
}
