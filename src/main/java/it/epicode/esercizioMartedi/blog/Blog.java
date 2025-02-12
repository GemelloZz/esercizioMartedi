package it.epicode.esercizioMartedi.blog;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.epicode.esercizioMartedi.autore.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String categoria ;
    private String titolo ;
    private String contenuto;
    private double tempoDiLettura;
    private String cover;

    public static Blog orElse(Object o) {
        return null;
    }

    @ManyToOne
    @JsonIgnoreProperties("blog")
    private Autore autore;

    public static boolean isEmpty() {
        return false;
    }
}
