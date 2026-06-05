package espacial;

import java.util.Random;

// Sensor responsável por medir a temperatura da estação
public class SensorTemperatura implements Sensor {

    private String id;
    private double valorAtual;
    private double limiteAlerta;
    private boolean funcionando;
    private Random random;

    public SensorTemperatura(String id) {
        this.id = id;
        this.limiteAlerta = 80.0; // limite em °C
        this.funcionando = true;
        this.random = new Random();
    }

    @Override
    public double lerValor() {
        // simula leitura com valor aleatório entre 20 e 120 °C
        valorAtual = 20 + (random.nextDouble() * 100);
        return valorAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return funcionando;
    }

    @Override
    public String retornarTipo() {
        return "TEMPERATURA";
    }

    @Override
    public void setLimiteAlerta(double limite) {
        this.limiteAlerta = limite;
    }

    @Override
    public boolean verificarAlerta() {
        return valorAtual > limiteAlerta;
    }

    public String getId() { return id; }
}