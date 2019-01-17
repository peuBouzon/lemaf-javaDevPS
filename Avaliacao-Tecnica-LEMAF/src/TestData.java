import junit.framework.TestCase;
public class TestData extends TestCase {
	public void testSucede() {
		Data data1 = new Data("16Mar2001");
		Data data2 = new Data("17Mar2001");
		boolean retornoEsperado = true;
		assertEquals(retornoEsperado, data2.sucede(data1));
		
		Data data3 = new Data("16Feb2001");
		Data data4 = new Data("16Mar2001");
		retornoEsperado = true;
		assertEquals(retornoEsperado, data4.sucede(data3));
		
		Data data5 = new Data("16Mar2001");
		Data data6 = new Data("16Mar2002");
		retornoEsperado = true;
		assertEquals(retornoEsperado, data6.sucede(data5));
		
		Data data7 = new Data("01Feb2001");
		Data data8 = new Data("30Jan2001");
		retornoEsperado = false;
		assertEquals(retornoEsperado, data8.sucede(data7));

	}
	
}
