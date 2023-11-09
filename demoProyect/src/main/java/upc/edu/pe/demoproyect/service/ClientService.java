package upc.edu.pe.demoproyect.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.dto.ClientDTO;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.Services;
import upc.edu.pe.demoproyect.entities.User;
import upc.edu.pe.demoproyect.interfaceservice.ClientInterface;
import upc.edu.pe.demoproyect.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements ClientInterface {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client Insert(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> List() {
        return clientRepository.findAll();
    }

    @Override
    public Client Update(Client client) throws Exception {
        clientRepository.findById(client.getId()).
                orElseThrow(() -> new Exception("No se encontró entidad"));
        return clientRepository.save(client);
    }

    @Override
    public Client listById(int id) throws Exception {
        return clientRepository.findById(id).get();
    }

    public ClientDTO findBYDNI(int id) {
        return convertToDto(clientRepository.findById(id).get());

    }

    private ClientDTO convertToDto(Client client) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(client, ClientDTO.class);
    }



}
