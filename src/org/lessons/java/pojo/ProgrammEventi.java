package org.lessons.java.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	 private List<Evento> eventi;
	 
	 public ProgrammEventi(String titolo) {
		// TODO Auto-generated constructor stub
		setTitolo(titolo);
		setEventi(new ArrayList<>());
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	  public void aggiungiEvento(Evento evento) {
	        eventi.add(evento);
	    }

    public List<Evento> eventiByDate(LocalDate data) {
        List<Evento> eventiByDate = new ArrayList<>();
        for (Evento evento : getEventi()) {
            if (evento.getData().equals(data)) {
            	eventiByDate.add(evento);
            }
        }
        return eventiByDate;
    }
    

    public int quantitaEventi() {
        return getEventi().size();
    }

    public void svuotaEventi() {
        getEventi().clear();
    }
    
    public String visualizzaProgramma(List<Evento> eventi) {

        eventi.sort(Comparator.comparing(evento -> evento.getData()));
        
        String str = getTitolo() + "\n-------------------\n";
        
        for (Evento evento : eventi) {
            
            String d = evento.getDataFormattata();
            
            String t = evento.getTitolo();
            
            str = str + d + " - " + t + "\n";
        }
        
        return str;
    }
    
    
    
    
    
    @Override
  	public String toString() {
  		// TODO Auto-generated method stub
  		return super.toString();
  	}

}
