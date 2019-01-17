import junit.framework.TestCase;

public class TestaFrota extends TestCase {
	public void testaCarroDisponivel() {
		Frota frota = new Frota();
		Carro c1 = new Compacto("Uno");
		c1.setDisponibilidade("20Mar2019");
		
		Carro c2 = new SUV("Tiguan");
		c2.setDisponibilidade("10Mar2019");
		
		frota.adicionarVeiculo(c1);
		frota.adicionarVeiculo(c2);
		
		Carro resposta = frota.carroDisponivel("16Mar2019");
		
		assertEquals(c2, resposta);
	}
	
	public void testaSetDisponibilidade() {
		Frota frota = new Frota();
		Carro c1 = new Compacto("Uno");
		
		frota.adicionarVeiculo(c1);
		frota.setDisponibilidade("Uno", "20Mar2019");
		
		String respostaDesejada = "20Mar2019";
		
		assertEquals(respostaDesejada, c1.getDisponibilidade());
		
		frota.setDisponibilidade(c1, "22Mar2019");
		respostaDesejada = "22Mar2019";
		assertEquals(respostaDesejada, c1.getDisponibilidade());
	}
}
