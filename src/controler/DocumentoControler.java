package controler;

import ferramentas.Validacao;
import modelo.Condutor;
import modelo.Documento;

public class DocumentoControler {

    public Documento emiteDocumento() {
        // String observação, String estado, Condutor dono

        // encontrando o proprietário para emitir o documento em seu nome...
        CondutorControler controlerCondutor = new CondutorControler();
        Condutor proprietario = controlerCondutor.buscaCondutorNome();

        if (proprietario != null) {

            System.out.println("Informe o estado em que o documento será gerado: ");
            String estado = Validacao.entradaTexto();

            System.out.println("Informe possiveis pendências a resp. do veiculo/documento (;para vazio): ");
            String observacao = Validacao.entradaTexto();

            Documento novoDocumento = new Documento(observacao, estado, proprietario);

            return novoDocumento;
        } else {
            return null;
        }
    }
}
