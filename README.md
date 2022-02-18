# Projeto-Capgemini
Projeto processo seletivo Academia Capgemini

Inicie o sistema a partir da classe
```java
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

# Utilização

O sistema só e capaz de rodar com a versão 11 do java.
O Sistema pode ser testado utilizando o swagger-ui a partir do endereço
[Swagger] http://localhost:8080/swagger-ui/index.html#/

# Questão 01

Na questão 01 criei duas camadas, camada controller e a camada service, na camada controller
através do verbo @GetMapping passando como parâmetro “/Questão01”.
E possível informar no swagger a quantidade para criação da escada, implementei no código também as camadas,
advice é exeption “utilizei fora do pacote questão01 para las reutiliza nas outras duas questões”.
Dessa forma consegui implantar no meu projeto (mensagens) de erro, caso no swagger for informado o número
zero ou números negativos. Implementei também os testes unitários utilizando junit 5.

# Questão 02

Na questão 02 criei 3 três camadas, camada controller, camada service e a camada model na camada controller
através do verbo @GetMapping passando como parâmetro “/Questão02”, e possível informar no swagger o nome e a
senha, fazendo uma simulação de um cadastro de uma rede social, caso a senha não esteja de acordo com os
critérios exigidos, retorna um erro informando o que é necessário na senha para ser uma senha forte,
caso a senha informada passe por todos os critérios exigidos, retorno uma string “Cadastro efetuado com sucesso”,
simulando que a conta foi criada na rede social.Implementeii também os testes unitário utilizando junit 5.

# Questão 03

Na questão 03 criei duas camadas, camada controller e a camada service, na camada controller
através do verbo @GetMapping passando como parâmetro “/Questão03”.
E possível informar no swagger a palavra para fazer os cálculos dos anagramas, desta forma
podendo retorna um inteiro mostrando a quantidade de anagramas pares que a palavra contem,
caso a palavra não contenha anagramas pares, retorna uma mensagem de erro. Implementei os teste
unitários utilizando junit 5.