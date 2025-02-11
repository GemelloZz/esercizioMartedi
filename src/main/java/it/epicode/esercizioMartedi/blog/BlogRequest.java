package it.epicode.esercizioMartedi.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequest {
    private String categoria;
    private String titolo;
    private String contenuto;
    private double tempoDiLettura;
    private String cover;
}
