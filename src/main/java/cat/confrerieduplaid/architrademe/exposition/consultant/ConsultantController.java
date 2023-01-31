package cat.confrerieduplaid.architrademe.exposition.consultant;

import cat.confrerieduplaid.architrademe.application.service.register.RegisterConsultantHandler;
import cat.confrerieduplaid.architrademe.application.service.register.RegisterConsultantCommand;
import cat.confrerieduplaid.architrademe.application.service.search.SearchConsultant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/consultants")
public class ConsultantController {

    private final RegisterConsultantHandler registerConsultant;
    private final SearchConsultant searchConsultant;
    public ConsultantController(
            RegisterConsultantHandler registerConsultant,
            SearchConsultant searchConsultant
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
        this.registerConsultant.register(toCreate);
        return id;
    }

    @GetMapping
    ResponseEntity<List<SearchConsultantResult>> search(
            @RequestParam(required = false) String skills,
            @RequestParam(required = false) String minAverageDailyRate,
            @RequestParam(required = false) String maxAverageDailyRate
    ) {
        final var criteria = new HashMap<String, String>();
        if(skills != null) criteria.put("Skills", skills);
        if(minAverageDailyRate != null) criteria.put("MinAverageDailyRate", minAverageDailyRate);
        if(maxAverageDailyRate != null) criteria.put("MaxAverageDailyRate", maxAverageDailyRate);

        final var result = this.searchConsultant
                .search(criteria)
                .stream()
                .map(SearchConsultantResult::adapt)
                .toList();

        return ResponseEntity
                .ok()
                .body(result);
    }
}
