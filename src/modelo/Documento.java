/*
Wesley Elbert Assis
*/


package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class Documento {
    
    private String numero;
    private Date dataEmissao;
    private int anoCorrente;
    private String observacao;
    private String estado;
    
    private Condutor dono;

    public Documento(String numero, Date dataEmissao, int anoCorrente, String observacao, String estado, Condutor dono) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.anoCorrente = anoCorrente;
        this.observacao = observacao;
        this.estado = estado;
        this.dono = dono;
    }
//Construtor onde estamos incializando a primeira
    public Documento(String observacao, String estado, Condutor dono) {
        this.observacao = observacao;
        this.estado = estado;
        this.dono = dono;
    
             iniciaAtributosSistema();
    
}
   private void iniciaAtributosSistema(){
       Random gerador = new Random();
       this.numero = "" + (System.currentTimeMillis()/100) + gerador.nextInt(500000)+100000;
       
       Calendar hoje = Calendar.getInstance();
       this.dataEmissao = hoje.getTime();
       this.anoCorrente = hoje.get(Calendar.YEAR);
   }    

    public String getNumero() {
        return numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public int getAnoCorrente() {
        return anoCorrente;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getEstado() {
        return estado;
    }

    public Condutor getDono() {
        return dono;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setDono(Condutor dono) {
        this.dono = dono;
    }
    public String toString(){
        return "numero doc: " + this.numero + " | estado: " + this.estado + " | ano corrente: " + this.anoCorrente;
    }
}
