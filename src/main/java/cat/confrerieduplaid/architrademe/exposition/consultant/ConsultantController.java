package cat.confrerieduplaid.architrademe.exposition.consultant;

import cat.confrerieduplaid.architrademe.application.service.RegisterConsultant;
import cat.confrerieduplaid.architrademe.application.service.RegisterConsultantDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

    private final RegisterConsultant registerConsultant;

    public ConsultantController(RegisterConsultant registerConsultant) {
        this.registerConsultant = registerConsultant;
    }

    @PostMapping
    String create() {
        final String id = UUID.randomUUID().toString();
        final var toCreate = RegisterConsultantDto.builder()
                .id(id)
                .lastName("GEDUSOR")
                .firstName("Tom")
                .availability(new String[]{"2022-11-21", "2022-11-22"})
                .skills(new String[]{"Architecture Logicielle", "UML"})
                .averageDailyRate(100.0)
                .build();
        this.registerConsultant.register(toCreate);
        return id;
    }
}
