/**
 * Esta classe eh parte da aplicacao "Reserva de Carros".
 * Simboliza locadora de veículos com várias lojas.
 * 
 * @author  Pedro Henrique Galdino Bouzon
 * @version 2019.01.17
 */
import java.util.ArrayList;

public class Locadora {
	private ArrayList<Loja> lojas;
	
	public Locadora() {
		lojas = new ArrayList<Loja>();
	}
	/* Aluga o veículo mais barato da locadora, levando em conta todas as lojas.
	 * Após o preço, a prioridade é o veículo com mais baixa capacidade que atende aos requisitos do cliente.
	 * Desta forma, para uma capacidade desejada de 2 lugares, se o preco da Ferrari (2 lugares) e do Golf (4 lugares)
	 * for o mesmo, então a Ferrari será escolhida para que o carro de maior capacidade atenda a quem necessita.
	 * @param boolean clienteFidelidade - true caso tenha cartao fidelidade
	 * @param int nPessoas - capacidade desejada do veiculo.
	 * @param  String dataRetirada - data de retirada do veiculo.
	 * @param  String dataDevolucao - data de devolucao do veiculo.
	 * @param int nDiasNormais - numero de dias no meio da semana que o carro será alugado. 
	 * @param int nDiasFDS - numero de dias no fim de semana que o carro será alugado. 
	 * @return String return - Nome do carro e respectiva loja escolhidos. 
	 */
	public String alugar(boolean clienteFidelidade, int nPessoas, String dataRetirada, String dataDevolucao, int nDiasNormais, int nDiasFDS) {
		String carroMaisBarato = null;
		double min = Double.MAX_VALUE;
		int capacidadeDoMaisBarato = 0;
		Loja lojaEscolhida = null;
		for(Loja loja: lojas) {
			Carro carroDisponivel = loja.getCarroDisponivel(dataRetirada);
			if(carroDisponivel!= null) {
				if(carroDisponivel.getCapacidade() >= nPessoas) {
					double orcamento = loja.orcar(clienteFidelidade, nDiasNormais,  nDiasFDS);
					if(orcamento < min) {
						min = orcamento;
						carroMaisBarato = carroDisponivel.getId();
						capacidadeDoMaisBarato = carroDisponivel.getCapacidade();
						lojaEscolhida = loja;
					}
					else if(orcamento == min) {
						if(carroDisponivel.getCapacidade() < capacidadeDoMaisBarato) {
							min = orcamento;
							carroMaisBarato = carroDisponivel.getId();
							capacidadeDoMaisBarato = carroDisponivel.getCapacidade();
							lojaEscolhida = loja;
						}
							
					}
				}
			}
		}
		if(lojaEscolhida != null) {
			lojaEscolhida.alugarVeiculo(carroMaisBarato, dataDevolucao);
			System.out.println(carroMaisBarato + ": "+ lojaEscolhida.getNome());
			return carroMaisBarato + ": "+ lojaEscolhida.getNome();
		}
		else {
			System.out.println("Todos os carros foram alugados ou nao ha nenhum que atenda os requisitos de capacidade");
			return null;
		}
	}
	/*
	 * Adiciona uma loja à locadora.
	 */
	public void adicionarLoja(Loja loja) {
		lojas.add(loja);
	}
}
