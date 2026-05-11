package net.ilyasse.bentaleb.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateSouscription;
    private StatutContra statut ;
    private Date dateValidation;
    private double cotisation;
    private int dure;
    private double tauxCouverture;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "contra")
    private List<Paiment> paiments;
}
