package br.com.senai;
import java.util.Arrays;
import java.util.Scanner;

public class Principal{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String nomePorcao[] = { "Arroz", "Carne", "Salada", "Tropeiro" };
		double custoPorcaoFixo[] = { 3.00, 4.20, 2.10, 3.80 };
		int pratosFixos[][] = { { 2, 1, 1, 1 }, { 1, 2, 1, 3 }, { 1, 2, 2, 0 }, { 2, 1, 2, 3 } };
		
		double custoPorcao[] = Arrays.copyOf(custoPorcaoFixo, 4);

		int opcaoMenuPrincipal, opcaoPorcao, opcaoAlteracaoPorcao, opcaoPrato = 0, opcaoAlteracaoPrato, opcaoConfirmarPrato, novaQuantidade;;
		double novoPreco;

		do {
			System.out.println("MENU DE OPÇÕES");
			System.out.println("1- CARDÁPIO DE PORÇÕES");
			System.out.println("2- CARDÁPIO DE PRATOS MONTADOS");
			System.out.println("3- ALTERAR PRATOS");
			System.out.println("4- ALTERAR PREÇO DAS PORÇÕES");
			System.out.println("0- SAIR");
			opcaoMenuPrincipal = input.nextInt();
			while (opcaoMenuPrincipal < 0 || opcaoMenuPrincipal > 4) {
				System.out.println("Opção inválida.\nDigite novamente: ");
				opcaoMenuPrincipal = input.nextInt();
			}
			switch (opcaoMenuPrincipal) {
			case 1:
				// OPÇÃO 1
				System.out.println("CARDÁPIO DE PORÇÕES: ");
				System.out.println();
				for (int i = 0; i < nomePorcao.length; i++) {
					System.out.println(+(i + 1) + "- Porção de " + nomePorcao[i] + ": R$ "+ String.format("%.2f", custoPorcao[i]));
				}
				System.out.println();
				//
				break;
			case 2:
				// OPÇÃO 2
				System.out.println("CARDÁPIO DE PRATOS MONTADOS: ");
				for (int i = 0; i < custoPorcaoFixo.length; i++) {
					System.out.println("\nPrato " + (i + 1) + ": ");
					double valorTotal = 0.0;
					for (int j = 0; j < custoPorcaoFixo.length; j++) {
						if (pratosFixos[i][j] > 0) {
							if (pratosFixos[i][j] == 1) {
								System.out.println("0" + pratosFixos[i][j] + " Porção de " + nomePorcao[j] + " ");
							} else {
								System.out.println("0" + pratosFixos[i][j] + " Porções de " + nomePorcao[j] + " ");
							}
						}
						valorTotal += pratosFixos[i][j] * custoPorcao[j];
					}
					System.out.println("R$ " + formatarMoeda(valorTotal));
				}
				System.out.println();
				//
				break;
			case 3:
				System.out.println("ALTERAR PRATOS: ");

				System.out.println();
				for (int i = 0; i < custoPorcao.length; i++) {
					System.out.print((i+1)+"- Prato 0"+(i+1)+": ");
					for (int j = 0; j < custoPorcao.length; j++) {
							System.out.print("0" + pratosFixos[i][j] +" "+ nomePorcao[j]);
								if(j < custoPorcao.length - 1) {
									System.out.print(" + ");
						}
					}
					System.out.println();
				}
				System.out.println("0- VOLTAR");
				
				System.out.println();
				
				System.out.println("Qual a opção desejada ?");
				opcaoPrato = input.nextInt();
				while (opcaoPrato < 1 || opcaoPrato > 4) {
					System.out.println("Opção inválido.\nDigite novamente: ");
					opcaoPrato = input.nextInt();
				}
				
				for (int i = 0; i < custoPorcao.length; i++) {
					System.out.println((i+1)+"- 0"+pratosFixos[opcaoPrato - 1][i] +" "+ nomePorcao[i]);
				}
				
				System.out.println("\nQual porção deseja alterar ?");
				opcaoAlteracaoPrato = input.nextInt();
				while (opcaoAlteracaoPrato < 1 || opcaoAlteracaoPrato > 4) {
					System.out.println("Opção inválido.\nDigite novamente: ");
					opcaoAlteracaoPrato = input.nextInt();
				}
				
				System.out.println("Digite a nova quantidade de "+nomePorcao[opcaoAlteracaoPrato - 1]+": ");
				novaQuantidade = input.nextInt();
				if(novaQuantidade < 0) {
					System.out.println("Opção inválida.\nDigite novamente");
					novaQuantidade = input.nextInt();
				}
				
				System.out.println("Deseja alterar a quantidade de "+nomePorcao[opcaoAlteracaoPrato - 1]+" de "+pratosFixos[opcaoPrato-1][opcaoAlteracaoPrato-1]+" para "+novaQuantidade+" ?");
				System.out.println("1- SIM");
				System.out.println("2- NÃO");
				opcaoConfirmarPrato = input.nextInt();
				while (opcaoConfirmarPrato < 1 || opcaoConfirmarPrato > 2) {
					System.out.println("Opção inválida.\nDigite novamente: ");
					opcaoAlteracaoPorcao = input.nextInt();
				}
				
				if (opcaoConfirmarPrato == 1) {
					pratosFixos[opcaoPrato-1][opcaoAlteracaoPrato-1] = (int) novaQuantidade;
					System.out.println("Operação bem-sucedida.");
				}
				else {
					System.out.println("Operação cancelada.");
				}
				
				break;
			case 4:
				// OPÇÃO 4
				System.out.println("ALTERAÇÃO DE PREÇOS");
				System.out.println("\nPORÇÕES: ");
				for (int i = 0; i < nomePorcao.length; i++) {
					System.out
							.println(+(i + 1) + "- " + nomePorcao[i] + "  R$ " + formatarMoeda(custoPorcao[i]));
				}
				
				System.out.println("\nEscolha a porção: ");
				opcaoPorcao = input.nextInt();
				while (opcaoPorcao < 1 || opcaoPorcao > nomePorcao.length) {
					System.out.println("Opção inválida.\nDigite novamente: ");
					opcaoPorcao = input.nextInt();
				}
				
				System.out.print("Digite o novo preço da porção de " + nomePorcao[opcaoPorcao - 1] + ":\nR$ ");
				novoPreco = input.nextDouble();
				while (novoPreco <= 0) {
					System.out.println("Preço deve ser maior que zero.\nDigite novamente: ");
					novoPreco = input.nextDouble();
				}

				System.out.println("Confirmar alteração de R$ " + formatarMoeda(custoPorcao[opcaoPorcao - 1])+" para R$ " + formatarMoeda(novoPreco) + " ?");
				System.out.println("1- SIM");
				System.out.println("2- NÃO");
				opcaoAlteracaoPorcao = input.nextInt();
				while (opcaoAlteracaoPorcao < 1 || opcaoAlteracaoPorcao > 2) {
					System.out.println("Opção inválida.\nDigite novamente: ");
					opcaoAlteracaoPorcao = input.nextInt();
				}
				
				if (opcaoAlteracaoPorcao == 1) {
					custoPorcao[opcaoPorcao - 1] = novoPreco;
					System.out.println("Operação bem-sucedida.");
				}
				else {
					System.out.println("Operação cancelada.");
				}
			}
		} while (opcaoMenuPrincipal != 0);

		input.close();

	}

	private static String formatarMoeda(double custoPorcao) {
		return String.format("%.2f", custoPorcao);
	}

}
