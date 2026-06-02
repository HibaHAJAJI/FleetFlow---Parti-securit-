package com.fleetflow.ServiceImpl;

import com.fleetflow.Dto.ClientDto;
import com.fleetflow.Entity.Client;
import com.fleetflow.Mapper.ClientMapper;
import com.fleetflow.Repository.ClientRepository;
import com.fleetflow.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientMapper mapper;
    private final ClientRepository repos;


    @Override
    public ClientDto addClient(ClientDto dto){
        if(repos.findByEmail(dto.getEmail())){
            throw  new RuntimeException("email deja exist");
        }
        Client client=mapper.toEntity(dto);
        return mapper.toDto(repos.save(client));
    }

    @Override
    public void deleteClient(Long id){
        Client client=repos.findById(id)
                .orElseThrow(()->new RuntimeException("Client introuvable !"));
        repos.delete(client);
    }

    @Override
    public ClientDto updateClient(Long id,ClientDto clientDto){
        Client client=repos.findById(id)
                .orElseThrow(()->new RuntimeException("Client introvable !!"));
        mapper.updateClientDto(clientDto,client);
        return mapper.toDto(repos.save(client));
    }

    @Override
    public Page<ClientDto> getAllClient(Pageable pageable){
        Page<Client>clients=repos.findAll(pageable);
        return clients.map(mapper::toDto);
    }
}
