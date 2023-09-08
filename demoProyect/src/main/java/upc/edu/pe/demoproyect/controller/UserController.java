package upc.edu.pe.demoproyect.controller;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.modelmapper.internal.bytebuddy.matcher.ModifierMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.demoproyect.dto.UserDTO;
import upc.edu.pe.demoproyect.entities.User;
import upc.edu.pe.demoproyect.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public void Insert(@RequestBody UserDTO userDTO) {
        ModelMapper m = new ModelMapper();
        User user = m.map(userDTO, User.class);
        userService.Insert(user);
    }
//convertid///////////////////////////////////
    private User convertToUser(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO ConvertToDTO(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO=modelMapper.map(user, UserDTO.class);
        return userDTO;
    }


    @GetMapping("/list1")
    public List<UserDTO> ConvertToListDTO(List<User> list) {
        return list.stream().map(this::ConvertToDTO).collect(Collectors.toList());
    }


    ///////////////////////////////////////
    @GetMapping("/list2")
    public ResponseEntity< List<UserDTO>> listar() {

        List<User> list;
        List<UserDTO> ListDto = null;
        try {
            list = userService.List();
            ListDto = ConvertToListDTO(list);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista no encontrada");
        }
        return new ResponseEntity<>(ListDto, HttpStatus.OK);

    }




    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Integer id) {

    }

    @PutMapping
    public ResponseEntity<User> Update(@RequestBody User user) {
        User user1;
        try {
            user1 = userService.Update(user);
        }catch(Exception e){
            //aqui se graba en el log el error tecnico que lo tiene e
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede actualizar");
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}