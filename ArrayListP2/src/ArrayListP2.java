import java.util.Scanner;

public class ArrayListP2 {

    static Scanner leia = new Scanner(System.in);
    public static Campos c = new Campos();

    public static void main(String[] args) {

        int resp, i = 0;

        System.out.println("Escolha a opção desejada: \n"
                + "1-Cadastrar um imóvel \n"
                + "2-Visualizar alugados\n"
                + "3-Visualizar disponíveis \n"
                + "4-Realizar locação \n"
                + "5-Realizar devolução \n"
                + "6-Sair do programa");
        resp = leia.nextInt();

        while (resp >= 1 && resp <= 6) {
            if (resp == 1) {
                salvar();
            }
            if (resp == 2) {
                buscaralugados();
            }
            if (resp == 3) {
                buscardisponiveis();
            }
            if (resp == 4) {
                alugar();
            }
            if (resp == 5) {
                devolver();
            }
            System.out.println("Escolha a opção desejada: \n"
                    + "1-Cadastrar um imóvel \n"
                    + "2-Visualizar alugados \n"
                    + "3-Visualizar disponíveis \n"
                    + "4-Realizar locação \n"
                    + "5-Realizar devolução \n"
                    + "6-Sair do programa");
            resp = leia.nextInt();
        }
        if (resp == 6) {
            System.out.println("Você saiu do programa.");
        }
    }

    public static void salvar() {

        int codrep = c.getCod();

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
        String tipo1 = "residencial";
        String tipo2 = "galpao";
        String tipo3 = "comercial";
        double soma1 = c.getAluguel() + (c.getAluguel() * 5) / 100;
        double soma2 = c.getAluguel() + (c.getAluguel() * 10) / 100;
        double soma3 = c.getAluguel() + (c.getAluguel() * 15) / 100;

        if (tipo1.equalsIgnoreCase(c.getTipo())) {
            c.setAluguel(soma1);
        }
        if (tipo2.equalsIgnoreCase(c.getTipo())) {
            c.setAluguel(soma2);
        }
        if (tipo3.equalsIgnoreCase(c.getTipo())) {
            c.setAluguel(soma3);
        }

        if (c.vet.size() != 0) {
            // loop sobre códigos repetidos
            for (int j = 0; j <= c.vet.size(); ++j) {
                if (codrep == c.vet.get(j).getCod()) {
                    System.out.println("ERRO AO SALVAR, CÓDIGO JÁ UTILIZADO.");
                    System.out.println("____________________________________");
                } else {
                    c.vet.add(c);
                }
            }
        } else {
            c.vet.add(c);
        }
    }

    public static void buscaralugados() {

        int i = 0;
        String alugadop = "alugado";

        System.out.println("IMÓVEIS ALUGADOS");
        if (alugadop.equalsIgnoreCase(c.vet.get(i).getStatus())) {
            System.out.println("______________________________________");
            System.out.println("CÓDIGO=" + c.vet.get(i).getCod());
            System.out.println("TIPO=" + c.vet.get(i).getTipo());
            System.out.println("ALUGUEL=" + c.vet.get(i).getAluguel());
            System.out.println("BAIRRO=" + c.vet.get(i).getBairro());
            System.out.println("STATUS=" + c.vet.get(i).getStatus());
            System.out.println("______________________________________");
        }
    }

    public static void buscardisponiveis() {

        int i = 0;
        String disponivelp = "disponivel";

        System.out.println("IMÓVEIS DISPONÍVEIS");
        if (disponivelp.equalsIgnoreCase(c.vet.get(i).getStatus())) {
            System.out.println("______________________________________");
            System.out.println("CÓDIGO=" + c.vet.get(i).getCod());
            System.out.println("TIPO=" + c.vet.get(i).getTipo());
            System.out.println("ALUGUEL=" + c.vet.get(i).getAluguel());
            System.out.println("BAIRRO=" + c.vet.get(i).getBairro());
            System.out.println("STATUS=" + c.vet.get(i).getStatus());
            System.out.println("______________________________________");
        }
    }

    public static void alugar() {

        int codp = 0;
        int i = 0;

        System.out.println("CÓDIGO DO IMÓVEL A SER ALUGADO");
        codp = leia.nextInt();
        if (codp == (c.vet.get(i).getCod())) {
            System.out.println("STATUS ATUALIZADO - LOCAÇÃO EFETUADA!");
            c.vet.get(i).setStatus("alugado");
        }
    }

    public static void devolver() {

        int codp = 0;
        int i = 0;

        System.out.println("CÓDIGO DO IMÓVEL A SER DEVOLVIDO");
        codp = leia.nextInt();
        if (codp == (c.vet.get(i).getCod())) {
            System.out.println("STATUS ATUALIZADO - DEVOLUÇÃO EFETUADA!");
            c.vet.get(i).setStatus("disponivel");
        }
    }
}
