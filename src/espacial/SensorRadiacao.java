package espacial;

import java.util.Random;

// Sensor responsável por medir a radiação na estação
public class SensorRadiacao implements Sensor {

    private String id;
    private double valorAtual;
    private double limiteAlerta;
    private boolean funcionando;
    private Random random;

    public SensorRadiacao(String id) {
        this.id = id;
        this.limiteAlerta = 50.0; // limite em mSv
        this.funcionando = true;
        this.random = new Random();
    }

    @Override
    public double lerValor() {
        // simula leitura com valor aleatório entre 10 e 90 mSv
        valorAtual = 10 + (random.nextDouble() * 80);
        return valorAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return funcionando;
    }

    @Override
    public String retornarTipo() {
        return "RADIACAO";
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