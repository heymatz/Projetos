import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListP2 {

    static Scanner leia = new Scanner(System.in);
    static ArrayList<Campos> vet = new ArrayList<>();

    public static void main(String[] args) {

        int resp = 0;

        do {
            System.out.println("Escolha a opção desejada: \n"
                    + "1-Cadastrar um imóvel \n"
                    + "2-Visualizar alugados \n"
                    + "3-Visualizar disponíveis \n"
                    + "4-Realizar locação \n"
                    + "5-Realizar devolução \n"
                    + "6-Sair do programa");
            resp = leia.nextInt();

            switch (resp) {
                case 1:
                    salvar();
                    break;
                case 2:
                    buscaraStatus("alugado");
                    break;
                case 3:
                    buscaraStatus("disponivel");
                    break;
                case 4:
                    alugar();
                    break;
                case 5:
                    devolver();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção desconhecida");
            }

        } while (resp != 6);

        System.out.println("Você saiu do programa.");
    }

    public static void salvar() {

        Campos c = new Campos();

        System.out.println(" CÓDIGO ");
        c.setCod(leia.nextInt());
        System.out.println(" TIPO ");
        c.setTipo(leia.next());
        System.out.println(" ALUGUEL ");
        c.setAluguel(leia.nextDouble());
        System.out.println(" BAIRRO ");
        c.setBairro(leia.next());
        System.out.println(" STATUS ");
        c.setStatus(leia.next());

        // identificando e aplicando acréscimo sobre o tipo
        c.calcAjusteAluguel();

        Boolean existe = false;
        // loop sobre códigos repetidos
        for (Campos e : vet)
            if (c.getCod() == e.getCod()) {
                existe = true;
                System.out.println("ERRO AO SALVAR, CÓDIGO JÁ UTILIZADO.");
                System.out.println("____________________________________");
                break;
            }

        if (!existe) {
            vet.add(c);
        }
    }

    public static void buscaraStatus(String status) {

        System.out.println("IMÓVEIS " + status.toUpperCase());
        for (Campos e : vet)
            if (status.equalsIgnoreCase(e.getStatus())) {
                System.out.println("______________________________________");
                System.out.println("CÓDIGO=" + e.getCod());
                System.out.println("TIPO=" + e.getTipo());
                System.out.println("ALUGUEL=" + e.getAluguel());
                System.out.println("BAIRRO=" + e.getBairro());
                System.out.println("STATUS=" + e.getStatus());
                System.out.println("______________________________________");
            }
    }

    public static void alugar() {

        int codp = 0;

        System.out.println("CÓDIGO DO IMÓVEL A SER ALUGADO");
        codp = leia.nextInt();

        for (Campos e : vet)
            if (codp == e.getCod()) {
                System.out.println("STATUS ATUALIZADO - LOCAÇÃO EFETUADA!");
                e.setStatus("alugado");
            }
    }

    public static void devolver() {

        int codp = 0;
        int i = 0;

        System.out.println("CÓDIGO DO IMÓVEL A SER DEVOLVIDO");
        codp = leia.nextInt();
        for (Campos e : vet)
            if (codp == e.getCod()) {
                System.out.println("STATUS ATUALIZADO - DEVOLUÇÃO EFETUADA!");
                e.setStatus("disponivel");
            }
    }
}
