import java.util.ArrayList;
import java.util.List;

public class PetShop {
    private List<Cliente> clientes;
    private List<Venda> vendas;

    public PetShop() {
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public Cliente buscarClientePorNome(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public void cadastrarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(nome, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarAnimalParaCliente(String nomeCliente, String nomeAnimal, String tipoAnimal) {
        Cliente cliente = buscarClientePorNome(nomeCliente);
        if (cliente != null) {
            Animal animal = new Animal(nomeAnimal, tipoAnimal);
            cliente.adicionarAnimal(animal);
            System.out.println("Animal cadastrado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void verTodosClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println("\nNome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("--- Animais ---");
            for (Animal animal : cliente.getAnimais()) {
                System.out.println("Nome: " + animal.getNome());
                System.out.println("Tipo: " + animal.getTipo());
                System.out.println("-");
            }
            System.out.println("------------");
        }
    }

    public void verTodosAnimais() {
        boolean encontrouAnimais = false;
        for (Cliente cliente : clientes) {
            if (!cliente.getAnimais().isEmpty()) {
                encontrouAnimais = true;
                System.out.println("\nAnimais do cliente: " + cliente.getNome());
                for (Animal animal : cliente.getAnimais()) {
                    System.out.println("Nome: " + animal.getNome());
                    System.out.println("Tipo: " + animal.getTipo());
                    System.out.println("-");
                }
            }
        }
        if (!encontrouAnimais) {
            System.out.println("Nenhum animal cadastrado.");
        }
    }

    public void registrarVenda(String nomeCliente, String descricao, double valor) {
        Cliente cliente = buscarClientePorNome(nomeCliente);
        if (cliente != null) {
            Venda venda = new Venda(cliente, descricao, valor);
            vendas.add(venda);
            System.out.println("Venda registrada com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void verTodasVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }
        for (Venda venda : vendas) {
            System.out.println("\nCliente: " + venda.getCliente().getNome());
            System.out.println("Descrição: " + venda.getDescricao());
            System.out.println("Valor: " + "R$" + venda.getValor());
        }
    }
}
