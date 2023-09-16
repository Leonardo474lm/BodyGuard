package upc.edu.pe.demoproyect.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.demoproyect.dto.BodyguardDTO;
import upc.edu.pe.demoproyect.dto.ClientDTO;
import upc.edu.pe.demoproyect.entities.Bodyguard;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.service.BodyguardService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Bodyguard")
public class BodyguardController {
    @Autowired
    private BodyguardService bodyguardService;
    private BodyguardDTO convertToDto(Bodyguard bodyguard) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bodyguard, BodyguardDTO.class);
    }

    private Bodyguard convertToEntity(BodyguardDTO bodyguard) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bodyguard, Bodyguard.class);
    }

    private List<BodyguardDTO> convertToLisDto(List<Bodyguard> list) {
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/insert")
    public ResponseEntity<BodyguardDTO> register(@RequestBody BodyguardDTO bodyguarddto) {
          Bodyguard bodyguard;
        BodyguardDTO dto=null;
        try {
            bodyguard = convertToEntity(bodyguarddto);
            bodyguard = bodyguardService.Insert(bodyguard);
            dto = convertToDto(bodyguard);
        }
        catch(Exception e){
            //logeas el error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
        }
        return new ResponseEntity<BodyguardDTO>(dto,HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<BodyguardDTO> Update(@RequestBody BodyguardDTO bodyguardDTO) {
        Bodyguard bodyguard1;
        BodyguardDTO bodyguardDTO1TO=null;
        try {
            bodyguard1 = convertToEntity(bodyguardDTO);
            bodyguard1=bodyguardService.Update(bodyguard1);
            bodyguardDTO1TO=convertToDto(bodyguard1);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido actualizar");

        }
        return new ResponseEntity<BodyguardDTO>(bodyguardDTO1TO, HttpStatus.OK);

    }

    @GetMapping("/List")
    public ResponseEntity<List<Bodyguard>> List() {
        List<Bodyguard> bodyguards = null;

        bodyguards = bodyguardService.List();
        return new ResponseEntity<List<Bodyguard>>(bodyguards, HttpStatus.OK);
    }



}