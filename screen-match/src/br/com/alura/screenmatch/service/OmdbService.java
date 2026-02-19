package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.exceptions.ApiException;
import br.com.alura.screenmatch.exceptions.TitleNotFoundException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OmdbService {

    private final String BASE_URL = "https://www.omdbapi.com/";
    private final String apiKey;
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

    public OmdbService() {
        apiKey = System.getenv("OMDB_API_KEY");
        if (apiKey == null) {
            throw new IllegalArgumentException("Chave da API inexistente");
        }
    }

    public Titulo buscarPorTitulo(String titulo) throws IOException, InterruptedException {

        String tituloEnconded = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String url = this.BASE_URL + "?t=" + tituloEnconded + "&apikey=" + apiKey;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        validateResponse(response);
        String json = response.body();
        return jsonParaTitulo(json);
    }

    private Titulo jsonParaTitulo(String json) {
        TituloOMDB tituloOMDB = gson.fromJson(json, TituloOMDB.class);
        return new Titulo(tituloOMDB);
    }

    private void validateResponse(HttpResponse<String> response){
        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new ApiException(statusCode, "Falha na chamada OMDb. HTTP " + statusCode);
        }

        JsonObject obj = gson.fromJson(response.body(), JsonObject.class);

        if (obj.has("Response") && "False".equalsIgnoreCase(obj.get("Response").getAsString())) {
            String msg = obj.has("Error") ? obj.get("Error").getAsString() : "Título não encontrado na OMDb";
            throw new TitleNotFoundException(msg);
        }
    }
}
