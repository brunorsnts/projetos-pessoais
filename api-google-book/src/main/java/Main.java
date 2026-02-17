import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Locale.setDefault(Locale.US);
        String busca;
        String apiKey = System.getenv("GOOGLE_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("ERRO: GOOGLE_API_KEY não encontrada nas variáveis de ambiente.");
            return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite o nome de um livro: ");
            busca = URLEncoder.encode(sc.nextLine().toLowerCase(), StandardCharsets.UTF_8);
        }

        String uri = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + busca + "&key=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .timeout(Duration.ofSeconds(10))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Erro HTTP: " + response.statusCode());
            System.out.println(response.body());
            return;
        }

        System.out.println(response.body());
    }
}