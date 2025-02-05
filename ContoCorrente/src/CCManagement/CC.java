package CCManagement;

public class CC {
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------ATTRIBUTI---------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private String nomeCorrentista;
    private double saldo;

    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------METODI----------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORI
    public CC (String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
        saldo = 0;
    }

    //GET & SET
    public String getNomeCorrentista () {
        return nomeCorrentista;
    }

    public void setNomeCorrentista (String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public double getSaldo () {
        return saldo;
    }

    public void setSaldo (double saldo) {
        this.saldo = saldo;
    }

    //PRELEVA
    public void preleva (double amount) throws CifraNegativaException, SaldoInsufficienteException {
        if (amount < 0) {
            throw new CifraNegativaException("Impossibile prelevare una cifra negativa");
        }
        if (amount > saldo) {
            throw new SaldoInsufficienteException("Saldo insufficiente per il prelievo");
        }
        saldo -= amount;
    }

    //DEPOSITA
    public void deposita (double amount) throws CifraNegativaException {
        if (amount < 0) {
            throw new CifraNegativaException("Impossibile depositare una cifra negativa");
        }
        saldo += amount;
    }

    @Override
    public String toString() {
        return "CC{" +
                "nomeCorrentista='" + nomeCorrentista + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
