package com.one.digitalinnovation.citiesapi.staties;
import com.one.digitalinnovation.citiesapi.staties.entities.State;
import com.one.digitalinnovation.citiesapi.staties.repository.StateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/staties")
public class StateResource {
    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<State> staties() {
        return repository.findAll();
    }
}