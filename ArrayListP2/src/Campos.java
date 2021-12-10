
public class Campos {
    private int cod;
    private double aluguel;
    private String tipo, status, bairro;

    public void calcAjusteAluguel() {
        switch (this.tipo) {
            case "residencial":
                this.setAluguel(this.aluguel * 1.05);
                break;
            case "galpao":
                this.setAluguel(this.aluguel * 1.10);
                break;
            case "comercial":
                this.setAluguel(this.aluguel * 1.15);
                break;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getAluguel() {
        return aluguel;
    }

    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
