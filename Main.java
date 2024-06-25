import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetShop petShop = new PetShop();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- PetShop Menu ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Animal para Cliente");
            System.out.println("3. Ver Todos os Clientes");
            System.out.println("4. Ver Todos os Animais");
            System.out.println("5. Registrar Venda");
            System.out.println("6. Ver Todas as Vendas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = -1;

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                System.out.print("Escolha uma opção: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Telefone do Cliente: ");
                    String telefoneCliente = scanner.nextLine();
                    petShop.cadastrarCliente(nomeCliente, telefoneCliente);
                    break;
                case 2:
                    System.out.print("Nome do Cliente: ");
                    String nomeCli = scanner.nextLine();
                    if (petShop.buscarClientePorNome(nomeCli) != null) {
                        System.out.print("Nome do Animal: ");
                        String nomeAnimal = scanner.nextLine();
                        System.out.print("Tipo do Animal: ");
                        String tipoAnimal = scanner.nextLine();
                        petShop.cadastrarAnimalParaCliente(nomeCli, nomeAnimal, tipoAnimal);
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 3:
                    petShop.verTodosClientes();
                    break;
                case 4:
                    petShop.verTodosAnimais();
                    break;
                case 5:
                    System.out.print("Nome do Cliente: ");
                    String nomeCli2 = scanner.nextLine();
                    if (petShop.buscarClientePorNome(nomeCli2) != null) {
                        System.out.print("Descrição da Venda: ");
                        String descricao = scanner.nextLine();
                        double valor = 0;
                        
                        while (true) {
                            System.out.print("Valor da Venda: ");
                            try {
                                valor = scanner.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Por favor, insira um valor numérico válido.");
                                scanner.next();
                            }
                        }
                        
                        scanner.nextLine();
                        petShop.registrarVenda(nomeCli2, descricao, valor);
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 6:
                    petShop.verTodasVendas();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
