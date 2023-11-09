package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.Payment;
import upc.edu.pe.demoproyect.entities.User;
import upc.edu.pe.demoproyect.interfaceservice.PaymentInterface;
import upc.edu.pe.demoproyect.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService  implements PaymentInterface {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment Insert(Payment payment) throws Exception {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> List() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment Update(Payment payment) throws Exception {
        paymentRepository.findById(payment.getId()).
                orElseThrow(() -> new Exception("No se encontró entidad"));
        return paymentRepository.save(payment);
    }

    @Override
    public Payment Delete(int id) throws Exception {
        Payment payment = paymentRepository.findById(id).
                orElseThrow(() -> new Exception("no se encontro entidad gg"));
        paymentRepository.delete(payment);
        return payment;
    }

    @Override
    public Payment listById(int id) throws Exception {
        return paymentRepository.findById(id).get();
    }
}
