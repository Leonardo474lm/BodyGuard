package upc.edu.pe.demoproyect.interfaceservice;

import upc.edu.pe.demoproyect.entities.Payment;


import java.util.List;

public interface PaymentInterface {
    public Payment Insert(Payment payment)throws Exception;

    public List<Payment> List();

    public Payment Update(Payment payment) throws Exception;
    public Payment Delete(int id) throws Exception;
}
