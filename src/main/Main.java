package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Criando uma lista de pessoas e enderecos
        List<Pessoa> pessoas = new ArrayList<>();
        //Iniciando meu scanner
        Scanner sc = new Scanner(System.in);

        //Criando uma pessoa Nicolas
        //Pessoa nicolas = new Pessoa("Nicolas",22);

        //Adicionei a pessoa criada acima
        //pessoas.add(nicolas);

        //Printando o nome da pessoa
        //System.out.println(        pessoas.get(0).getNome());

        //Jeito alternativo melhor de criar uma pessoa
        //pessoas.add(new Pessoa("Pica-Pau", 22));

        //Aqui eu crio um for para insercao de 3 pessoas, o usuario inserte
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o nome da pessoa:");
            String nome = sc.nextLine();

            System.out.println("Digite a idade da pessoa:");
            int idade = sc.nextInt();

            List<Endereco> enderecos = new ArrayList<>();

            System.out.println("Quantos enderecoes essa pessoa tem?");
            int qtdEndereco = sc.nextInt();
            sc.nextLine();
            for (int j=1;j<=qtdEndereco;j++){
                System.out.println("Digite o nome e o numero do "+ j + " Endereco dessa pessoa");
                String enderecoNome = sc.nextLine();
                int enderecoNumero = sc.nextInt();
                sc.nextLine();
                enderecos.add(new Endereco(enderecoNome,enderecoNumero));

            }
            pessoas.add(new Pessoa(nome,idade,enderecos));
            //enderecos.clear();


            System.out.println(        pessoas.get(i).getNome());
            System.out.println(        pessoas.get(i).getIdade());

            System.out.println("Enderecos:");
            for (Endereco endereco : pessoas.get(i).getEnderecos()) {
                System.out.println("Rua: " + endereco.getRua());
                System.out.println("Numero: " + endereco.getNumero());
                System.out.println();
            }


        }
        //Posso fazer asism tambem:
        //for(Pessoa x: pessoas){
        //  System.out.println(x.getNome() +" " + x.getIdade()+" Anos");
        //}



        //List<String> nomes = new ArrayList<>();
        /* se eu quisesse fazer um generico(nao recomendado)
        List<?>*/

        //Setando nomes
        //nomes.add("Nicolas");
        //nomes.add("Joaozin");
        //nomes.add("Miguelito");




        //Printando os nomes
        //for (int i=0;i<3;i++){
        //System.out.println(nomes);
        //}
        //for (String nome : nomes){
        //System.out.println(nomes);
        //}
        //Scanneando nomes
        //for (String nome : nomes){
        //nome = sc.nextLine();
        //}
        //sc.close();
        //System.out.println(nomes.size());








    }
}