package upc.edu.pe.demoproyect.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.demoproyect.dto.BodyguardDTO;

import upc.edu.pe.demoproyect.entities.Bodyguard;

import upc.edu.pe.demoproyect.entities.Specialization;
import upc.edu.pe.demoproyect.interfaceservice.BodyguarInterface;
import upc.edu.pe.demoproyect.service.BodyguardService;
import upc.edu.pe.demoproyect.service.SpecializationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Bodyguard")
public class BodyguardController {
    @Autowired
    private BodyguardService bodyguardService;
    @Autowired
    private SpecializationService specializationService;

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
    public ResponseEntity<Bodyguard> register(@RequestBody Bodyguard bodyguarddto) {
        Bodyguard bodyguard;
        BodyguardDTO dto = null;
        try {
            //bodyguard = convertToEntity(bodyguarddto);
            bodyguard = bodyguardService.Insert(bodyguarddto);
            dto = convertToDto(bodyguard);

        } catch (Exception e) {
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido insertar");
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido insertar" + e.getMessage());
            //return new ResponseEntity<>("Error al insertar el Bodyguard: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(bodyguarddto, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<BodyguardDTO> Update(@RequestBody BodyguardDTO bodyguardDTO) {
        Bodyguard bodyguard1;
        BodyguardDTO bodyguardDTO1TO = null;
        try {
            bodyguard1 = convertToEntity(bodyguardDTO);
            bodyguard1 = bodyguardService.Update(bodyguard1);
            bodyguardDTO1TO = convertToDto(bodyguard1);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido actualizar");

        }
        return new ResponseEntity<BodyguardDTO>(bodyguardDTO1TO, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    Bodyguard listById(@PathVariable(value = "id") int id){
        Bodyguard bodyguard;
        try{
            bodyguard = bodyguardService.listById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro el usuario");
        }
        return bodyguard ;
    }
    @GetMapping("/List")
    public ResponseEntity<List<Bodyguard>> List() {
        List<Bodyguard> bodyguards = null;

        bodyguards = bodyguardService.List();
        return new ResponseEntity<List<Bodyguard>>(bodyguards, HttpStatus.OK);
    }

    @GetMapping("/bodyguards/byspecialization/{specializationId}")
    public List<Bodyguard> getBodyguardsBySpecialization(@PathVariable int specializationId) {
        return bodyguardService.getBodyguardsBySpecialization(specializationId);
    }

    @GetMapping("/ListbyDistrict/{district}")
    public List<Bodyguard> getListByDistrict(@PathVariable String district) {
        return bodyguardService.getBodyguardsByAddress(district);
    }

    @GetMapping("/getReviewBodyguard/{id}")
    public Integer getAverageReviewByBodyguardId(@PathVariable int id) {
        return bodyguardService.getAverageReviewByBodyguardId(id);
    }
    @GetMapping("/usermail/{mail}")
    public ResponseEntity<Bodyguard> getByUserEmail(@PathVariable(value = "mail")String mail ){
        Bodyguard bodyguard;
        try{
            bodyguard = bodyguardService.getByUserEmail(mail);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro el usuario");
        }
        return new ResponseEntity<Bodyguard>(bodyguard,HttpStatus.OK);

    }
}
