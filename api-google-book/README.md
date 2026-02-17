# 📚 Google Books API - Java Console Application

Projeto desenvolvido para prática de consumo de API REST utilizando **Java 11+ HttpClient**, com foco em:

- Entendimento de HTTP
- Requisições GET
- Tratamento de resposta
- Uso seguro de variáveis de ambiente
- Boas práticas básicas de backend

---

## 🚀 Sobre o Projeto

Essa aplicação permite que o usuário digite o nome de um livro no terminal e consulta a **Google Books API**, retornando os dados da busca em formato JSON.

O principal objetivo do projeto foi praticar:

- Comunicação HTTP na prática
- Construção dinâmica de URI
- Encoding de parâmetros
- Tratamento de erros HTTP
- Uso de variável de ambiente para proteger API Key

---

## 🛠 Tecnologias Utilizadas

- Java 11+
- `java.net.http.HttpClient`
- Google Books API
- Variáveis de Ambiente (para segurança da API Key)

---

## 🔐 Segurança

A chave da API **não está hardcoded no projeto**.

Ela é carregada via variável de ambiente:

GOOGLE_API_KEY

Exemplo no Windows:

setx GOOGLE_API_KEY "SUA_CHAVE_AQUI"

Isso evita exposição de credenciais no GitHub.

---

## 📌 Como Executar

1. Clone o repositório:

   * git clone https://github.com/brunorsnts/NOME_DO_REPOSITORIO.git

2. Configure sua variável de ambiente com sua API Key do Google Books.

3. Execute a classe `Main`.

4. Digite o nome do livro desejado no terminal.

---

## 📖 Exemplo de Uso

Digite o nome de um livro: clean code

A aplicação retorna o JSON com os dados encontrados na API.

---

## 🎯 Objetivo de Aprendizado

Esse projeto faz parte do meu processo de evolução em backend Java, onde estou estudando:

- HTTP na prática
- Consumo de APIs externas
- Boas práticas de segurança
- Organização de código

Próximos passos planejados:

- Separar responsabilidades em camadas
- Criar uma classe Service
- Parsear JSON para objetos Java
- Evoluir para versão Spring Boot

---

## 👨‍💻 Autor

Bruno Rodrigues

LinkedIn:
https://www.linkedin.com/in/bruno-rodrigues-517368206/

GitHub:
https://github.com/brunorsnts

---

⭐ Se você é recrutador ou dev e quiser trocar uma ideia sobre backend Java, fico à disposição!
