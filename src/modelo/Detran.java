package modelo;

import controler.BoletimControler;
import controler.CondutorControler;
import controler.VeiculoControler;
import dados.FakeBancoDados;


public class Detran {

   public static void main(String[] args){
      /*  
      CondutorControler condutor_control = new CondutorControler();
      condutor_control.cadastroCondutor();
      condutor_control.buscaCondutorNome();
      condutor_control.atualizaInformacaoCondutor(null);
     */
       
      VeiculoControler veiculo = new VeiculoControler();
      veiculo.cadastraVeiculo();
      FakeBancoDados.insereNovoVeiculoBanco(null);
    veiculo.buscaVeiculoPlaca(null);
    veiculo.emitirDocumento(null);
     veiculo.registrarMulta(null);
      veiculo.imprimeMultas(null);
      veiculo.selecionaMultaVeiculo(null);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       /*
       
        
        
        
       
        
        
        VeiculoControler veiculoControler = new VeiculoControler();        
        veiculoControler.cadastraVeiculo();
        veiculoControler.buscaVeiculoPlaca(placa);
        veiculoControler.emitirDocumento();
        veiculoControler.registrarMulta(veic);
        veiculoControler.imprimeMultas(veic);
        
        
        //cadastrando motoristas para testes futuros
        FakeBancoDados.iniciaBaseDados();
        FakeBancoDados.getCondutores();
        FakeBancoDados.getVeiculos();
        FakeBancoDados.insereNovoVeiculoBanco();
         
        
        */
        
     
     
    }
}
