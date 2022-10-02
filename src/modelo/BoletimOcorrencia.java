
package modelo;

import java.util.Date;


public class BoletimOcorrencia {
    
    private String descricao;
    private String numero;
    private Date data;
    private String envolvidos[];
    
    private Multa multaDetran;

    public BoletimOcorrencia(String descricao, String numero, Date data, String[] envolvidos, Multa multaDetran) {
        this.descricao = descricao;
        this.numero = numero;
        this.data = data;
        this.envolvidos = envolvidos;
        this.multaDetran = multaDetran;
    }

    public BoletimOcorrencia(String descricao, String numero, Date data, Multa multaDetran) {
        this.descricao = descricao;
        this.numero = numero;
        this.data = data;
        this.multaDetran = multaDetran;
        this.envolvidos = new String[10];
    }

    
    public BoletimOcorrencia(String descricao, Date data) {
        this.descricao = descricao;
        this.data = data;
        this.envolvidos = new String[10];
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public Multa getMultaDetran() {
        return multaDetran;
    }

    public void setMultaDetran(Multa multaDetran) {
        this.multaDetran = multaDetran;
    }

    public String envolvidoNumero(int indice) {
        return this.envolvidos[indice];
    }

    public void addEnvolvido (String nome){
    //modificar com o uso de estruturas de armazenamento dinamico   
    for (int i = 0; i < this.envolvidos.length;i++){
        if (this.envolvidos[i] == null){
            this.envolvidos[i] = nome;
            break;
        }
    }
}
    
}
