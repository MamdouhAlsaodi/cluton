import java.util.Scanner;

public class BAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos dados do usuário
        System.out.print("Informe o sexo (M/F): ");
        char sexo = scanner.next().charAt(0);
        System.out.print("Informe a quantidade de cervejas: ");
        int cervejas = scanner.nextInt();
        System.out.print("Informe a quantidade de refrigerantes: ");
        int refrigerantes = scanner.nextInt();
        System.out.print("Informe a quantidade de espetinhos: ");
        int espetinhos = scanner.nextInt();

        // Cálculo do consumo
        double consumo = (cervejas * 5) + (refrigerantes * 3) + (espetinhos * 7);
        double ingresso = (sexo == 'M' || sexo == 'm') ? 10 : 8;

        // Cálculo do couvert
        double couvert = (consumo > 30) ? 0 : 4;

        // Cálculo do valor total
        double valorTotal = consumo + ingresso + couvert;

        // Exibição do relatório
        System.out.println("\n### RELATÓRIO ###");
        System.out.printf("Consumo: R$ %.2f\n", consumo);
        System.out.printf("Couvert: R$ %.2f\n", couvert);
        System.out.printf("Ingresso: R$ %.2f\n", ingresso);
        System.out.printf("Valor total: R$ %.2f\n", valorTotal);

        scanner.close();
    }
}
