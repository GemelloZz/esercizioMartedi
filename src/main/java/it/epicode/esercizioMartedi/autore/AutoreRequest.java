package it.epicode.esercizioMartedi.autore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {
private String nome;
private String cognome;
private String dataDiNascita;
private String email;
private String telefono;


}
