import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculadoraSalarial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valorSalario = 0;
        double valorBeneficios = 0;

        try {
            System.out.println("Informe o valor do salário: ");
            valorSalario = scanner.nextDouble();
            System.out.println("Informe o valor dos beneficios: ");
            valorBeneficios = scanner.nextDouble();

            //chama o metodo contendo a lógica do cálculo salárial
            double valorImposto = calcularImposto(valorSalario);
            double valorFinal = (valorSalario - valorImposto) + valorBeneficios;
            System.out.println(String.format("Salário a ser transferido - R$ %.2f", valorFinal));
        }
        catch (InputMismatchException e) {
            System.out.println("Os valores informados precisam ser decimais!");
        }
    }

    static double calcularImposto (double valorSalario) {
        double valorImposto = 0;
        if(valorSalario >= 0 && valorSalario <=1100) {
            //Atribuindo a aliquota de 5% mediante o salário
            valorImposto = 0.05F * valorSalario;
        } else if (valorSalario >= 1100.01 && valorSalario <= 2500) {
            valorImposto = 0.10F * valorSalario;
        } else if (valorSalario > 2500) {
            valorImposto = 0.15F * valorSalario;
        }
        return valorImposto;
    }
}
