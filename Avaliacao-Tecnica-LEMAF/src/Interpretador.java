/**
 * Esta classe eh parte da aplicacao "Reserva de Carros".
 * Simboliza um intérprete para os comandos de entrada em arquivo.
 * 
 * @author  Pedro Henrique Galdino Bouzon
 * @version 2019.01.17
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Interpretador {
	private String nomeArq;
	private Locadora locadora;
	public Interpretador(String nomeArq, Locadora locadora) {
		this.nomeArq = nomeArq;
		this.locadora = locadora;
	}
	/*
	 * Verifica se é um dia do meio da semana
	 */
	private boolean ehDiaNormal(String dia) {
		if(dia.equalsIgnoreCase("seg") || dia.equalsIgnoreCase("ter") || dia.equalsIgnoreCase("qua") || dia.equalsIgnoreCase("qui")
				|| dia.equalsIgnoreCase("sex")) {
			return true;
		}
		else return false;
		
	}
	/*
	 * Vefifica se a data é no fim de semana.
	 */
	private boolean ehDiaFDS(String dia) {
		if (dia.equalsIgnoreCase("sab") || dia.equalsIgnoreCase("dom")) {
			return true;
		}
		else return false;
	}
	
	/*
	 * Lê um arquivo de texto com entradas no formato especificado e realiza os comandos de aluguel dos carros.
	 * @return ArrayList<String> retorno - uma lista com a resposta para cada linha do arquivo.
	 */
	public ArrayList<String> interpretar() {
		ArrayList<String> retorno = new ArrayList<String>();
		try {
			FileReader fReader = new FileReader(nomeArq);
		    BufferedReader bReader = new BufferedReader(fReader);
		    String linha = bReader.readLine();
		    int contadorDeLinhas = 0;
		    while (linha != null) {	  
		    	contadorDeLinhas++;
		    	//System.out.println(linha);
		        String[] blocos = linha.split(":");
		        if(blocos.length != 3) {
		        	System.out.print("Erro no arquivo de entrada, separe com ':' os três blocos (tipo, quantidade, datas)");
		        	System.out.println(" [Linha " + String.valueOf(contadorDeLinhas) + "]");
		        	System.exit(1);
		        }
		        
		        String tipo = blocos[0];
		        boolean clientePremium = false;
		        
		        if(tipo.equalsIgnoreCase("Normal")) clientePremium = false;
		        else if(tipo.equalsIgnoreCase("Premium")) clientePremium = true;
		        else {
		        	System.out.print("Erro no arquivo de entrada, utilize os tipos de servico 'Normal' ou 'Premium'");
		        	System.out.println(" [Linha " + String.valueOf(contadorDeLinhas) + "]");
		        	System.exit(1);
		        }
		        
		        int quantidade = Integer.parseInt(blocos[1]);
		        if(!(quantidade > 0)) {
		        	System.out.print("Erro no arquivo de entrada, a quantidade de passageiros deve ser maior que zero");
		        	System.out.println(" [Linha " + String.valueOf(contadorDeLinhas) + "]");
		        	System.exit(1);
		        }
		        String datas = blocos[2];
		        String[] dias = datas.split(",");
		        
		    	int contDiasNormais = 0;
		    	int contDiasFDS = 0;
		        for(String dia: dias) {
		        	String[] aux = dia.split("\\(");
		        	if(aux.length != 2) {
		        		System.out.print("Erro no arquivo de entrada, dia em formato invalido");
		        		System.out.println(" [Linha " + String.valueOf(contadorDeLinhas) + "]");
			        	System.exit(1);
		        	}
		        	//System.out.println(aux[1].substring(0, 3));
		        	if(this.ehDiaNormal(aux[1].substring(0, 3))) contDiasNormais++;
		        	else if(this.ehDiaFDS(aux[1].substring(0, 3))) contDiasFDS++;
		        	else {
		        		System.out.print("Erro no arquivo de entrada, dia da semana invalido");
		        		System.out.println(" [Linha " + String.valueOf(contadorDeLinhas) + "]");
			        	System.exit(1);
		        	}
		        }
		        
		        String diaRetirada = dias[0].split("\\(")[0];
		        String diaDevolucao = dias[dias.length - 1].split("\\(")[0];
		        
				if(diaRetirada.length() != 9 || diaDevolucao.length() != 9) {
					System.out.print("Erro no arquivo de entrada, data no formato errado");
					System.out.println(" [Linha " + String.valueOf(contadorDeLinhas) + "]");
		        	System.exit(1);
				}
				
		        retorno.add(locadora.alugar(clientePremium, quantidade, diaRetirada, diaDevolucao, contDiasNormais, contDiasFDS));
		        linha = bReader.readLine();
		      }
		    fReader.close();
		}
		catch (IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",
			e.getMessage());
		}
		
		return retorno;
	}
}
