package net.ilyasse.bentaleb.backend.mapper;

import net.ilyasse.bentaleb.backend.DTOs.*;
import net.ilyasse.bentaleb.backend.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AssurenceMapper {
    // --- Mappage CLIENT ---
    public ClientDto fromClient(Client client) {
        ClientDto dto = new ClientDto();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }

    public Client fromClientDto(ClientDto dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    // --- Mappage CONTRAT AUTO ---
    public ContratAutoDto fromContratAuto(ContratAuto contrat) {
        ContratAutoDto dto = new ContratAutoDto();
        BeanUtils.copyProperties(contrat, dto);
        return dto;
    }

    public ContratAuto fromContratAutoDto(ContratAutoDto dto) {
        ContratAuto contrat = new ContratAuto();
        BeanUtils.copyProperties(dto, contrat);
        return contrat;
    }

    // --- Mappage CONTRAT HABITATION ---
    public ContratHabitationDto fromContratHabitation(ContratHabitation contrat) {
        ContratHabitationDto dto = new ContratHabitationDto();
        BeanUtils.copyProperties(contrat, dto);
        return dto;
    }

    public ContratHabitation fromContratHabitationDto(ContratHabitationDto dto) {
        ContratHabitation contrat = new ContratHabitation();
        BeanUtils.copyProperties(dto, contrat);
        return contrat;
    }

    // --- Mappage CONTRAT SANTE ---
    public ContratSanteDto fromContratSante(ContratSante contrat) {
        ContratSanteDto dto = new ContratSanteDto();
        BeanUtils.copyProperties(contrat, dto);
        return dto;
    }

    public ContratSante fromContratSanteDto(ContratSanteDto dto) {
        ContratSante contrat = new ContratSante();
        BeanUtils.copyProperties(dto, contrat);
        return contrat;
    }

    // --- Mappage PAIEMENT ---
    public PaimentDto fromPaiement(Paiment paiement) {
        PaimentDto dto = new PaimentDto();
        BeanUtils.copyProperties(paiement, dto);
        // On évite la récursion infinie en ne mappant que l'ID du contrat si nécessaire
        return dto;
    }

    public Paiment fromPaimentDto(PaimentDto dto) {
        Paiment paiement = new Paiment();
        BeanUtils.copyProperties(dto, paiement);
        return paiement;
    }
}
