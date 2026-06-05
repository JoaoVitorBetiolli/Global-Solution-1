package espacial;

import java.util.Random;

// Sensor responsável por medir a pressão da estação
public class SensorPressao implements Sensor {

    private String id;
    private double valorAtual;
    private double limiteAlerta;
    private boolean funcionando;
    private Random random;

    public SensorPressao(String id) {
        this.id = id;
        this.limiteAlerta = 150.0; // limite em kPa
        this.funcionando = true;
        this.random = new Random();
    }

    @Override
    public double lerValor() {
        // simula leitura com valor aleatório entre 50 e 200 kPa
        valorAtual = 50 + (random.nextDouble() * 150);
        return valorAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return funcionando;
    }

    @Override
    public String retornarTipo() {
        return "PRESSAO";
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