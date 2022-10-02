package controler;

import dados.FakeBancoDados;
import ferramentas.Validacao;
import java.util.Date;
import modelo.BoletimOcorrencia;
import modelo.Multa;

public class BoletimControler {

    public BoletimOcorrencia registraBoletim(Multa multaSelecionada) {
        VeiculoControler veicControler = new VeiculoControler();
        
        while (multaSelecionada == null) {

            multaSelecionada = veicControler.selecionaMultaVeiculo(null);
        }

        //String descricao, String numero, Date data, Multa multaDetran
        System.out.println("Informe a descrição do ocorrido: ");
        String descricao = Validacao.entradaTexto();

        System.out.println("Informe o número do boletim: ");
        String numero = Validacao.entradaTexto();

        System.out.println("Informe a data do ocorrido: ");
        Date dia = Validacao.entradaData();

        BoletimOcorrencia novoBoletim = new BoletimOcorrencia(descricao, numero, dia, multaSelecionada);
        FakeBancoDados.insereNovoBoletim(novoBoletim);
        return novoBoletim;
    }
}
