package net.ilyasse.bentaleb.backend.Controller;

import net.ilyasse.bentaleb.backend.DTOs.ClientDto;
import net.ilyasse.bentaleb.backend.DTOs.ContraDto;
import net.ilyasse.bentaleb.backend.service.AssurenceDervoiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/contrats")
public class ContraController {
    @Autowired
    private AssurenceDervoiceImp assurenceDervoiceImp;
    @GetMapping("/{clientId}")
    public List<ContraDto> getAllclientContra(@PathVariable long clientId){
        return assurenceDervoiceImp.getCOntraUser(clientId);
    }
    @GetMapping("/{clientId}")
    public ClientDto getClient(@PathVariable Long clientId){
        return assurenceDervoiceImp.getClient(clientId);
    }
    @PostMapping()
    public ContraDto addConte(@RequestBody ContraDto dto){
        return assurenceDervoiceImp.ajouteContra(dto);
    }

}
