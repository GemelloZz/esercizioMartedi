package it.epicode.esercizioMartedi.autore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Long> {
    public Autore findByEmail(String email);
    public Autore findByTelefono(String telefono);
    public boolean existsByTelefono(String telefono);
    public Autore findByNomeAndCognome(String nome, String cognome);
}
