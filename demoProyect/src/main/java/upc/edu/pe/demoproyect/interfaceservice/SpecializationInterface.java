package upc.edu.pe.demoproyect.interfaceservice;

import upc.edu.pe.demoproyect.entities.Specialization;

import java.util.List;

public interface SpecializationInterface {
    public Specialization Insert(Specialization specialization)throws Exception;

    public List<Specialization> List();

    public Specialization Update(Specialization specialization) throws Exception;
    public Specialization Delete(int id) throws Exception;
    public Specialization listById(int id) throws Exception;

}
