package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Specialization;

import upc.edu.pe.demoproyect.interfaceservice.SpecializationInterface;
import upc.edu.pe.demoproyect.repository.SpecializationRepository;

import java.util.List;

@Service
public class SpecializationService implements SpecializationInterface {
    @Autowired
    private SpecializationRepository specializationRepository;
    @Override
    public Specialization Insert(Specialization specialization) throws Exception {
        return specializationRepository.save(specialization);
    }

    @Override
    public List<Specialization> List() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization Update(Specialization specialization) throws Exception {
        specializationRepository.findById(specialization.getId()).
                orElseThrow(() -> new Exception("No se encontró entidad"));
        return specializationRepository.save(specialization);
    }

    @Override
    public Specialization Delete(int id) throws Exception {
        Specialization specialization = specializationRepository.findById(id).
                orElseThrow(() -> new Exception("no se encontro entidad gg"));
        specializationRepository.delete(specialization);
        return specialization;
    }
}
