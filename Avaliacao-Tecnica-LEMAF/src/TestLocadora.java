import junit.framework.TestCase;

public class TestLocadora extends TestCase {
	
	public void testaAlugar() {
		Locadora locadora = new Locadora();
		
		Loja southCar = new Loja("SouthCar", 210, 150, 200, 90);
		Loja westCar = new Loja("WestCar", 530, 150, 200, 90);
		Loja northCar = new Loja("NorthCar", 630, 580, 600, 590);
		
		Compacto compacto1 = new Compacto("Golf");
		Compacto compacto2 = new Compacto("Gol");
		Compacto compacto3 = new Compacto("Celta");
		Compacto compacto4 = new Compacto("Uno");
		
		Esportivo sport1 = new Esportivo("Ferrari");
		Esportivo sport2 = new Esportivo("Porsche");
		
		SUV suv1 = new SUV("Navigator");
		SUV suv2 = new SUV("Santa Fé");
		
		southCar.adicionarVeiculo(compacto1);
		southCar.adicionarVeiculo(compacto2);
		southCar.adicionarVeiculo(compacto3);
		southCar.adicionarVeiculo(compacto4);
		
		westCar.adicionarVeiculo(sport1);
		westCar.adicionarVeiculo(sport2);
		
		northCar.adicionarVeiculo(suv1);
		northCar.adicionarVeiculo(suv2);
		
		locadora.adicionarLoja(southCar);
		locadora.adicionarLoja(westCar);
		locadora.adicionarLoja(northCar);
		
		String resposta = locadora.alugar(false, 5, "16Mar2009", "18Mar2009", 3, 0);
		String desejado = "Navigator: NorthCar";
		assertEquals(desejado, resposta);
		
		resposta = locadora.alugar(true, 2, "16Mar2009", "18Mar2009", 3, 0);
		desejado = "Ferrari: WestCar";
		assertEquals(desejado, resposta);
		
		resposta = locadora.alugar(false, 3, "16Mar2009", "18Mar2009", 3, 0);
		desejado = "Golf: SouthCar";
		assertEquals(desejado, resposta);
		
		resposta = locadora.alugar(false, 3, "16Mar2009", "18Mar2009", 3, 0);
		desejado = "Gol: SouthCar";
		assertEquals(desejado, resposta);
		
		resposta = locadora.alugar(false, 1, "16Mar2009", "17Mar2009", 0, 2);
		desejado = "Porsche: WestCar";
		assertEquals(desejado, resposta);
		
		resposta = locadora.alugar(false, 1, "16Mar2009", "17Mar2009", 0, 2);
		desejado = "Celta: SouthCar";
		assertEquals(desejado, resposta);
		
		resposta = locadora.alugar(false, 3, "10Dec2009", "11Dec2009", 0, 2);
		desejado = "Golf: SouthCar";
		assertEquals(desejado, resposta);
		
		resposta = locadora.alugar(false, 3, "12Dec2009", "13Dec2009", 0, 2);
		desejado = "Golf: SouthCar";
		assertEquals(desejado, resposta);
	}
}
