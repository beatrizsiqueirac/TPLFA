

import java.util.ArrayList;
import java.util.Stack;

public class APD {
	ArrayList<String> estados;
	ArrayList<Character> alfabeto;
	ArrayList<Character> simbolosPilha;
	ArrayList<String[]> regras;
	String estadoInicial;
	ArrayList<String> estadosFinais;
	
	String estadoAtual;
	Stack<Character> pilha;
	
	public APD() {
		pilha = new Stack<>();
	}
	
	void setEstados(ArrayList<String>estados) {
		this.estados = estados;
	}
	void setAlfabeto(ArrayList<Character>alfabeto) {
		this.alfabeto = alfabeto;
	}
	void setSimbolosPilha(ArrayList<Character>simbolosPilha) {
		this.simbolosPilha = simbolosPilha;
	}
	void setRegras(ArrayList<String[]> regras) {
		this.regras = regras;
	}
	void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	void setEstadosFinais(ArrayList<String> estadosFinais) {
		this.estadosFinais = estadosFinais;
	}
	
	ArrayList<String> getEstados(){
		return estados;
	}
	
	ArrayList<String> getEstadosFinais(){
		return estadosFinais;
	}
	ArrayList<String[]> getRegras(){
		return regras;
	}
	ArrayList<Character> getAlfabeto(){
		return alfabeto;
	}
	ArrayList<Character> getSimbolosPilha(){
		return simbolosPilha;
	}
	
	String getEstadoInicial() {
		return estadoInicial;
	}
	
	void iniciarAPD() {
		estadoAtual = estadoInicial;
		pilha.clear();
	}
	boolean verificarPalavra(String palavra) {
		iniciarAPD();
		//Falta Completar Aqui :)
		int indexPalavra = 0;
		if(palavra.charAt(0)=='#')
			indexPalavra = palavra.length();
		while((indexPalavra<palavra.length()) || (pilha.isEmpty() == false)) {
			//System.out.printf("%d\n",indexPalavra);
			String [] regra;
			if(pilha.isEmpty()) {
				if(indexPalavra>=palavra.length())
					regra = verificaRegra('#','#',estadoAtual);
				else
					regra = verificaRegra(palavra.charAt(indexPalavra),'#',estadoAtual);
			}
			else {
				if(indexPalavra>=palavra.length())
					regra = verificaRegra('#',pilha.get(pilha.size()-1),estadoAtual);
				else
					regra = verificaRegra(palavra.charAt(indexPalavra),pilha.get(pilha.size()-1),estadoAtual);
			}
				
			if(regra == null) {
				return false;
			}
			else {
				estadoAtual = regra[3];
				if(regra[1].equals(Character.toString('#')));
				else
					indexPalavra++;
				if(regra[2].equals(Character.toString('#')));
				else
					pilha.pop();
				if(regra[4].equals(Character.toString('#')));
				else {
					for(int i=regra[4].length()-1;i>=0;i--) {
						pilha.push(regra[4].charAt(i));
					}
				}				
			}
		}
		if(estadosFinais.contains(estadoAtual))
			return true;
		else
			return false;
	}
	
	String[] verificaRegra(char caracterPalavra, char cabecaPilha, String estadoAtual) {
		String[] regra;
		for(int i = 0;i<regras.size();i++) {
			regra = regras.get(i);
			if(estadoAtual.equals(regra[0])) {
				if(regra[1].equals(Character.toString(caracterPalavra)) || regra[1].equals(Character.toString('#'))){
					if(regra[2].equals(Character.toString(cabecaPilha)) || regra[2].equals(Character.toString('#'))) {
						//System.out.println("Achei regra");
						//for(int j=0;j<regra.length;j++)
						//	System.out.printf("%s ",regra[j]);
						//System.out.printf("pala = %c pilha %c\n",caracterPalavra,cabecaPilha);
						//System.out.println();
						return regra;
					}
				}
			}			
		}
		return null;
	}
	

}
