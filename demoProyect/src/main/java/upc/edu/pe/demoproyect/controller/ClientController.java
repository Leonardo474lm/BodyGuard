package upc.edu.pe.demoproyect.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.demoproyect.dto.ClientDTO;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    private ClientDTO convertToDto(Client client) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(client, ClientDTO.class);
    }

    private Client convertToEntity(ClientDTO clientDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clientDTO, Client.class);
    }

    private List<ClientDTO> convertToLisDto(List<Client> list) {
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/insert")
    public ResponseEntity<ClientDTO> register(@RequestBody ClientDTO clientDTO) {
        Client client;
        ClientDTO dto=null;
        try {
            client = convertToEntity(clientDTO);
            client = clientService.Insert(client);
            dto = convertToDto(client);
        }
        catch(Exception e){
            //logeas el error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
        }
        return new ResponseEntity<ClientDTO>(dto,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> Update(@RequestBody Client client) {
        Client client1;
        try {
            client1 = clientService.Update(client);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido actualizar");

        }
        return new ResponseEntity<Client>(client1, HttpStatus.OK);

    }

    @GetMapping("/List")
    public ResponseEntity<List<Client>> List() {
        List<Client> client = null;

        client = clientService.List();
        return new ResponseEntity<List<Client>>(client, HttpStatus.OK);
    }

}
