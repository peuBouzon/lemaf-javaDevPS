/**
 * Esta classe eh parte da aplicacao "Reserva de Carros".
 * Sua função é desenvolver uma superclasse para as classes
 * Compacto, SUV e Esportivo (tipos de carros)
 * 
 * @author  Pedro Henrique Galdino Bouzon
 * @version 2019.01.17
 */

public abstract class Carro {
	private String id;
	private int capacidade;
	private String disponibilidade; 
	
	public Carro(String id) {
		this.id = id;
		disponibilidade = "01Jan1900";
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	
}
