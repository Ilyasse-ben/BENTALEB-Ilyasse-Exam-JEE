package net.ilyasse.bentaleb.backend.DTOs;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.ilyasse.bentaleb.backend.entity.TypePaiment;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
public class PaimentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double montant;
    private TypePaiment typePaiment;
    @ManyToOne
    private ContraDto contra;
}
