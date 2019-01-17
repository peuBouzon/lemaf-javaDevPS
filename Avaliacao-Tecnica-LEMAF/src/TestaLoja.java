import junit.framework.TestCase;

public class TestaLoja extends TestCase {

	public void testaOrcar() {
		
		double desejado;
		double resposta;
		
		Loja southCar = new Loja("SouthCar", 210, 150, 200, 90);
		Loja westCar = new Loja("WestCar", 530, 150, 200, 90);
		Loja northCar = new Loja("NorthCar", 630, 580, 600, 590);
		
		resposta = southCar.orcar(false, 1, 1);
		desejado = 410;
		assertEquals(desejado, resposta);
		
		resposta = southCar.orcar(true, 1, 1);
		desejado = 240;
		assertEquals(desejado, resposta);
		
		resposta = westCar.orcar(false, 1, 1);
		desejado = 730;
		assertEquals(desejado, resposta);
		
		resposta = westCar.orcar(true, 1, 1);
		desejado = 240;
		assertEquals(desejado, resposta);
		
		resposta = northCar.orcar(false, 1, 1);
		desejado = 1230;
		assertEquals(desejado, resposta);
		
		resposta = northCar.orcar(true, 1, 1);
		desejado = 1170;
		assertEquals(desejado, resposta);
	}
	
}
