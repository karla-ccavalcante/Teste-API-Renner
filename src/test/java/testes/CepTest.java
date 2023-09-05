package testes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CepTest {
    Response response;

    @BeforeAll
    public static void inicializaTeste() {
        RestAssured.baseURI = "https://viacep.com.br/ws/";
    }

    @Test
    @DisplayName("Validar CEP Valido")
    public void validarCepValido() {
        String cep = "13335520";
        getCep(cep);
        assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertEquals("13335-520", response.jsonPath().get("cep")),
                () -> assertEquals("Rua Tupinambas", response.jsonPath().get("logradouro")),
                () -> assertEquals("", response.jsonPath().get("complemento")),
                () -> assertEquals("Aqui se Vive", response.jsonPath().get("bairro")),
                () -> assertEquals("Indaiatuba", response.jsonPath().get("localidade")),
                () -> assertEquals("SP", response.jsonPath().get("uf")),
                () -> assertEquals("19", response.jsonPath().get("ddd")),
                () -> assertEquals("6511", response.jsonPath().get("siafi"))
        );
    }

    @Test
    @DisplayName("Validar CEP Invalido")
    public void validarCepInvalido(){
        String cep = "133355200";
        getCep(cep);
        assertEquals(400, response.statusCode());
    }



    private void getCep(String cep) {
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .when()
                .get(cep + "/json")
                .thenReturn();
    }


}
