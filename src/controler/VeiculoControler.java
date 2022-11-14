/*
Wesley Elbert Assis
*/

package controler;

import dados.FakeBancoDados;
import ferramentas.Validacao;
import java.util.Scanner;
import modelo.Condutor;
import modelo.Documento;
import modelo.Multa;
import modelo.Veiculo;

public class VeiculoControler {

    public boolean cadastraVeiculo() {

        //String montadora, String modelo, int anoFab, int anoModelo, String placa, String chassi, String cor
        System.out.println("Informe a montadora do Veiculo");
        String montadora = Validacao.entradaTexto();

        System.out.println("Informe o modelo do Veiculo");
        String modelo = Validacao.entradaTexto();

        System.out.println("Informe o ano de fabricação do Veiculo");
        int anoF = (int) Validacao.entradaNumero();

        System.out.println("Informe o ano de lançamento do Veiculo");
        int anoL = (int) Validacao.entradaNumero();

        System.out.println("Informe a placa do Veiculo");
        String placa = entradaPlaca();

        System.out.println("Informe a cor do Veiculo");
        String cor = Validacao.entradaTexto();

        System.out.println("Informe o numero do chassi do Veiculo");
        String chassi = Validacao.entradaTexto();

        Veiculo novoVeiculo = new Veiculo(montadora, modelo, anoF, anoL, placa, chassi, cor);

        return FakeBancoDados.insereNovoVeiculoBanco(novoVeiculo);

    }

    private String entradaPlaca() {

        String placa = Validacao.entradaTexto();

        while (placa.length() != 7) {
            System.out.println("placa informada fora do padrão esperado, informe novamente");
            placa = Validacao.entradaTexto();

        }
        return placa;
    }

    public Veiculo buscaVeiculoPlaca(String placa) {

        if (placa == null) {
            System.out.print("Informe a placa do veiculo para realizar a busca");
            placa = Validacao.entradaTexto();
        }
        Veiculo todosVeiculos[] = FakeBancoDados.getVeiculos();

        for (int i = 0; i < todosVeiculos.length; i++) {
            if (todosVeiculos[i] != null) {
                if (todosVeiculos[i].getPlaca().equalsIgnoreCase(placa)) {
                    return todosVeiculos[i];
                }
            } else {
                return null;
            }
        }
        return null;
    }

    public Veiculo emitirDocumento(Veiculo veic) {

        while (veic == null) {
            veic = buscaVeiculoPlaca(null);
        }

        //encontramos o veiculo 
        DocumentoControler controlDocumento = new DocumentoControler();

        Documento novoDocumento = controlDocumento.emiteDocumento();

        veic.setDocumentoValido(novoDocumento);

        return veic;
    }

    public void registrarMulta(Veiculo veic) {
        // caso o veiculo não seja passado como par. buscamos o veiculo

        while (veic == null) {
            veic = buscaVeiculoPlaca(null);

        }
        //Verificando se o veiculo possui documento emitido
        if (veic.getDocumentoValido() != null) {
            //Vamos emitir a multa para o proprietário do veiculo
            Condutor proprietario = veic.getDocumentoValido().getDono();

            MultaControler multaControl = new MultaControler();
            Multa multaNova = multaControl.emiteNovaMulta(proprietario);

            //ded. a pontuação do proprietário do veiculo
            proprietario.decrementaPontuacao(multaNova.getPontuacao());

            // add a multa ao veiculo
            veic.addMulta(multaNova);

        } else {
            System.out.println(" ATENÇÂO -> Imossivel gerar uma multa para um veiculo sem documentação (irregular) ");
        }
    }

    public void imprimeMultas(Veiculo veic) {
        //se o veiculo não foi passado iremos busca-lo
        while (veic == null) {
            veic = buscaVeiculoPlaca(null);
        }
        veic.imprimeMultas();
    }

    public Multa selecionaMultaVeiculo(Veiculo veic) {

        //buscando o veiculo em caso de null
        while (veic == null) {
            veic = buscaVeiculoPlaca(null);
        }
        veic.imprimeMultas();

        Scanner teclado = new Scanner(System.in);
        int indice = (int)Validacao.entradaNumero();
        
        while(indice > 0){
            System.out.print ("Informe um indice válido: ");
            indice = (int) Validacao.entradaNumero();
        }
        
        // a primeira mult esta no indice 0 e não 1
        indice --;
        
        Multa multaSelecionada = veic.selecionaMultaOrdem(indice);
        return multaSelecionada;
    }
}

