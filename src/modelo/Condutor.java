/*
Wesley Elbert Assis
*/


package modelo;

import java.util.Date;

public class Condutor {
    
    private String nome;
    private String endereco;
    private String contato;
    private Date dataNascimento;
    private int pontuacao;
    
    private CNH cnh;

    public Condutor(String nome, String endereco, String contato, Date dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.dataNascimento = dataNascimento;
        this.pontuacao = 21;
    }

    public Condutor(String nome, String endereco, String contato, Date dataNascimento, int pontuacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.dataNascimento = dataNascimento;
        this.pontuacao = pontuacao;
    }

    public Condutor(String nome, String endereco, String contato, Date dataNascimento, int pontuacao, CNH cnh) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.dataNascimento = dataNascimento;
        this.pontuacao = pontuacao;
        this.cnh = cnh;
    }


    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public CNH getCnh() {
        return cnh;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

  public boolean decrementaPontuacao(int pontuacaoInfracao){
    if (pontuacaoInfracao >= this.pontuacao){
        cnh = null; //perdeu a cnh
        this.pontuacao = 0;
        return false;
    }
    else {
        this.pontuacao -= pontuacaoInfracao;
        return true;
    }
}
  public void incrementaPontuacao(int pontos){
      this.pontuacao += pontos;
      if (this.pontuacao > 21){
          this.pontuacao = 21;
      }
  }
public void renovaPontos(){
    this.pontuacao = 21;
}
    public void setCnh(CNH cnh) {
        this.cnh = cnh;
    }
    
    @Override
    public String toString(){
        return "nome: " + this.nome + " | contato:" + this.contato + "\n" +
                "endereco: " + this.endereco + " | pontuação: " + this.pontuacao;
    }
    
}
