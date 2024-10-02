import java.util.Scanner;

public class ImpostoDeRenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da renda anual do usuário
        System.out.print("Informe a renda anual do salário: ");
        double rendaSalario = scanner.nextDouble();
        System.out.print("Informe a renda anual de serviços: ");
        double rendaServicos = scanner.nextDouble();
        System.out.print("Informe a renda anual de ganho de capital: ");
        double rendaCapital = scanner.nextDouble();
        System.out.print("Informe os gastos médicos totais: ");
        double gastosMedicos = scanner.nextDouble();
        System.out.print("Informe os gastos educacionais totais: ");
        double gastosEducacionais = scanner.nextDouble();

        // Cálculo do imposto sobre o salário
        double impostoSalario = 0;
        double salarioMensal = rendaSalario / 12;
        if (salarioMensal >= 3000 && salarioMensal < 5000) {
            impostoSalario = rendaSalario * 0.10;
        } else if (salarioMensal >= 5000) {
            impostoSalario = rendaSalario * 0.20;
        }

        // Cálculo do imposto sobre serviços e ganhos de capital
        double impostoServicos = rendaServicos * 0.15;
        double impostoCapital = rendaCapital * 0.20;

        // Cálculo do imposto total
        double impostoBruto = impostoSalario + impostoServicos + impostoCapital;

        // Cálculo da dedução máxima (30% do imposto)
        double maxDeducao = impostoBruto * 0.30;
        double gastosDedutiveis = Math.min(gastosMedicos + gastosEducacionais, maxDeducao);

        // Cálculo do imposto final
        double impostoDevido = impostoBruto - gastosDedutiveis;

        // Exibição dos resultados
        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f\n", impostoServicos);
        System.out.printf("Imposto sobre ganhos de capital: %.2f\n", impostoCapital);
        System.out.println("Gastos dedutíveis: " + gastosDedutiveis);
        System.out.printf("Imposto devido: %.2f\n", impostoDevido);

        scanner.close();
    }
}
