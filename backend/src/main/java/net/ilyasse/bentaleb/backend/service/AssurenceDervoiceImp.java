package net.ilyasse.bentaleb.backend.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.ilyasse.bentaleb.backend.DTOs.*;
import net.ilyasse.bentaleb.backend.entity.*;
import net.ilyasse.bentaleb.backend.mapper.AssurenceMapper;
import net.ilyasse.bentaleb.backend.repository.ClientRepository;
import net.ilyasse.bentaleb.backend.repository.ContraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AssurenceDervoiceImp implements AssurenceService{

    private ClientRepository clientRepository;
    private ContraRepository contraRepository;
    private AssurenceMapper mapper;
    @Override
    public ClientDto ajouteClient(ClientDto clientDto) {
        Client client = mapper.fromClientDto(clientDto);
        Client savedClient = clientRepository.save(client);
        return mapper.fromClient(savedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        if(!clientRepository.existsById(clientId)) throw new RuntimeException("client not find");
        clientRepository.deleteById(clientId);

    }

    @Override
    public List<ClientDto> getAllClient(ClientDto clientDto) {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ContraDto ajouteContra(ContraDto contraDto) {
        // Logique pour gérer les différents types de contrats (Héritage)
        if (contraDto instanceof ContratAutoDto) {
            ContratAuto c = mapper.fromContratAutoDto((ContratAutoDto) contraDto);
            return mapper.fromContratAuto(contraRepository.save(c));
        } else if (contraDto instanceof ContratHabitationDto) {
            ContratHabitation c = mapper.fromContratHabitationDto((ContratHabitationDto) contraDto);
            return mapper.fromContratHabitation(contraRepository.save(c));
        } else if (contraDto instanceof ContratSanteDto) {
            ContratSante c = mapper.fromContratSanteDto((ContratSanteDto) contraDto);
            return mapper.fromContratSante(contraRepository.save(c));
        }
        throw new RuntimeException("Type de contrat inconnu");
    }

    @Override
    public List<ContraDto> getCOntraUser(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        List<Contra> contrats=client.getContras();
        return contrats.stream().map(c -> {
            if (c instanceof ContratAuto) return mapper.fromContratAuto((ContratAuto) c);
            if (c instanceof ContratHabitation) return mapper.fromContratHabitation((ContratHabitation) c);
            if (c instanceof ContratSante) return mapper.fromContratSante((ContratSante) c);
            return null;
        }).collect(Collectors.toList());
    }
}
