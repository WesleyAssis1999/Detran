/*
Wesley Elbert Assis
*/


package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class CNH {
    private String numero;
    private Date dataValidade;
    private Date dataEmissao;
    private String estado;
    private String observacao;
    private String tipo;

    public CNH(String numero, Date dataValidade, Date dataEmissao, String estado, String observacao, String tipo) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.dataEmissao = dataEmissao;
        this.estado = estado;
        this.observacao = observacao;
        this.tipo = tipo;
    }
   
    public CNH(String estado,String observacao,String tipo) {
          
        this.estado = estado;
        this.observacao = observacao;
        this.tipo = tipo;
        
        iniciaParametrosSistema();
    }
    private void iniciaParametrosSistema(){
        Random gerador = new Random ();
     this.numero = ""+ System.currentTimeMillis() + "" + (gerador.nextInt(1000000000)+1000000000);
     
     Calendar hoje = Calendar.getInstance();
     this.dataEmissao = hoje.getTime();
     
     hoje.add(Calendar.YEAR,1); //add um ano a partir da data atual
     this.dataValidade = hoje.getTime();
    }

    public String getNumero() {
        return numero;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }          
}
