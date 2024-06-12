package br.edu.cesarschool.cc.projetos3.utils;

public class ValidadorCEP {
    private ValidadorCEP() {

    }

    public static boolean isCepValido(String cep) {
        return !StringUtils.isVaziaOuNula(cep) && isFormatoValido(cep);
    }

    private static boolean isFormatoValido(String cep) {
        if (cep.length() != 8 && cep.length() != 9) return false;
        
        for (char c : cep.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        if (cep.length() == 9 && cep.charAt(5) != '-') return false;

        return true;
    }
}
