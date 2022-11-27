package cat.confrerieduplaid.architrademe.exposition.consultant;

import cat.confrerieduplaid.architrademe.application.service.register.RegisterConsultant;
import cat.confrerieduplaid.architrademe.application.service.register.RegisterConsultantDto;
import cat.confrerieduplaid.architrademe.application.service.search.SearchConsultant;
import cat.confrerieduplaid.architrademe.domain.consultant.SearchConsultantResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

    private final RegisterConsultant registerConsultant;
    private final SearchConsultant searchConsultant;
    public ConsultantController(
            RegisterConsultant registerConsultant,
            SearchConsultant searchConsultant
    ) {
        this.registerConsultant = registerConsultant;
        this.searchConsultant = searchConsultant;
    }

    @PostMapping
    String create(@RequestBody RegisterConsultantBody registerConsultantDto) {
        final String id = UUID.randomUUID().toString();
        final var toCreate = RegisterConsultantDto.builder()
                .id(id)
                .lastName(registerConsultantDto.lastName)
                .firstName(registerConsultantDto.firstName)
                .availability(Arrays.stream(registerConsultantDto.availability).toList())
                .skills(Arrays.stream(registerConsultantDto.skills).toList())
                .averageDailyRate(registerConsultantDto.averageDailyRate)
                .build();
        this.registerConsultant.register(toCreate);
        return id;
    }

    @GetMapping
    ResponseEntity<List<SearchConsultantResult>> search(
            @RequestParam(required = false) String skills
    ) {
        final var result = this.searchConsultant
                .search(skills)
                .stream()
                .map(SearchConsultantResult::adapt)
                .toList();

        return ResponseEntity
                .ok()
                .body(result);
    }
}
