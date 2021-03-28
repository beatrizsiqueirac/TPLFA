
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorAPD {
	APD lerArquivo(String nomeArquivo){
		try {
			APD apd = new APD();
			BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
			while(true) {
				char a = (char)leitor.read();
				//System.out.printf("inicial = %c\n",a);
				if(a=='[')
					break;
			}
			ArrayList<String> estados = new ArrayList<>();
			while(true) {//Aqui lemos todos os estados
				char a = (char)leitor.read();
				if(a == ']')
					break;
				if(a == '"') {
					//System.out.printf("a = %c\n",a);
					String novoEstado = "";
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("b = %c\na = %c\n\n",b,a);
						if(b == '"') {
							estados.add(novoEstado);
							break;
						}
						else {
							//System.out.printf("checkb = %c\n",b);
							novoEstado = novoEstado.concat(Character.toString(b));
							//System.out.printf("check = %s\n",novoEstado);
						}
					}
				}				
				
			}
			apd.setEstados(estados);
			//System.out.println("Estados lidos");
			while(true) {
				char a = (char)leitor.read();
				//System.out.printf("inicial = %c\n",a);
				if(a=='[')
					break;
			}
			
			
			ArrayList<Character> alfabeto = new ArrayList<>();
			while(true) {//Aqui lemos todos os simbolos do Alfabeto
				char a = (char)leitor.read();
				if(a == ']')
					break;
				else if(a!='"' && a!=',' && a!=' ') {
					alfabeto.add(a);
				}				
			}
			apd.setAlfabeto(alfabeto);
			//System.out.println("Alfabeto lidos");
			
			while(true) {
				char a = (char)leitor.read();
				//System.out.printf("inicial = %c\n",a);
				if(a=='[')
					break;
			}
			
			ArrayList<Character> simbolosPilha = new ArrayList<>();
			while(true) {//Aqui lemos todos os simbolos do simbolosPilha
				char a = (char)leitor.read();
				if(a == ']')
					break;
				else if(a!='"' && a!=',' && a!=' ') {
					simbolosPilha.add(a);
				}				
			}
			apd.setSimbolosPilha(simbolosPilha);
			//System.out.println("Simbolos pilha lidos");
		
			
			while(true) {
				char a = (char)leitor.read();
				//System.out.printf("inicial = %c\n",a);
				if(a=='[')
					break;
			}
			
			
			
			
			ArrayList<String[]> regras = new ArrayList<>();
			while(true) {//Aqui lemos as regras
				char a = (char)leitor.read();
				if(a==']')
					break;
				else if(a=='[') {
					String estadoInicial = "";
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"')
							break;
					}
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"') {
							break;
						}
						else if(b != ' ')
							estadoInicial = estadoInicial.concat(Character.toString(b));
					}
					String simboloAlfabeto = "";
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"')
							break;
					}
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"') {
							break;
						}
						else if(b != ' ')
							simboloAlfabeto = simboloAlfabeto.concat(Character.toString(b));
					}
					
					String oQueDesempilhar = "";
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"')
							break;
					}
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"') {
							break;
						}
						else if(b != ' ')
							oQueDesempilhar = oQueDesempilhar.concat(Character.toString(b));
					}
					String estadoFinal = "";
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"')
							break;
					}
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"') {
							break;
						}
						else if(b != ' ')
							estadoFinal = estadoFinal.concat(Character.toString(b));
					}
					String oQueEmpilhar = "";
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"')
							break;
					}
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b=='"') {
							break;
						}
						else if(b != ' ')
							oQueEmpilhar = oQueEmpilhar.concat(Character.toString(b));
					}
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("inicial = %c\n",a);
						if(b==']')
							break;
					}
					String [] regra = {estadoInicial,simboloAlfabeto,oQueDesempilhar,estadoFinal,oQueEmpilhar};
					regras.add(regra);					
				}
			}
			apd.setRegras(regras);
			//System.out.println("regras lidas");
			
			
			String estadoInicial = "";
			
			while(true) {
				char a = (char)leitor.read();
				//System.out.printf("inicial = %c\n",a);
				if(a=='"')
					break;
			}
			
			while(true) {
				char a = (char)leitor.read();
				//System.out.printf("inicial = %c\n",a);
				if(a=='"')
					break;
				else if(a!=' ')
					estadoInicial = estadoInicial.concat(Character.toString(a));
			}
			
		
			apd.setEstadoInicial(estadoInicial);
			
			
									
			ArrayList<String> estadosFinais = new ArrayList<>();
			while(true) {
				char a = (char)leitor.read();
				//System.out.printf("inicial = %c\n",a);
				if(a=='[')
					break;
			}
			while(true) {//Aqui lemos todos os estados
				char a = (char)leitor.read();
				if(a == ']')
					break;
				if(a == '"') {
					//System.out.printf("a = %c\n",a);
					String novoEstado = "";
					while(true) {
						char b = (char)leitor.read();
						//System.out.printf("b = %c\na = %c\n\n",b,a);
						if(b == '"') {
							estadosFinais.add(novoEstado);
							break;
						}
						else {
							//System.out.printf("checkb = %c\n",b);
							novoEstado = novoEstado.concat(Character.toString(b));
							//System.out.printf("check = %s\n",novoEstado);
						}
					}
				}				
				
			}
			
			apd.setEstadosFinais(estadosFinais);				
			
			
			leitor.close();
			
			return apd;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
