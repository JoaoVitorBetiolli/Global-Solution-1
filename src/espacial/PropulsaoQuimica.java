package espacial;

// Propulsão química - usa combustível líquido para gerar empuxo
public class PropulsaoQuimica extends SistemaPropulsao {

    private double nivelCombustivel;
    private String tipoCombustivel;

    public PropulsaoQuimica(String id, String nome) {
        super(id, nome, 500000.0); // empuxo máximo maior que a elétrica
        this.nivelCombustivel = 100.0;
        this.tipoCombustivel = "Hidrogênio Líquido";
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
        nivelCombustivel -= potencia * 0.1; // consome combustível a cada aceleração
        System.out.println("[Propulsão Química] Acelerando com " + potencia + "% de potência.");
        System.out.println("Empuxo gerado: " + calcularEmpuxo() + " N");
        System.out.println("Combustível restante: " + nivelCombustivel + "%");
    }

    @Override
    public void exibirDiagnostico() {
        System.out.println("=== DIAGNÓSTICO - Propulsão Química ===");
        System.out.println("Status: " + (status ? "Ligado" : "Desligado"));
        System.out.println("Potência atual: " + potenciaAtual + "%");
        System.out.println("Combustível: " + tipoCombustivel);
        System.out.println("Nível combustível: " + nivelCombustivel + "%");
        System.out.println("Empuxo máximo: " + empuxoMaximo + " N");
    }

    public double getNivelCombustivel() { return nivelCombustivel; }
    public String getTipoCombustivel() { return tipoCombustivel; }
}