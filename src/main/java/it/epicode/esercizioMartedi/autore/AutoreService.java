package it.epicode.esercizioMartedi.autore;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepository autoreRepository;

  public Autore getAutore(Long id) {
    Optional<Autore> autore = autoreRepository.findById(id);
    return autore.orElse(null);
  }
  public List<Autore> getAllAutori() {
        return autoreRepository.findAll();
    }

    public Autore createAutore(Autore autore) {
        return autoreRepository.save(autore);
    }

    public Autore updateAutore(Long id, Autore autore) {
        Autore autoreToUpdate = getAutore(id);
        autoreToUpdate.setNome(autore.getNome());
        autoreToUpdate.setCognome(autore.getCognome());

        return autoreRepository.save(autoreToUpdate);
    }

    public void deleteAutore(Long id) {
        autoreRepository.deleteById(id);
    }
}

