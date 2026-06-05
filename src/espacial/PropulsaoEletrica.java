package espacial;

// Propulsão elétrica - usa bateria como fonte de energia
public class PropulsaoEletrica extends SistemaPropulsao {

    private double cargaBateria;
    private double eficiencia;

    public PropulsaoEletrica(String id, String nome) {
        super(id, nome, 50000.0);
        this.cargaBateria = 100.0;
        this.eficiencia = 0.95; // 95% de eficiência energética
    }

    @Override
    public void acelerar(double potencia) {
        if (potencia < 0 || potencia > 100) {
            System.out.println("Potência inválida! Use um valor entre 0 e 100.");
            return;
        }
        if (!status) {
            System.out.println("Ligue o motor antes de acelerar!");
            return;
        }
        this.potenciaAtual = potencia;
        cargaBateria -= potencia * 0.05; // consome menos que a química
        System.out.println("[Propulsão Elétrica] Acelerando com " + potencia + "% de potência.");
        System.out.println("Empuxo gerado: " + (calcularEmpuxo() * eficiencia) + " N");
        System.out.println("Carga da bateria: " + cargaBateria + "%");
    }

    @Override
    public void exibirDiagnostico() {
        System.out.println("=== DIAGNÓSTICO - Propulsão Elétrica ===");
        System.out.println("Status: " + (status ? "Ligado" : "Desligado"));
        System.out.println("Potência atual: " + potenciaAtual + "%");
        System.out.println("Eficiência: " + (eficiencia * 100) + "%");
        System.out.println("Carga da bateria: " + cargaBateria + "%");
        System.out.println("Empuxo máximo: " + empuxoMaximo + " N");
    }

    public double getCargaBateria() { return cargaBateria; }
    public double getEficiencia() { return eficiencia; }
}