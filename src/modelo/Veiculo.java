package modelo;

public class Veiculo {

    private String montadora;
    private String modelo;
    private int anoFab;
    private int anoModelo;
    private String placa;
    private String chassi;
    private String cor;

    //documento do ano corrente (ao ultimo documento gerado)
    private Documento documentoValido;
    private Multa multas[] = new Multa[10];

    public Veiculo(String montadora, String modelo, int anoFab, int anoModelo, String placa, String chassi, String cor, Documento documentoValido, Multa[] multa) {
        this.montadora = montadora;
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.anoModelo = anoModelo;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.documentoValido = documentoValido;
        this.multas = multas;
    }

    public Veiculo(String montadora, String modelo, int anoFab, int anoModelo, String placa, String chassi, String cor) {
        this.montadora = montadora;
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.anoModelo = anoModelo;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
    }

    public Veiculo(String placa) {
        this.placa = placa;
        this.multas = new Multa[10];
    }

    public String getMontadora() {
        return montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFab() {
        return anoFab;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getChassi() {
        return chassi;
    }

    public String getCor() {
        return cor;
    }

    public Documento getDocumentoValido() {
        return documentoValido;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setDocumentoValido(Documento documentoValido) {
        this.documentoValido = documentoValido;
    }

    public Multa multaNumero(int indice) {
        return this.multas[indice];
    }

    public void addMulta(Multa novaMulta) {
        //modificar com o uso de estruturas de armazenamento dinamico   
        for (int i = 0; i < this.multas.length; i++) {
            if (this.multas[i] == null) {
                this.multas[i] = novaMulta;
                break;
            }
        }
    }

    public Multa selecionaMultaOrdem(int indice) {
        if (indice >= this.multas.length) {
            return null;
        }
        return this.multas[indice];
    }

    @Override
    public String toString() {

        String documentoCondutor = "";
        if (this.documentoValido != null) {
            documentoCondutor += this.documentoValido + " \n " + this.documentoValido.getDono();
        }

        String multaString = "Multas: ";
        for (int i = 0; i < this.multas.length; i++) {
            if (this.multas[i] != null) {
                multaString += this.multas[i].getPontuacao() + " | ";
            }
        }
        return "placa: " + this.placa + " | modelo: " + this.modelo + " | montadora: " + this.montadora
                + " | ano fabricação: " + this.anoFab + " | cor: " + this.cor + " \n " + documentoCondutor;
    }

    public void imprimeMultas() {
        for (int i = 0; i < this.multas.length; i++) {
            if (this.multas[i] != null) {
                System.out.println((i + 1) + " - " + this.multas[i]);

            }
        }
    }
}
