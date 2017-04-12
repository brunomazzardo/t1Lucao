package t1alged2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	public static Scanner sc = new Scanner(System.in);
	public static HashChain hc = new HashChain();
	
	public static void main(String[] args) {
		hc.add(new Item("Bola de futebol", 13, 1, 60.0));
		hc.add(new Item("Camiseta", 27, 1, 70.0));
		hc.add(new Item("Chuteria", 43, 1, 95.0));
		hc.add(new Item("Vara de pesca", 63, 4, 172.0));
		hc.add(new Item("Bola de basquete", 83, 7, 63.0));
		menu();
	}
		public static void menu(){
			int entrada = 0;
			System.out.println("=========================  MENU  =========================");
			System.out.println( "\nDigite a opção desejada:");
			System.out.println( "\n(1)Adicionar Item"+
								"\n(2)Procurar produto por código"+
								"\n(3)Procurar produto por nome"+
								"\n(4)Remover produto por código"+
								"\n(5)Informar dados do produto mais barato"+
								"\n(6)Listar todos produtos");
			try{
				entrada=sc.nextInt();
			}
			catch (InputMismatchException e){
				System.out.println("Digite apenas números");
			}
			switch(entrada){
			
			case 1:
				adicionaItem();
				menu();
				break;
			case 2:
				procuraCodigo();
				menu();
				break;
			case 3:
				procuraNome();
				menu();
				break;
			case 4:
				removeItem();
				menu();
				break;
			case 5:
				System.out.println(hc.maisBarato().toString());
				menu();
				break;
			case 6:
				for (Item i : hc.listarTodos()) {
					System.out.println(i.toString());
				}
				menu();
				break;
			default:
				System.out.println("==========================================================");
			}

		}
		
		public static void adicionaItem() {
			try {
				System.out.println("Digite nome, código, setor e valor do item:");
				String nome = sc.next();
				int setor = sc.nextInt();
				int codigo = sc.nextInt();
				double Valor = sc.nextDouble();
				if (hc.add(new Item(nome, codigo, setor, Valor))) {
					System.out.println("Item adicionado!");
				}

			} catch (Exception e) {
				System.out.println("Erro de digitação");

			}
		}
		
		public static void procuraCodigo() {
			System.out.println("Digite o código do produto:");
			try {
				int nome = sc.nextInt();
				System.out.println(hc.get(nome).toString());
			} catch (InputMismatchException M) {
				System.out.println("Apenas digite números");

			} catch (Exception E) {
				System.out.println("Produto não encontrado");
			}
		}
		
		public static void procuraNome() {
			System.out.println("Digite o nome do produto:");
			String nome = sc.next();
			try {
				System.out.println(hc.getNome(nome).toString());
			} catch (Exception E) {
				System.out.println("Produto não encontrado");
			}
		}
		
		public static void removeItem() {
			System.out.println("Digite o código do produto a ser removido:");
			try {
				int codigo = sc.nextInt();

				hc.remove(codigo);
			} catch (InputMismatchException M) {
				System.out.println("Apenas digite números");

			} catch (Exception E) {
				System.out.println("Produto não encontrado");
			}
		}
		
		


}
