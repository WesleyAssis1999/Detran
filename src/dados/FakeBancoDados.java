package dados;

import ferramentas.Validacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.BoletimOcorrencia;
import modelo.Condutor;
import modelo.Veiculo;

public class FakeBancoDados {

    private static Condutor condutores[] = new Condutor[100];
    private static Veiculo veiculos[] = new Veiculo[100];
    private static BoletimOcorrencia bos[] = new BoletimOcorrencia[100];

    public static Condutor[] getCondutores() {
        return condutores;
    }

    public static Veiculo[] getVeiculos() {
        return veiculos;
    }

    public static BoletimOcorrencia[] getBos() {
        return bos;
    }

    public static void iniciaBaseDados() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        //add alguns condutores para teste
        try {
            condutores[0] = new Condutor("José", "Rua A", "11111111", formatador.parse("10/05/1999"));
            condutores[1] = new Condutor("Maria", "Rua B", "22222222", formatador.parse("10/05/1998"));
            condutores[2] = new Condutor("Diego", "Rua C", "33333333", formatador.parse("10/05/1997"));
            condutores[3] = new Condutor("Ana", "Rua D", "44444444", formatador.parse("10/05/1996"));
            condutores[4] = new Condutor("Marcelo", "Rua D", "55555555", formatador.parse("10/05/1995"));
        } catch (ParseException ex) {
            System.out.println("Problema na inicialização da base de dados, relacionado às datas");

        }

        //add alguns veiculos para teste
        veiculos[0] = new Veiculo("Ford", "Fusion", 2021, 2022, "BRA2E19", "abcdefghijklm123", "preto");
        veiculos[1] = new Veiculo("Chevrolet", "Onix", 2021, 2022, "CON3S21", "nopqrstuvwxyz789", "prata");
        veiculos[2] = new Veiculo("Ford", "Mustang", 2021, 2022, "RIO1J22", "aabbccddeeffg741", "vermelho");
        veiculos[3] = new Veiculo("Honda", "Civic", 2021, 2022, "OLE3T24", "hhiijjkkllmmn543", "cinza");
        veiculos[4] = new Veiculo("Mercedes", " Classe A", 2021, 2022, "GOL2W85", "ooppqqrrssttu123", "branco");
    }

    private static boolean insereUltimaPosicao(Object vet[], Object novo) {
        for (int i = 0; i < condutores.length; i++) {
            if (vet[i] == null) {
                vet[i] = novo;
                return true;
            }
        }
        return false;
    }

    public static boolean insereNovoCondutorBanco(Condutor novo) {
        //Insert into condutor (valores)

        return insereUltimaPosicao(condutores, novo);
    }

    public static boolean insereNovoVeiculoBanco(Veiculo novo) {

        return insereUltimaPosicao(veiculos, novo);

    }

    public static boolean insereNovoBoletim(BoletimOcorrencia novo) {

        return insereUltimaPosicao(bos,novo);
    }

}
