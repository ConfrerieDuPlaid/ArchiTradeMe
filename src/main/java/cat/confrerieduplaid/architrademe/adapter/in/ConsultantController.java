package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.application.port.in.RegisterConsultantCommand;
import cat.confrerieduplaid.architrademe.application.port.in.SearchConsultantQuery;
import cat.confrerieduplaid.architrademe.application.service.dto.SearchConsultantResultDto;
import cat.confrerieduplaid.architrademe.kernel.CommandBus;
import cat.confrerieduplaid.architrademe.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultants")
public class ConsultantController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public ConsultantController(
            CommandBus commandBus,
            QueryBus queryBus
    ) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping
    String create(@RequestBody RegisterConsultantRequest registerConsultantDto) {
        final String id = UUID.randomUUID().toString();
        final var registerCommand = RegisterConsultantCommand.builder()
                .id(id)
                .lastName(registerConsultantDto.lastName)
                .firstName(registerConsultantDto.firstName)
                .availability(registerConsultantDto.availability)
                .skills(Arrays.stream(registerConsultantDto.skills).toList())
                .averageDailyRate(registerConsultantDto.averageDailyRate)
                .build();
        return (String) commandBus.post(registerCommand);
    }

    @GetMapping
    ResponseEntity<List<SearchConsultantResponse>> search(
            @RequestParam(required = false) String skills,
            @RequestParam(required = false) Double minAverageDailyRate,
            @RequestParam(required = false) Double maxAverageDailyRate
    ) {

        final var query = SearchConsultantQuery
                .builder()
                .skills(skills == null ? null : List.of(skills.split(",")))
                .minAverageDailyRate(minAverageDailyRate)
                .maxAverageDailyRate(maxAverageDailyRate)
                .build();

        final var consultants = (List<SearchConsultantResultDto>) queryBus.post(query);
        final var result = consultants.stream().map(SearchConsultantResponse::adapt).toList();

        return ResponseEntity
                .ok()
                .body(result);
    }
}
