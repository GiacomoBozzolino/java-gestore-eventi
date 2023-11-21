package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.lessons.java.pojo.Evento;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            // Chiedi all'utente di inserire i dettagli per un nuovo evento
            System.out.println("Inserisci il titolo dell'evento:");
            String titolo = in.nextLine();

            System.out.println("Inserisci la data dell'evento (formato dd/MM/yyyy):");
            String strDate = in.nextLine();
            LocalDate data = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Inserisci il numero di posti totali disponibili:");
            String strPostiTotali=in.nextLine();
            int intPostiTotali = Integer.valueOf(strPostiTotali);
            

            // Crea un nuovo evento
            Evento evento = new Evento(titolo, data, intPostiTotali);
            System.out.println("Data dell'evento: " + evento.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            // Chiedi all'utente se vuole effettuare delle prenotazioni
            System.out.println("Vuoi effettuare delle prenotazioni? (sì/no):");
            String rispostaPrenotazioni = in.nextLine();

            if (!rispostaPrenotazioni.equals("no")) {
                System.out.println("Quante prenotazioni vuoi effettuare?");
                String strNumeroPrenotazioni=in.nextLine();
                int numeroPrenotazioni = Integer.valueOf(strNumeroPrenotazioni);

                // Effettua le prenotazioni
                for (int i = 0; i < numeroPrenotazioni; i++) {
                    evento.prenota();
                    System.out.println("Prenotazione effettuata con successo.");
                }
            }

            // Stampa il numero di posti prenotati e disponibili
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            // Chiedi all'utente se vuole disdire dei posti
            System.out.println("Vuoi disdire dei posti? (sì/no):");
            String rispostaDisdette = in.nextLine();
            

            if (!rispostaDisdette.equalsIgnoreCase("no")) {
                System.out.println("Quanti posti vuoi disdire?");
                
                String strnumeroDisdette=in.nextLine();
                int numeroDisdette = Integer.valueOf(strnumeroDisdette);

                // Effettua le disdette
                for (int i = 0; i < numeroDisdette; i++) {
                    evento.disdici();
                    System.out.println("Disdetta effettuata con successo.");
                }
            }

            // Stampa il numero di posti prenotati e disponibili dopo le disdette
            System.out.println("Posti prenotati dopo le disdette: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili dopo le disdette: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            System.out.println(evento);
        } catch (Exception e) {
            System.out.println("Errore generale: " + e.getMessage());
        }

        // Chiusura dello scanner
        in.close();
    }
}
