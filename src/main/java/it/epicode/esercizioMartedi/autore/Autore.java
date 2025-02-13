package it.epicode.esercizioMartedi.autore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.epicode.esercizioMartedi.blog.Blog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "autore")

public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = false)
    private String nome;
    @Column(unique = false)
    private String cognome;
    private String dataDiNascita;
    private String email;
    @Column(unique = true)
    private String telefono;

    @ToString.Exclude
    @JsonIgnoreProperties("autore")
    @OneToMany(mappedBy = "autore")
  private Set<Blog> blog = new HashSet<>();

    private String cover;


    public boolean isEmpty() {
        return blog.isEmpty();
    }
}
