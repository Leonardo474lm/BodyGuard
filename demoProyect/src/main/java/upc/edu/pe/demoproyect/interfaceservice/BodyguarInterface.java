package upc.edu.pe.demoproyect.interfaceservice;

import org.springframework.data.repository.query.Param;
import org.springframework.http.StreamingHttpOutputMessage;
import upc.edu.pe.demoproyect.entities.Bodyguard;
import upc.edu.pe.demoproyect.entities.Specialization;


import java.util.List;

public interface BodyguarInterface {
    public Bodyguard Insert(Bodyguard bodyguard)throws Exception;

    public List<Bodyguard> List();

    public Bodyguard Update(Bodyguard bodyguard) throws Exception;

    public Bodyguard listById(int id) throws Exception;
    Integer getAverageReviewByBodyguardId(int bodyguardId);

}
