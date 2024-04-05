package agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//fazer implementacao da busca

public class main {
    public static void main(String[] args) {
        String telefone;
        String nome;

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.println("Digite seu telefone: ");
        telefone = sc.nextLine();
        sc.close();

        try {
            FileWriter escrita = new FileWriter("/home/alun22204708360017/Downloads/ATV_AGENDA/agenda.txt", true);
            BufferedWriter bwEscrita = new BufferedWriter(escrita);
            bwEscrita.write( nome + ";" + telefone);
            bwEscrita.newLine();
            bwEscrita.close();
            escrita.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader leitura = new FileReader("/home/alun22204708360017/Downloads/ATV_AGENDA/agenda.txt");
            BufferedReader brLeitura = new BufferedReader(leitura);
            while (brLeitura.ready()) {
                String str = brLeitura.readLine();
                //System.out.println(str);
                
                String[]vetor=str.split(";");
                if(vetor[0].equals(nome)) {
                	System.out.println("Nome: " +vetor[0] + "Telefone" + vetor[1]);
                }
                
                
            }
            
            brLeitura.close();
            leitura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



