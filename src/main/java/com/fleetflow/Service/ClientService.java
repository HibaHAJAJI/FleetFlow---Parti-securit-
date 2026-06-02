package com.fleetflow.Service;

import com.fleetflow.Dto.ClientDto;

import java.util.List;


public interface ClientService {

    ClientDto addClient(ClientDto dto);

    void deleteClient(Long id);

    ClientDto updateClient(Long id,ClientDto clientDto);

    List<ClientDto> getAllClient();
}
