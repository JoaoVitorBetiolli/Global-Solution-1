package espacial;


public interface Sensor {

    // Lê e retorna o valor atual medido pelo sensor
    double lerValor();

    // Verifica se o sensor está funcionando corretamente
    boolean verificarFuncionamento();

    // Retorna o tipo do sensor (ex: "TEMPERATURA", "PRESSAO")
    String retornarTipo();

    // Define o limite máximo antes de gerar alerta
    void setLimiteAlerta(double limite);

    // Verifica se o valor atual passou do limite
    boolean verificarAlerta();
}