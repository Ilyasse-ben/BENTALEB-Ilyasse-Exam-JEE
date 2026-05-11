package net.ilyasse.bentaleb.backend.Controller;

import net.ilyasse.bentaleb.backend.DTOs.ClientDto;
import net.ilyasse.bentaleb.backend.service.AssurenceDervoiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private AssurenceDervoiceImp assurenceDervoiceImp;
    @GetMapping()
    public List<ClientDto> getAllclient(){
        return assurenceDervoiceImp.getAllClient();
    }
    @GetMapping("/{clientId}")
    public ClientDto getClient(@PathVariable Long clientId){
        return assurenceDervoiceImp.getClient(clientId);
    }
    @PostMapping()
    public ClientDto addClient(@RequestBody ClientDto dto){
        return assurenceDervoiceImp.ajouteClient(dto);
    }
    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId){
        assurenceDervoiceImp.deleteClient(clientId);
    }

}
