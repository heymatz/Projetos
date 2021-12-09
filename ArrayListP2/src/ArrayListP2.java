import java.util.Scanner;

public class ArrayListP2 {

    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {

        int resp, i = 0;

        Campos c = new Campos();

        System.out.println("Escolha a opção desejada \n"
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
            System.out.println("Escolha a opção desejada \n 1-Cadastrar um imóvel \n"
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

        int i = 0;
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
        Campos.vet.add(c);
    }

    public static void buscaralugados() {

        int i = 0;
        Campos c = new Campos();
        String alugadop="alugado";

        System.out.println("IMÓVEIS ALUGADOS");
        if (alugadop.equalsIgnoreCase(Campos.vet.get(i).getStatus())) {
            System.out.println("______________________________________");
            System.out.println("CÓDIGO=" + Campos.vet.get(i).getCod());
            System.out.println("TIPO=" + Campos.vet.get(i).getTipo());
            System.out.println("ALUGUEL=" + Campos.vet.get(i).getAluguel());
            System.out.println("BAIRRO=" + Campos.vet.get(i).getBairro());
            System.out.println("STATUS=" + Campos.vet.get(i).getStatus());
            System.out.println("______________________________________");
        }
    }

    public static void buscardisponiveis() {

        int i = 0;
        Campos c = new Campos();
        String disponivelp="disponivel";

        System.out.println("IMÓVEIS DISPONÍVEIS");
        if (disponivelp.equalsIgnoreCase(Campos.vet.get(i).getStatus())) {
            System.out.println("______________________________________");
            System.out.println("CÓDIGO=" + Campos.vet.get(i).getCod());
            System.out.println("TIPO=" + Campos.vet.get(i).getTipo());
            System.out.println("ALUGUEL=" + Campos.vet.get(i).getAluguel());
            System.out.println("BAIRRO=" + Campos.vet.get(i).getBairro());
            System.out.println("STATUS=" + Campos.vet.get(i).getStatus());
            System.out.println("______________________________________");
        }
    }

    public static void alugar() {

        int codp = 0, i = 0;
        Campos c = new Campos();

        System.out.println("CÓDIGO DO IMÓVEL A SER ALUGADO");
        codp = leia.nextInt();
        if (codp == (Campos.vet.get(i).getCod())) {
            System.out.println("STATUS ATUALIZADO - LOCAÇÃO EFETUADA!");
            Campos.vet.get(i).setStatus("alugado");
        }
    }

    public static void devolver() {

        int codp = 0, i = 0;
        Campos c = new Campos();

        System.out.println("CÓDIGO DO IMÓVEL A SER DEVOLVIDO");
        codp = leia.nextInt();
        if (codp == (Campos.vet.get(i).getCod())) {
            System.out.println("STATUS ATUALIZADO - DEVOLUÇÃO EFETUADA!");
            Campos.vet.get(i).setStatus("disponivel");
        }
    }
}
