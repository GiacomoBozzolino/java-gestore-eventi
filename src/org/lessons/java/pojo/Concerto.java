package org.lessons.java.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	
	private LocalTime ora;
    private BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTotali);
		  setOra(ora);
		  setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getDataOraFormattata() {
		return ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getPrezzoFormattato() {
        DecimalFormat formatoPrezzo = new DecimalFormat("##,##€");
        return formatoPrezzo.format(getPrezzo());
    }

    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

	
	
}
