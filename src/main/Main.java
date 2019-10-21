package main;

import rpn.InfixToPostfix;
import biTree.BNP;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        tworzenie("((4+3)-(2+1)*2+3)/2");
        tworzenie("(8+2*5)/(1+3*2-4)");
        tworzenie("2+3*2+6");
        tworzenie("(1+2)*3");
        tworzenie("(1+2)*4+3");
        tworzenie("((2+3)*2+2)%5");
        tworzenie("((10+2)*(2+3))/10");

    }

    public static void tworzenie(String str) {
        System.out.println("*********************************");
        System.out.print("Wprowadzone wyrazenie: " + str);
        BNP newBNP;
        InfixToPostfix inf = new InfixToPostfix();
        str = inf.convert(str);

        newBNP = TworzenieDrzewa(str);
        newBNP.PostOrder();
        newBNP.InOrder();
        newBNP.ObliczaniePostOrder();
        newBNP.iloscLisc();
        newBNP.iloscWezlow();
        newBNP.heightTree();
        newBNP.kolejka();

        System.out.println("*********************************\n");
    }

    public static BNP TworzenieDrzewa(String st) {
        BNP newBNP = new BNP();
        String str[] = st.split(" ");
        for (int i = str.length - 1; i >= 0; i--) {
            newBNP.dodacWezel(str[i]);
        }
        return newBNP;
    }
}
