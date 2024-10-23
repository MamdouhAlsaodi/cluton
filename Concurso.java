import java.util.Scanner;

public class Concurso {
    
    static class Participante {
        String nome;
        double notaEtapa1;
        double notaEtapa2;
        double media;

        public Participante(String nome, double notaEtapa1, double notaEtapa2) {
            this.nome = nome;
            this.notaEtapa1 = notaEtapa1;
            this.notaEtapa2 = notaEtapa2;
            this.media = (notaEtapa1 + notaEtapa2) / 2.0;
        }

        public boolean aprovado() {
            return this.media >= 70.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Ler a quantidade de participantes
        System.out.print("Qual a quantidade de pessoas? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Participante[] participantes = new Participante[n];

        // 2. Ler os dados dos participantes
        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Nota etapa 1: ");
            double notaEtapa1 = scanner.nextDouble();
            System.out.print("Nota etapa 2: ");
            double notaEtapa2 = scanner.nextDouble();
            scanner.nextLine(); // Consumir nova linha

            participantes[i] = new Participante(nome, notaEtapa1, notaEtapa2);
        }

        // 3. Mostrar a tabela de participantes e calcular resultados
        System.out.println("\n### TABELA ###");
        int totalAprovados = 0;
        double somaMediaAprovados = 0.0;
        Participante maiorMedia = participantes[0];

        for (Participante p : participantes) {
            System.out.printf("%s, %.1f, %.1f, MEDIA = %.2f\n", p.nome, p.notaEtapa1, p.notaEtapa2, p.media);
            if (p.aprovado()) {
                totalAprovados++;
                somaMediaAprovados += p.media;
            }
            if (p.media > maiorMedia.media) {
                maiorMedia = p;
            }
        }

        // 4. Mostrar nomes dos aprovados
        System.out.println("\n### PESSOAS APROVADAS ###");
        for (Participante p : participantes) {
            if (p.aprovado()) {
                System.out.println(p.nome);
            }
        }

        // 5. Calcular e mostrar a porcentagem de aprovação
        double porcentagemAprovacao = ((double) totalAprovados / n) * 100.0;
        System.out.printf("Porcentagem de aprovação: %.1f %%\n", porcentagemAprovacao);

        // 6. Mostrar o nome da pessoa com maior média
        System.out.println("Maior média: " + maiorMedia.nome);

        // 7. Calcular e mostrar a média dos aprovados, ou mensagem se não houver
        if (totalAprovados > 0) {
            double mediaAprovados = somaMediaAprovados / totalAprovados;
            System.out.printf("Nota média dos aprovados: %.2f\n", mediaAprovados);
        } else {
            System.out.println("Não há candidatos aprovados");
        }

        scanner.close();
    }
}
