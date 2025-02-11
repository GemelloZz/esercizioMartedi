package it.epicode.esercizioMartedi.autore;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/autori")
@RequiredArgsConstructor

public class AutoreController {
    private final AutoreService autoreService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> getAllAutori() {
        return autoreService.getAllAutori();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore getAutore(@PathVariable  Long id) {
        return autoreService.getAutore(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody Autore autore) {
        return autoreService.createAutore(autore);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore updateAutore(@PathVariable Long id, @RequestBody Autore autore) {
        return autoreService.updateAutore(id, autore);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {
        autoreService.deleteAutore(id);
    }
}
