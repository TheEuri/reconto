package br.edu.cesarschool.cc.projetos3.utils;

public class ValidadorCNPJ {
    
    public static boolean isCnpjValido(String cnpj) {
       
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14)
            return false;

        int soma = 0;
        int peso = 5;
        for (int i = 0; i < 12; i++) {
            soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * peso;
            peso--;
            if (peso < 2)
                peso = 9;
        }
        int digito1 = soma % 11;
        digito1 = (digito1 < 2) ? 0 : (11 - digito1);

        soma = 0;
        peso = 6;
        for (int i = 0; i < 13; i++) {
            soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * peso;
            peso--;
            if (peso < 2)
                peso = 9;
        }
        int digito2 = soma % 11;
        digito2 = (digito2 < 2) ? 0 : (11 - digito2);

        return Integer.parseInt(String.valueOf(cnpj.charAt(12))) == digito1 &&
               Integer.parseInt(String.valueOf(cnpj.charAt(13))) == digito2;
    }
}
