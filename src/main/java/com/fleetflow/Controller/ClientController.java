package com.fleetflow.Controller;

import com.fleetflow.Dto.ClientDto;
import com.fleetflow.Service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDto>> afficherTousClients(Pageable pageable){
        Page<ClientDto>clients=clientService.getAllClient(pageable);
        return ResponseEntity.ok(clients) ;
    }

    @PostMapping
    public ResponseEntity<ClientDto> ajouterClient(@Valid @RequestBody ClientDto dto){
        return new ResponseEntity<>(clientService.addClient(dto), HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> modifierClient(@PathVariable Long id,@RequestBody ClientDto dto){
        return new ResponseEntity<>( clientService.updateClient(id,dto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  supprimerClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
