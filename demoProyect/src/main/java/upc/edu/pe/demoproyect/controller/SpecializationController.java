package upc.edu.pe.demoproyect.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.demoproyect.dto.SpecializationDTO;

import upc.edu.pe.demoproyect.entities.Specialization;
import upc.edu.pe.demoproyect.service.SpecializationService;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = {"http://localhost:4200","http://18.234.158.162"})
@RestController
@RequestMapping("/Specialization")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;
    //////////////////////////////////////////////////////////////////////////////////
    private SpecializationDTO convertToDto(Specialization specialization) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(specialization, SpecializationDTO.class);
    }

    private Specialization convertToEntity(SpecializationDTO specializationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(specializationDTO, Specialization.class);
    }

    private List<SpecializationDTO> convertToLisDto(List<Specialization> list) {
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
/////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/insert")
    public ResponseEntity<SpecializationDTO> register(@RequestBody SpecializationDTO specializationDTO) {
        Specialization specialization;
        SpecializationDTO dto=null;
        try {
            specialization = convertToEntity(specializationDTO);
            specialization = specializationService.Insert(specialization);
            dto = convertToDto(specialization);
        }
        catch(Exception e){
            //logeas el error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
        }
        return new ResponseEntity<SpecializationDTO>(dto,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<SpecializationDTO> Update(@RequestBody SpecializationDTO specializationDTO) {
        Specialization specialization;
        SpecializationDTO specializationDTO1=null;
        try {
            specialization = convertToEntity(specializationDTO);
            specialization=specializationService.Update(specialization);
            specializationDTO1=convertToDto(specialization);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido actualizar");

        }
        return new ResponseEntity<SpecializationDTO>(specializationDTO1, HttpStatus.OK);

    }

    @GetMapping("/List")
    public ResponseEntity<List<Specialization>> List() {
        List<Specialization> specialization = null;

        specialization = specializationService.List();
        return new ResponseEntity<List<Specialization>>(specialization, HttpStatus.OK);
    }

    @DeleteMapping("/Delete/{id}")
    Specialization delete(@PathVariable(value = "id") int id){
        Specialization specialization;
        try{
            specialization = specializationService.Delete(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar");
        }
        return specialization ;
    }
    @GetMapping("/{id}")
    Specialization listById(@PathVariable(value = "id") int id){
        Specialization specialization;
        try{
            specialization = specializationService.listById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro el usuario");
        }
        return specialization ;
    }


}
