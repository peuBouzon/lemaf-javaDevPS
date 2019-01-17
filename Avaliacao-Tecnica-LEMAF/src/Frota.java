/**
 * Esta classe eh parte da aplicacao "Reserva de Carros".
 * Simboliza uma frota de veículos de uma loja.
 * 
 * @author  Pedro Henrique Galdino Bouzon
 * @version 2019.01.17
 */
import java.util.ArrayList;
public class Frota {
	private ArrayList<Carro> frota;
	
	public Frota() {
		 frota = new ArrayList<Carro>();
	}
	
	public void adicionarVeiculo(Carro c) {
		frota.add(c);
	}
	/*
	 * Caso haja, retorna um carro disponivel na data passada por parâmetro.
	 * @param String retirada - data de retirada do veículo (Ex: "16Mar2009")
	 * @return Carro carro - um carro disponível na data.
	 */
	public Carro carroDisponivel(String retirada) {
		Data dataRetirada = new Data(retirada);
		for (Carro carro: frota) {
			String disponibilidade = carro.getDisponibilidade();
			Data dataDisponivel = new Data(disponibilidade);
			
			if(dataRetirada.sucede(dataDisponivel)) {
				return carro;
			}
		}
		return null;
	}
	/*
	 * Ajusta a disponibilidade do carro
	 * @param String id - identificacao do carro
	 * @param String data - uma nova data para o carro se tornar disponível.
	 */
	public void setDisponibilidade(String id, String data) {
		for (Carro c: frota) {
			if (c.getId() == id) {
				c.setDisponibilidade(data);
				break;
			}
		}
	}
	/*
	 * Ajusta a disponibilidade do carro
	 * @param Carro c - um carro
	 * @param String data - uma nova data para o carro se tornar disponível.
	 */
	public void setDisponibilidade(Carro c, String data) {
		c.setDisponibilidade(data);
	}
}
