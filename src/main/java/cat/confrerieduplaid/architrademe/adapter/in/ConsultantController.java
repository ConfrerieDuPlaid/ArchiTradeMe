package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.application.port.in.SearchConsultantQuery;
import cat.confrerieduplaid.architrademe.application.service.RegisterConsultantService;
import cat.confrerieduplaid.architrademe.application.port.in.RegisterConsultantCommand;
import cat.confrerieduplaid.architrademe.application.service.SearchConsultantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/consultants")
public class ConsultantController {

    private final RegisterConsultantService registerConsultant;
    private final SearchConsultantService searchConsultant;
    public ConsultantController(
            RegisterConsultantService registerConsultant,
            SearchConsultantService searchConsultant
    ) {
        this.registerConsultant = registerConsultant;
        this.searchConsultant = searchConsultant;
    }

    @PostMapping
    String create(@RequestBody RegisterConsultantRequest registerConsultantDto) {
        final String id = UUID.randomUUID().toString();
        final var toCreate = RegisterConsultantCommand.builder()
                .id(id)
                .lastName(registerConsultantDto.lastName)
                .firstName(registerConsultantDto.firstName)
                .availability(registerConsultantDto.availability)
                .skills(Arrays.stream(registerConsultantDto.skills).toList())
                .averageDailyRate(registerConsultantDto.averageDailyRate)
                .build();
        this.registerConsultant.handle(toCreate);
        return id;
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

        final var result = this.searchConsultant
                .search(query)
                .stream()
                .map(SearchConsultantResponse::adapt)
                .toList();

        return ResponseEntity
                .ok()
                .body(result);
    }
}
