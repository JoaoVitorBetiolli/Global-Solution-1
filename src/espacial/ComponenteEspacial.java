package espacial;


public abstract class ComponenteEspacial {

    // Atributos comuns a todo componente espacial
    protected String id;
    protected String nome;
    protected boolean status; 
    protected double temperatura;

    // Construtor
    public ComponenteEspacial(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.status = false;
        this.temperatura = 20.0;
    }

    // Método concreto - liga o componente
    public void ligar() {
        this.status = true;
        System.out.println("[" + nome + "] Componente LIGADO.");
    }

    // Método concreto - desliga o componente
    public void desligar() {
        this.status = false;
        System.out.println("[" + nome + "] Componente DESLIGADO.");
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public boolean getStatus() { return status; }
    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    public abstract void exibirDiagnostico();
}