package controler;

import ferramentas.Validacao;
import modelo.Condutor;
import modelo.Multa;
import modelo.ProcessoJari;

public class MultaControler {

    //String descricao, String local, Condutor primeiroCondutor
    public Multa emiteNovaMulta(Condutor proprietario) {

        if (proprietario != null) {

            System.out.println("Informe uma descrição da multa: ");
            String descricao = Validacao.entradaTexto();

            System.out.println("Informe o local da multa: ");
            String local = Validacao.entradaTexto();

            Multa novaMulta = new Multa(descricao, local, proprietario);
            return novaMulta;
        } else {
            System.out.println("ATENÇÃO ->  É preciso informar um proprietário válido para emissao da multa");
            return null;
        }
    }
    public boolean registraProcessoJari (Multa multaSelecionada, Condutor segundoResponsabilizado){
        
        VeiculoControler controlVeic = new VeiculoControler();
        CondutorControler controlCondutor = new CondutorControler();
        
        //procurando a multa para iniciar o processo
        while(multaSelecionada == null){
            multaSelecionada = controlVeic.selecionaMultaVeiculo(null);
        }
        //procurando o condutor que receberá a culpa
        while(segundoResponsabilizado == null){
            segundoResponsabilizado = controlCondutor.buscaCondutorNome();
        }
        
        System.out.print("Informe a descrição do eventos relacionados ao processo");
        String descricao = Validacao.entradaTexto();
        
        ProcessoJari novoProcesso = new ProcessoJari (descricao,segundoResponsabilizado);
        
        //restaurar a pontuação do condutor proprietário
        multaSelecionada.getPrimeiroCondutor().incrementaPontuacao(multaSelecionada.getPontuacao());
        
        //registra o processo e penaliza o segundo condutor
        multaSelecionada.setSegundoCondutor(novoProcesso);
        return true;
    }
}
