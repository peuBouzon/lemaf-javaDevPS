/**
 * Esta classe eh parte da aplicacao "Reserva de Carros".
 * Simboliza uma loja de locação veículos especializada.
 * 
 * @author  Pedro Henrique Galdino Bouzon
 * @version 2019.01.17
 */
public class Loja {
	private String nome;
	private Frota frota;
	private double precoRegular;
	private double precoRegularFDS;
	private double precoFidelidade;
	private double precoFidelidadeFDS;

	public Loja(String nome, double precoRegular, double precoFidelidade, double precoRegularFDS, double precoFidelidadeFDS) {
		this.nome = nome;
		this.precoFidelidade = precoFidelidade;
		this.precoFidelidadeFDS = precoFidelidadeFDS;
		this.precoRegular = precoRegular;
		this.precoRegularFDS = precoRegularFDS;
		frota = new Frota();
	}
	/*
	 * Retorna o valor do orcamento do aluguel na Loja
	 * @param boolean clienteFidelidade - true caso tenha cartao fidelidade
	 * @param int nDiasNormais - numero de dias no meio da semana que o carro será alugado. 
	 * @param int nDiasFDS - numero de dias no fim de semana que o carro será alugado. 
	 * @return double orcamento - valor do orcamento na loja. 
	 */
	public double orcar(boolean clienteFidelidade, int nDiasNormais, int nDiasFDS){
		if(clienteFidelidade) 
			return precoFidelidade*nDiasNormais + precoFidelidadeFDS*nDiasFDS;
		else
			return precoRegular*nDiasNormais + precoRegularFDS*nDiasFDS;
	}
	/*
	 * Retorna um carro disponível da loja
	 * @param String retirada - data de retirada do veiculo
	 * @return Carro carro - um carro disponível, caso haja.
	 */
	public Carro getCarroDisponivel(String retirada) {
		return frota.carroDisponivel(retirada);
	}
	/*
	 * Adiciona um veiculo à Loja
	 */
	public void adicionarVeiculo(Carro c) {
		frota.adicionarVeiculo(c);
	}
	/*
	 * Aluga um veiculo da loja alterando sua disponibilidade
	 */
	public void alugarVeiculo(String id, String data) {
		frota.setDisponibilidade(id, data);
	}
	/*
	 * Retorna o nome da loja
	 */
	public String getNome() {
		return nome;
	}
}
