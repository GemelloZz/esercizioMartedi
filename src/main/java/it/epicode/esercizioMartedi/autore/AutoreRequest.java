package it.epicode.esercizioMartedi.autore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AutoreRequest {
    @NotBlank(message = "Il campo non può essere vuoto")
private String nome;
    @NotBlank(message = "Il campo non può essere vuoto")
private String cognome;
    @NotBlank(message = "Il campo non può essere vuoto")
private String dataDiNascita;
    @Email(message = "Email non valida")
private String email;
    @NotBlank(message = "Il campo non può essere vuoto")
    @Size(min = 10, max = 10, message = "Telefono non valido")
private String telefono;


}
