package ferramentas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validacao {

    public static String entradaTexto() {
        Scanner teclado = new Scanner(System.in);
        String resultado;

        boolean segundaDiante = false;

        do {
            if (segundaDiante) {
                System.out.println(" A informacao não pode ser vazia...");
            }
            resultado = teclado.nextLine();
            segundaDiante = true;
        } while (resultado.isEmpty());

        return resultado;
    }

    public static String entradaContato() {
        String tel = entradaTexto();

        //Pais,area,numero do celular
        while (tel.length() < 8 || tel.length() > 14) {
            System.out.println("A quantidade de digitos esta fora do intervalo, informe novamente");
            tel = entradaTexto();
        }
        return tel;
    }

    public static Date entradaData() {
        String data = entradaTexto();

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date diaDate = formatador.parse(data);
            return diaDate;
        } //Tratamento do problema
        catch (ParseException ex) {
            System.out.println("Erro no formato da data inserida");
            return null;
        }

    }

    public static Double entradaNumeroDouble() {
        Scanner teclado = new Scanner(System.in);

        Double entrada = null;

        try {
            entrada = teclado.nextDouble();
        } catch (Exception ex) {
            System.out.print("entrada incorreta informe novamente: ");
        }
        return entrada;
    }

    public static double entradaNumero() {
        Double numero = entradaNumeroDouble();

        while (numero == null) {
            numero = entradaNumeroDouble();
        }
        return numero;
    }
}
