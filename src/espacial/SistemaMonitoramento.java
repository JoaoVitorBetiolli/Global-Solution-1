package espacial;

import java.util.Scanner;

// Classe principal - menu de controle da estação espacial
public class SistemaMonitoramento {

    static SensorTemperatura sensorTemp = new SensorTemperatura("S001");
    static SensorPressao sensorPressao = new SensorPressao("S002");
    static SensorRadiacao sensorRadiacao = new SensorRadiacao("S003");
    static PropulsaoQuimica propQuimica = new PropulsaoQuimica("P001", "Motor Químico");
    static PropulsaoEletrica propEletrica = new PropulsaoEletrica("P002", "Motor Elétrico");
    static DadosMissao missao = new DadosMissao("Missão Apolo X", "1234");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        missao.setNumerTripulantes(3);
        missao.setTrajetoria("Terra → Marte");

        int opcao = 0;
        while (opcao != 6) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    verificarSensores();
                    break;
                case 2:
                    controlarPropulsao();
                    break;
                case 3:
                    gerenciarMissao();
                    break;
                case 4:
                    simularAlertas();
                    break;
                case 5:
                    exibirStatusCompleto();
                    break;
                case 6:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEMA DE MONITORAMENTO ESPACIAL");
        System.out.println("========================================");
        System.out.println("1. Verificar Sensores");
        System.out.println("2. Controlar Propulsão");
        System.out.println("3. Gerenciar Dados da Missão");
        System.out.println("4. Simular Alertas");
        System.out.println("5. Exibir Status Completo");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // lê os valores dos 3 sensores e verifica alertas
    static void verificarSensores() {
        System.out.println("\n--- LEITURA DOS SENSORES ---");

        double temp = sensorTemp.lerValor();
        System.out.printf("Temperatura: %.2f °C%n", temp);
        System.out.println("Funcionando: " + sensorTemp.verificarFuncionamento());
        if (sensorTemp.verificarAlerta())
            System.out.println("!! ALERTA: Temperatura acima do limite!");

        double pressao = sensorPressao.lerValor();
        System.out.printf("Pressão: %.2f kPa%n", pressao);
        System.out.println("Funcionando: " + sensorPressao.verificarFuncionamento());
        if (sensorPressao.verificarAlerta())
            System.out.println("!! ALERTA: Pressão acima do limite!");

        double radiacao = sensorRadiacao.lerValor();
        System.out.printf("Radiação: %.2f mSv%n", radiacao);
        System.out.println("Funcionando: " + sensorRadiacao.verificarFuncionamento());
        if (sensorRadiacao.verificarAlerta())
            System.out.println("!! ALERTA: Radiação acima do limite!");
    }

    // permite ligar, desligar e acelerar os motores
    static void controlarPropulsao() {
        System.out.println("\n--- CONTROLE DE PROPULSÃO ---");
        System.out.println("1. Propulsão Química");
        System.out.println("2. Propulsão Elétrica");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();

        SistemaPropulsao prop = (tipo == 1) ? propQuimica : propEletrica;

        System.out.println("1. Ligar Motor");
        System.out.println("2. Desligar Motor");
        System.out.println("3. Acelerar");
        System.out.println("4. Diagnóstico");
        System.out.print("Escolha: ");
        int acao = scanner.nextInt();

        switch (acao) {
            case 1:
                prop.ligarMotor();
                break;
            case 2:
                prop.desligarMotor();
                break;
            case 3:
                System.out.print("Digite a potência (0-100): ");
                double potencia = scanner.nextDouble();
                prop.acelerar(potencia);
                break;
            case 4:
                prop.exibirDiagnostico();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // gerencia os dados da missão, incluindo acesso por senha
    static void gerenciarMissao() {
        System.out.println("\n--- DADOS DA MISSÃO ---");
        System.out.println("1. Ver dados gerais");
        System.out.println("2. Ver coordenadas");
        System.out.println("3. Atualizar combustível");
        System.out.println("4. Atualizar trajetória");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                missao.exibirDados();
                break;
            case 2:
                System.out.print("Digite a senha: ");
                String senha = scanner.next();
                System.out.println(missao.getCoordenadas(senha));
                break;
            case 3:
                System.out.print("Novo nível de combustível (0-100): ");
                double nivel = scanner.nextDouble();
                missao.setNivelCombustivel(nivel);
                break;
            case 4:
                scanner.nextLine();
                System.out.print("Nova trajetória: ");
                String traj = scanner.nextLine();
                missao.setTrajetoria(traj);
                System.out.println("Trajetória atualizada!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // simula alertas verificando os níveis de cada sensor
    static void simularAlertas() {
        System.out.println("\n--- SIMULAÇÃO DE ALERTAS ---");

        double temp = sensorTemp.lerValor();
        double pressao = sensorPressao.lerValor();
        double radiacao = sensorRadiacao.lerValor();

        verificarNivelAlerta("Temperatura", temp, 60, 80, 100);
        verificarNivelAlerta("Pressão", pressao, 100, 150, 180);
        verificarNivelAlerta("Radiação", radiacao, 30, 50, 70);

        if (missao.getNivelCombustivel() < 20) {
            System.out.println("[CRÍTICO] Combustível abaixo de 20%!");
        }
    }

    // classifica o valor em OK, ATENÇÃO, ALERTA ou CRÍTICO
    static void verificarNivelAlerta(String sensor, double valor, double atencao, double alerta, double critico) {
        System.out.printf("%s: %.2f%n", sensor, valor);
        if (valor >= critico) {
            System.out.println("  [CRÍTICO] Valor em nível crítico!");
        } else if (valor >= alerta) {
            System.out.println("  [ALERTA] Valor acima do limite!");
        } else if (valor >= atencao) {
            System.out.println("  [ATENÇÃO] Valor em nível de atenção.");
        } else {
            System.out.println("  [OK] Valor normal.");
        }
    }

    // exibe o status de todos os sistemas de uma vez
    static void exibirStatusCompleto() {
        System.out.println("\n========== STATUS COMPLETO ==========");
        missao.exibirDados();
        System.out.println("\n-- Sensores --");
        verificarSensores();
        System.out.println("\n-- Propulsão Química --");
        propQuimica.exibirDiagnostico();
        System.out.println("\n-- Propulsão Elétrica --");
        propEletrica.exibirDiagnostico();
    }
}