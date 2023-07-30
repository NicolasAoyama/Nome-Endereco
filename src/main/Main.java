package main;

import main.Endereco;
import main.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; ++i) {
            System.out.println("Digite o nome da pessoa:");
            String nome = sc.nextLine();
            System.out.println("Digite a idade da pessoa:");
            int idade = sc.nextInt();
            List<Endereco> enderecos = new ArrayList<>();
            System.out.println("Quantos endereços essa pessoa tem?");
            int qtdEndereco = sc.nextInt();
            sc.nextLine();

            for (int j = 1; j <= qtdEndereco; ++j) {
                System.out.println("Digite o nome e o número do " + j + "º endereço dessa pessoa");
                String enderecoNome = sc.nextLine();
                int enderecoNumero = sc.nextInt();
                sc.nextLine();
                enderecos.add(new Endereco(enderecoNome, enderecoNumero));
            }

            pessoas.add(new Pessoa(nome, idade, enderecos));
        }

        limparTerminal();
        // Exibir lista
        exibirPessoas(pessoas);

        // Pesquisar por nome
        System.out.println("Digite o nome da pessoa para pesquisar:");
        String nomePesquisado = sc.nextLine();
        pesquisarPessoaPorNome(pessoas, nomePesquisado);
    }

    public static void exibirPessoas(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("Endereços:");

            List<Endereco> enderecos = pessoa.getEnderecos();
            for (Endereco endereco : enderecos) {
                System.out.println("Rua: " + endereco.getRua());
                System.out.println("Número: " + endereco.getNumero());
                System.out.println();
            }
        }
    }

    public static void pesquisarPessoaPorNome(List<Pessoa> pessoas, String nomePesquisado) {
        boolean encontrou = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomePesquisado)) {
                encontrou = true;
                System.out.println("Pessoa encontrada:");
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Idade: " + pessoa.getIdade());
                System.out.println("Endereços:");

                List<Endereco> enderecos = pessoa.getEnderecos();
                for (Endereco endereco : enderecos) {
                    System.out.println("Rua: " + endereco.getRua());
                    System.out.println("Número: " + endereco.getNumero());
                    System.out.println();
                }
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Pessoa não encontrada.");
        }
    }

    public static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            if (os.contains("win")) {

                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {

                processBuilder = new ProcessBuilder("sh", "-c", "clear");
            }

            processBuilder.inheritIO().start().waitFor();
        } catch (Exception e) {

        }
    }
}
