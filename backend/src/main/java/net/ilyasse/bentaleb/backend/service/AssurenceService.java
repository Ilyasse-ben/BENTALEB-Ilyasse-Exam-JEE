package net.ilyasse.bentaleb.backend.service;

import net.ilyasse.bentaleb.backend.DTOs.ClientDto;
import net.ilyasse.bentaleb.backend.DTOs.ContraDto;

import java.util.List;

public interface AssurenceService {
    ClientDto ajouteClient(ClientDto clientDto);
    ClientDto getClient(Long clientId);
    void deleteClient(Long clientId);
    List<ClientDto> getAllClient();
    ContraDto ajouteContra(ContraDto contraDto);
    List<ContraDto> getCOntraUser(Long clientId);

}
