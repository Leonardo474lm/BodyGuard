package upc.edu.pe.demoproyect.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import upc.edu.pe.demoproyect.dto.PaymentDTO;

import upc.edu.pe.demoproyect.entities.Payment;

import upc.edu.pe.demoproyect.service.PaymentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    ///////////////////////////////////////////////////////////////////
    private PaymentDTO convertToDto(Payment payment) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(payment, PaymentDTO.class);
    }

    private Payment convertToEntity(PaymentDTO payment) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(payment, Payment.class);
    }

    private List<PaymentDTO> convertToLisDto(List<Payment> list) {
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    /////////////////////////////////////////////////////////////////////


    @PostMapping("/Insert")
    public ResponseEntity<PaymentDTO> register(@RequestBody PaymentDTO paymentDTO) {
        Payment payment;
        PaymentDTO dto=null;
        try {
            payment = convertToEntity(paymentDTO);
            payment = paymentService.Insert(payment);
            dto = convertToDto(payment);
        }
        catch(Exception e){
            //logeas el error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
        }
        return new ResponseEntity<PaymentDTO>(dto,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<PaymentDTO> Update(@RequestBody PaymentDTO paymentDTO) {
        Payment payment;
        PaymentDTO paymentDTO1=null;
        try {
            payment = convertToEntity(paymentDTO);
            payment=paymentService.Update(payment);
            paymentDTO1=convertToDto(payment);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido actualizar");

        }
        return new ResponseEntity<PaymentDTO>(paymentDTO1, HttpStatus.OK);

    }

    @GetMapping("/List")
    public ResponseEntity<List<Payment>> List() {
        List<Payment> payments = null;

        payments = paymentService.List();
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }


    @DeleteMapping("/Delete/{id}")
    Payment Delete(@PathVariable(value = "id") int id){
        Payment payment;
        try{
            payment = paymentService.Delete(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar");
        }
        return payment ;
    }
}
