package com.fleetflow.Controller;

import com.fleetflow.Dto.ClientDto;
import com.fleetflow.Service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/afficher")
    public List<ClientDto> afficherTousClients(){
        return clientService.getAllClient();
    }
    @PostMapping("/ajouter")
    public ResponseEntity<ClientDto> ajouterClient(@Valid @RequestBody ClientDto dto){
        return new ResponseEntity<>(clientService.addClient(dto), HttpStatus.CREATED) ;
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<ClientDto> modifierClient(@PathVariable Long id,@RequestBody ClientDto dto){
        return new ResponseEntity<>( clientService.updateClient(id,dto),HttpStatus.CREATED);
    }
    @DeleteMapping("/supprimer/{id}")
    public void supprimerClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
