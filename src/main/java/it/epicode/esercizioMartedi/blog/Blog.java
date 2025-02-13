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
    @Column(name = "categoria")
    private String categoria ;
    @Column(name = "titolo")
    private String titolo ;
    @Column(name = "contenuto")
    private String contenuto;
    @Column(name = "tempoDiLettura")
    private double tempoDiLettura;
    @Column(name = "cover")
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
