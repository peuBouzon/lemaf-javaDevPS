/**
 * Esta classe eh parte da aplicacao "Reserva de Carros".
 * Simboliza uma data. Contém funcoes para comparar datas.
 * Transforma a formatacao -> "16Mar2009" eh decomposto em:
 * dia = 16
 * mes = 3
 * ano = 2009
 * 
 * @author  Pedro Henrique Galdino Bouzon
 * @version 2019.01.17
 */
import java.util.HashMap;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	private HashMap<String, Integer> meses;

	public Data(String data) {
		meses = new HashMap<String, Integer>();
		meses.put("Jan", 1);
		meses.put("Feb", 2);
		meses.put("Mar", 3);
		meses.put("Apr", 4);
		meses.put("May", 5);
		meses.put("Jun", 6);
		meses.put("Jul", 7);
		meses.put("Aug", 8);
		meses.put("Sep", 9);
		meses.put("Oct", 10);
		meses.put("Nov", 11);
		meses.put("Dec", 12);
		
		dia = Integer.parseInt(data.substring(0, 2));
		mes = meses.get(data.substring(2, 5));
		ano = Integer.parseInt(data.substring(5, 9));
	}

	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	/*
	 * Esta função diz se uma data sucede à outra.
	 * @param Data data - uma data para para ser comparada.
	 * @return boolean - true: se a data que chama o metodo suceder à passada por parâmetro.
	 * 					 false caso contrário
	 */
	public boolean sucede(Data data) {
		
		if(this.getAno()> data.getAno())
			return true;
		
		else if (this.getAno() < data.getAno())
			return false;
		
		else if(this.getMes() > data.getMes())
			return true;
		
		else if(this.getMes() < data.getMes())
			return false;
		
		else if(this.getDia() > data.getDia())
			return true;
		
		else
			return false;
	}
}
