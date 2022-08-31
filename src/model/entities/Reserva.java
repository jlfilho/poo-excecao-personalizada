package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroDoQuarto, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if(checkOut.isBefore(checkIn)) {
			throw new DomainException("A data de check-out deve ser após a "
					+ "data de check-in!");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		Duration diferanca = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		return diferanca.toDays();
	}
	
	public void atualizarDatas(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		LocalDate agora = LocalDate.now();
		if (checkIn.isBefore(agora) || checkOut.isBefore(agora)) {
			throw new DomainException("Erro na reserva: a data para atualização"
					+ " precisa ser datas futuras!");
		} 
		if (checkOut.isBefore(checkIn)) {
			throw new DomainException("Erro na reserva: a data de check-out "
					+ "deve ser após a data de check-in!");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto "
				+ getNumeroDoQuarto()
				+ ", check-in "
				+ checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", check-out "
				+ checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", "
				+ duracao()
				+ " nite(s).";
	}
	
	
	

}
