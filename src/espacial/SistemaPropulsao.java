package espacial;

// Classe abstrata que define a base para todos os tipos de propulsão
public abstract class SistemaPropulsao extends ComponenteEspacial {

    protected double potenciaAtual;
    protected double empuxoMaximo;

    public SistemaPropulsao(String id, String nome, double empuxoMaximo) {
        super(id, nome); // chama o construtor de ComponenteEspacial
        this.potenciaAtual = 0;
        this.empuxoMaximo = empuxoMaximo;
    }

    public void ligarMotor() {
        super.ligar(); // reutiliza o método da classe mãe
        System.out.println("Motor pronto para operar.");
    }

    public void desligarMotor() {
        super.desligar(); // reutiliza o método da classe mãe
        this.potenciaAtual = 0;
        System.out.println("Potência zerada.");
    }

    // cada tipo de propulsão implementa esse método do seu jeito
    public abstract void acelerar(double potencia);

    // calcula o empuxo com base na potência atual
    public double calcularEmpuxo() {
        return (potenciaAtual / 100) * empuxoMaximo;
    }

    public double getPotenciaAtual() { return potenciaAtual; }
    public double getEmpuxoMaximo() { return empuxoMaximo; }
}