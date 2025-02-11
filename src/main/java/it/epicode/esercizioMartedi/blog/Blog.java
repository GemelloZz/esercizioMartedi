package it.epicode.esercizioMartedi.blog;


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
}
