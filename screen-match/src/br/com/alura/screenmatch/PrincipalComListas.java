package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PrincipalComListas {
    static void main() {
        List<Titulo> list = new ArrayList<>();

        Filme favorito = new Filme("The matrix", 1999);
        favorito.avalia(10);

        Filme outro = new Filme("John Wick", 2014);
        outro.avalia(9);

        Serie serie = new Serie("La Casa de Papel", 2017);

        list.add(favorito);
        list.add(outro);
        list.add(serie);

        for (Titulo item : list) {
            System.out.println("Nome: " + item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        // Ordenando a lista por nome
        Collections.sort(list);
        System.out.println(list);

        // Ordenando a lista por ano
        list.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(list);
    }
}
