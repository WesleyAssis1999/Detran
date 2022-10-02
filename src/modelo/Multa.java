
package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class Multa {
    
    private String descricao;
    private double valor;
    private Date dia;
    private boolean pago;
    private int pontuacao;
    private String local;
    
    private Condutor primeiroCondutor;
    private ProcessoJari segundoCondutor;

    public Multa(String descricao, double valor, Date dia, boolean pago, int pontuacao, String local, Condutor primeiroCondutor, ProcessoJari segundoCondutor) {
        this.descricao = descricao;
        this.valor = valor;
        this.dia = dia;
        this.pago = pago;
        this.pontuacao = pontuacao;
        this.local = local;
        this.primeiroCondutor = primeiroCondutor;
        this.segundoCondutor = segundoCondutor;
    }

    public Multa(String descricao, String local, Condutor primeiroCondutor) {
        this.descricao = descricao;
        this.local = local;
        this.primeiroCondutor = primeiroCondutor;
        this.pago = false;
    
     Calendar hoje = Calendar.getInstance();
     this.dia = hoje.getTime();
        
     iniciaAtravesDescricao();
    
}
   private void iniciaAtravesDescricao(){
      switch(this.descricao){
          
          case "velocidade":{
              this.valor = 1700;
              this.pontuacao = 7;
          }
           break;
          case "semaforo":{
              this.valor = 1054;
              this.pontuacao = 5;
          }
          break;
          case "colisao":{
               this.valor = 1200;
              this.pontuacao = 4;
          }
           break;
          case "estacionar":{
               this.valor = 450;
              this.pontuacao = 3;
          }
           break;
          default:{
              this.valor = 950;
              this.pontuacao = 4;
          }
       }                 
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Date getDia() {
        return dia;
    }

    public boolean isPago() {
        return pago;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getLocal() {
        return local;
    }

    public Condutor getPrimeiroCondutor() {
        return primeiroCondutor;
    }

    public ProcessoJari getSegundoCondutor() {
        return segundoCondutor;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    //processo Jari occoreu,segundo condutor deve ser responsabilizado
    public void setSegundoCondutor(ProcessoJari segundoCondutor) {
        this.segundoCondutor = segundoCondutor;
        this.segundoCondutor.getCondutor().decrementaPontuacao(this.pontuacao);
    }
   
    public String toString (){
        return "Descr: " + this.descricao + " | local: " + this.local + 
                " | pontuação: " + this.pontuacao + " | pago: " + this.pago ;
    }
   
}
