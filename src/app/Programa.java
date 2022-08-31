package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Número do quarto: ");
		int numero = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Data do Check-in (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("Data do Check-out (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		if (checkOut.isBefore(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out "
					+ "deve ser após a data de check-in!");
		}
		else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println("Entre com a data de atualização da reserva: ");
			
			System.out.println("Data do Check-in (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(),
					DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			System.out.println("Data do Check-out (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(),
					DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			LocalDate agora = LocalDate.now();
			
			String erro= reserva.atualizarDatas(checkIn, checkOut);
			if (erro != null ) {
				System.out.println(erro);
			} else {
				System.out.println("Reserva: " + reserva);
			}			
		}
		
		sc.close();

	}

}
