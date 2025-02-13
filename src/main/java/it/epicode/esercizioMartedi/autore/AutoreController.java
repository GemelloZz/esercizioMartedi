package it.epicode.esercizioMartedi.autore;

import com.cloudinary.Cloudinary;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blog/autori")
@RequiredArgsConstructor

public class AutoreController {
    private final AutoreService autoreService;

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Cloudinary cloudinary;

    @PostMapping("/{id}/carica-immagine")
    @ResponseStatus(HttpStatus.CREATED)
    public String caricaImmagine(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
       try {
           Map result = cloudinary.uploader().upload(file.getBytes(), Cloudinary.asMap("folder", "FS0824", "public_id", file.getOriginalFilename()));
           autoreService.getAutore(id).setCover(result.get("secure_url").toString());
          autoreRepository.save(autoreService.getAutore(id));
           return result.get("secure_url").toString();


       } catch (IOException e) {
           throw new RuntimeException("error uploading image",e);
       }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> getAllAutori() {
        return autoreService.getAllAutori();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore getAutore(@PathVariable  Long id) {
        if (autoreService.getAutore(id).isEmpty()) {
            throw new EntityNotFoundException("Autore con ID " + id + " non trovato.");
        }

        return autoreService.getAutore(id);

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody AutoreRequest autoreRequest) {
        Autore autore = new Autore();
        autore.setNome(autoreRequest.getNome());
        autore.setCognome(autoreRequest.getCognome());
        autore.setDataDiNascita(autoreRequest.getDataDiNascita());
        autore.setEmail(autoreRequest.getEmail());
        autore.setTelefono(autoreRequest.getTelefono());
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
