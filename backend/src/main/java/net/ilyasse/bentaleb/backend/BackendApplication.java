package net.ilyasse.bentaleb.backend;

import net.ilyasse.bentaleb.backend.entity.*;
import net.ilyasse.bentaleb.backend.repository.ClientRepository;
import net.ilyasse.bentaleb.backend.repository.ContraRepository;
import net.ilyasse.bentaleb.backend.repository.PaimentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepo, ContraRepository contratRepo, PaimentRepository paimentRepo) {
        return args -> {
            // 1. Création du client
            Client client = new Client();
            client.setName("Ilyasse");
            client.setEmail("ilyasse@example.com");

            // 2. Création d'un contrat spécifique (Auto)
            ContratAuto auto = new ContratAuto();
            auto.setImmatriculation("123-ABC-MA");
            auto.setMarque("Dacia");
            auto.setStatut(StatutContra.COURS);
            auto.setClient(client); // Liaison

            // 3. Sauvegarde en base
            clientRepo.save(client);
            contratRepo.save(auto);
            // 3. Création et sauvegarde d'un Paiement
            Paiment paiement = new Paiment();
            paiement.setDate(new Date());
            paiement.setMontant(1200.50);
            paiement.setTypePaiment(TypePaiment.Mensualité); // Test de l'énumération
            paiement.setContra(auto); // On lie le paiement au contrat
            paimentRepo.save(paiement);



            // 4. Vérification : On relit tout ce qui est en base
            System.out.println("--- Liste des Clients en base ---");
            clientRepo.findAll().forEach(c -> {
                System.out.println("Client : " + c.getName() + " | Email : " + c.getEmail());
            });

            System.out.println("--- Liste des Contrats en base ---");
            contratRepo.findAll().forEach(con -> {
                System.out.println("ID Contrat : " + con.getId() + " | Type : " + con.getClass().getSimpleName());
            });
            // 4. VERIFICATION DANS LA CONSOLE
            System.out.println("========== VERIFICATION DES DONNEES ==========");

            paimentRepo.findAll().forEach(p -> {
                System.out.println(">>> PAIEMENT RECU :");
                System.out.println("Montant : " + p.getMontant() + " DH");
                System.out.println("Type : " + p.getTypePaiment());
                System.out.println("Pour le client : " + p.getContra().getClient().getName());
                System.out.println("Véhicule concerné : " + ((ContratAuto) p.getContra()).getMarque());
            });

            System.out.println("==============================================");
        };
    }

}
