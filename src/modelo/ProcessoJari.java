
package modelo;

import java.util.Calendar;
import java.util.Date;


public class ProcessoJari {
     
    private String numero;
    private Date dataInicio;
    private Date dataTermino;
    private String descricao;
    
    private Condutor condutor;

    public ProcessoJari(String numero, Date dataInicio, String descricao, Condutor condutor) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.descricao = descricao;
        this.condutor = condutor;
    }

    public ProcessoJari(String descricao, Condutor condutor) {
        this.descricao = descricao;
        this.condutor = condutor;
        
        Calendar hoje = Calendar.getInstance();
     this.dataInicio = hoje.getTime();
     
     this.numero = "" + System.currentTimeMillis();
     
    }

    public ProcessoJari(String numero, Date dataInicio, Date dataTermino, String descricao, Condutor condutor) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.condutor = condutor;
    }

    public String getNumero() {
        return numero;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    

   
    }


