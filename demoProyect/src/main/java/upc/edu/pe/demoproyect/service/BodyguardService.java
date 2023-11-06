package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Bodyguard;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.interfaceservice.BodyguarInterface;
import upc.edu.pe.demoproyect.repository.BodyguardRepository;

import java.util.List;

@Service
public class BodyguardService implements BodyguarInterface {
    @Autowired
    private BodyguardRepository bodyguardRepository;

    @Override
    public Bodyguard Insert(Bodyguard bodyguard) {
        return bodyguardRepository.save(bodyguard);
    }

    @Override
    public List<Bodyguard> List() {
        return bodyguardRepository.findAll();
    }

    @Override
    public Bodyguard Update(Bodyguard bodyguard) throws Exception {
        bodyguardRepository.findById(bodyguard.getId()).
                orElseThrow(() -> new Exception("No se encontró entidad"));
        return bodyguardRepository.save(bodyguard);
    }

    public List<Bodyguard> getBodyguardsBySpecialization(int specializationId) {
        return bodyguardRepository.findBySpecializationId(specializationId);
    }

    public List<Bodyguard> getBodyguardsByAddress(String address) {
        // Utiliza el método del repositorio para buscar guardaespaldas por dirección
        return bodyguardRepository.findByDistrict(address);
    }

    public float getAverageReviewByBodyguardId(int id) {
        return bodyguardRepository.getAverageReviewByBodyguardId(id);
    }

}
