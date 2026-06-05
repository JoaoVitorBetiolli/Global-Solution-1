package espacial;

public class DadosMissao {

    private String nomeMissao;
    private double coordenadaX;
    private double coordenadaY;
    private double nivelCombustivel;
    private String trajetoria;
    private int numerTripulantes;
    private String codigoAcesso;

    public DadosMissao(String nomeMissao, String codigoAcesso) {
        this.nomeMissao = nomeMissao;
        this.codigoAcesso = codigoAcesso;
        this.nivelCombustivel = 100.0;
        this.numerTripulantes = 0;
        this.trajetoria = "Não definida";
    }

    // Coordenadas só acessíveis com senha
    public String getCoordenadas(String senha) {
        if (senha.equals(this.codigoAcesso)) {
            return "X: " + coordenadaX + " | Y: " + coordenadaY;
        }
        return "ACESSO NEGADO - Senha incorreta.";
    }

    public void setCoordenadas(String senha, double x, double y) {
        if (senha.equals(this.codigoAcesso)) {
            this.coordenadaX = x;
            this.coordenadaY = y;
            System.out.println("Coordenadas atualizadas com sucesso.");
        } else {
            System.out.println("ACESSO NEGADO - Senha incorreta.");
        }
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivel) {
        if (nivel < 0 || nivel > 100) {
            System.out.println("Valor inválido! O nível deve ser entre 0 e 100.");
            return;
        }
        this.nivelCombustivel = nivel;
        if (nivel < 20) {
            System.out.println("*** ALERTA: Combustível crítico! Apenas " + nivel + "% restante. ***");
        }
    }

    public int getNumerTripulantes() { return numerTripulantes; }

    public void setNumerTripulantes(int n) {
        if (n < 0) {
            System.out.println("Número de tripulantes inválido.");
            return;
        }
        this.numerTripulantes = n;
    }

    public String getTrajetoria() { return trajetoria; }
    public void setTrajetoria(String trajetoria) { this.trajetoria = trajetoria; }
    public String getNomeMissao() { return nomeMissao; }

    public void exibirDados() {
        System.out.println("=== DADOS DA MISSÃO ===");
        System.out.println("Missão: " + nomeMissao);
        System.out.println("Tripulantes: " + numerTripulantes);
        System.out.println("Trajetória: " + trajetoria);
        System.out.println("Combustível: " + nivelCombustivel + "%");
    }
}