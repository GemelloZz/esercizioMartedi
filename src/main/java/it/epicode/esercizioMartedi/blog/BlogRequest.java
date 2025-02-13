package it.epicode.esercizioMartedi.blog;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequest {
    @NotBlank(message = "Il campo non può essere vuoto")
    private String categoria;
    @NotBlank(message = "Il campo non può essere vuoto")
    private String titolo;
    @NotBlank(message = "Il campo non può essere vuoto")
    private String contenuto;
    @NotBlank(message = "Il campo non può essere vuoto")
    private double tempoDiLettura;

    private String cover;

}
