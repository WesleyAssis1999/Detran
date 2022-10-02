
package controler;

import dados.FakeBancoDados;
import ferramentas.Validacao;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import modelo.Condutor;


public class CondutorControler {
    
    private Scanner teclado;
    private Random gerador;
    
    public CondutorControler(){
        teclado = new Scanner(System.in);
        gerador = new Random();
    }
    public boolean cadastroCondutor(){
        //String nome, String endereco, String contato, Date dataNascimento
        System.out.println("Informe o nome do condutor: ");
        String nome = Validacao.entradaTexto();
        
         System.out.println("Informe o endereco do condutor: ");
        String endereco = Validacao.entradaTexto();
        
         System.out.println("Informe o contato do condutor: ");
        String contato = Validacao.entradaContato();
        
         System.out.println("Informe a data de nascimento do condutor: ");
        Date dataNascimento = Validacao.entradaData();
        
        while(dataNascimento == null){
            System.out.println("formato da data esta incorreto, informe novamente: ");
             dataNascimento = Validacao.entradaData();
        }
        
       Condutor novoCondutor = new Condutor(nome,endereco,contato,dataNascimento);
        
        FakeBancoDados.insereNovoCondutorBanco(novoCondutor);
        return true;
    }

        public Condutor buscaCondutorNome(){
            String nome = Validacao.entradaTexto();
            
            //Verificando cada um dos condutores e avaliando o nome informado pelo usuário
            Condutor condutores[] = FakeBancoDados.getCondutores();
            for (int i = 0; i < condutores.length;i++){ // for(int i = 0; i <condutores.length;i++) {condutores[i].getNome();
                
                //não existem condutores cadastrados a partir desta posição
                if (condutores[i] == null){
                    return null;
                }
                
                //comparando duas strings desconsiderando o fato dos caracteres mais. e minis.
                if (nome.equalsIgnoreCase(condutores[i].getNome())){
                    return condutores[i];
                    
        }
    }
            return null;
        }
        
            public void atualizaInformacaoCondutor(Condutor cond){
                while (cond == null){
                    cond = buscaCondutorNome();
                    if (cond == null){
                        System.out.println("Condutor não encontrado na base, informe novamente...");
                    }
                    
                }
                int op = 0;
                do{
                System.out.println("\n\n\n Informações do condutor na base de dados");
                System.out.println(cond + "\n\n");
                System.out.println("O que voce deseja modificar? (1- nome; 2- endereço; 3- contato; 9- encerrar");
                
                op = teclado.nextInt();
                switch (op){
                    case 1: {
                    System.out.println("Informe o novo nome do Condutor");
                        cond.setNome(Validacao.entradaTexto());
                }
                
                break;
                
                    case 2: {
                     System.out.println("Informe o endereço do Condutor");
                        cond.setEndereco(Validacao.entradaTexto());
                 }
                
                break;
                
                case 3: {
                    System.out.println("Informe o contato do Condutor");
                        cond.setContato(Validacao.entradaContato());
                
                }
                break;
                
                case 9: {
                    System.out.println(" -> Retornando para o menu anterior");
                }
                
                default:{
                System.out.println("***Opção inválida, informe novamente***");
            }
                
       }
    }
        
while (op != 9);
            
   }
}

