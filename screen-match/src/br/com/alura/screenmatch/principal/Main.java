package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.service.OmdbService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome de um filme ou série: ");
        String busca = sc.nextLine();

        OmdbService service = new OmdbService();

        System.out.println(service.buscarPorTitulo(busca));

        sc.close();
    }
}
