package PackAgenda;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class mainAgenda {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Scanner leia= new Scanner(System.in);
		
		
		Persistencia per = null;
		PersistenciaJson json=new PersistenciaJson();
		PersistenciaXML xml = new PersistenciaXML();
		PersistenciaCSV csv=new PersistenciaCSV();
		
		ListaPessoa lista= new ListaPessoa();
		
		Pessoa p = new Pessoa();
		
			
		//gravar
		
		//csv.gravar(lista.getPessoas());
		//json.gravar(lista.getPessoas());
		//xml.gravar(lista.getPessoas());
		
		//leitura
		
		//lista.setPessoas(json.ler());
		//lista.setPessoas(csv.ler());
		//lista.setPessoas(xml.ler());
	
		//System.out.println(lista);
		
		
		
		
		boolean menu=true;
		
		while (menu) {
			System.out.println("MENU \n1-Incluir \n2- Alterar \n3- Excluir \n4- Consulta por nome \n5- Aniversariante do Mes \n6- Pesquisar dominio de email "
					+ "\n7-Ler dados \n0- Sair/Salvar ");
			int e=leia.nextInt();
			leia.nextLine();
			if (e==1) {
				p=new Pessoa();
				System.out.print(" digite o cod ");
				p.setCodigo(leia.nextInt());
				leia.nextLine();
				
				System.out.print("Nome: ");
				p.setNome(leia.nextLine());
				
				System.out.print("E-mail: ");
				p.setEmail(leia.nextLine());
				
				System.out.print("Data de nascimento dd/MM/yyyy:");
				p.setDataNasc(Arruma_data.arrumaDateStrToCal(leia.nextLine()));
				
				System.out.print("Telefone:");
				p.setFone(leia.nextLine());
				
				lista.incluir(p);
			}
			
			else if (e==4) {
				System.out.println("Digite as inicias: ");
				System.out.println(lista.consultaNome(leia.nextLine()));
			}
			
			else if (e==0) {
				System.out.println("Deseja salvar as alteracoes? \n1- sim \n2 - nao  ");
				int s=leia.nextInt();
				leia.nextLine();
				if (s==1) {
					System.out.println("\n1-XML \n2-JSON \n3-CSV");
					s=leia.nextInt();
					leia.nextLine();
					if (s==1) {
						per=new Persistencia(xml);
					}else if (s==2) {
						per=new Persistencia(json);
					}else if (s==3) {
						per=new Persistencia(csv);
					}
					per.gravacao(lista.getPessoas());
				}else{
				
				menu=false;
				}	
			}
			
			else if (e==3) {
				System.out.print("Código: ");
				lista.excluir(leia.nextInt());	
			}
			
			else if (e==5) {
				System.out.print("Mes de aniversario: ");	
				System.out.println(lista.aniversariantes(leia.nextInt()));	
			}
			
			else if (e==6) {
				System.out.println("Domínio de e-mail: ");
				System.out.println(lista.consultaDominio(leia.nextLine()));	
			}
			
			else if (e==7) {
				System.out.println("\n1-XML \n2-Json \n3-CSV");
				int o=leia.nextInt();
				leia.nextLine();
				if (o==1) {
					per = new Persistencia(xml);	
				}
				else if (o==2) {
					per = new Persistencia(json);	
				}
				else  {
				per = new Persistencia(csv);
				}
				lista.setPessoas(per.leitura());
				System.out.println(lista);
			 
		}else if (e==2) {
			lista.alterar(p);
		}

	}

}
}
