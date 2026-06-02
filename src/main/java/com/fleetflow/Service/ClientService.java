package com.fleetflow.Service;

import com.fleetflow.Dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ClientService {

    ClientDto addClient(ClientDto dto);

    void deleteClient(Long id);

    ClientDto updateClient(Long id,ClientDto clientDto);

    Page<ClientDto> getAllClient(Pageable pageable);
}
