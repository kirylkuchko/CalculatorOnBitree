package rpn;

import java.util.ArrayList;
import java.util.StringTokenizer;

import stack.MyStack;

public class InfixToPostfix {

    public String postfix;
    public MyStack<String> oper;
    String operatory[] = {"+", "-", "*", "/", "%", "(", "[", "{", ")", "]", "}", "^"};

    public String convert(String infix) {
        postfix = new String();
        String arr[];
        oper = new MyStack<String>();
        arr = infix.split("");
        StringTokenizer sp = new StringTokenizer(infix, "-+*/()[]{}%^", true);
        arr = StringToArray(sp);
        int i = 0;
        while (i < arr.length) {
            if (isOperator(arr[i]) == false) {
                postfix += arr[i];
                postfix += " ";
                i++;
                continue;
            } else {
                proccessOperator(arr[i]);
            }
            i++;
            if (i == 13) {
                System.out.println(" ");
            }
        }
        while (oper.empty() != true) {
            postfix += oper.pop();
            postfix += " ";
        }
        return postfix;
    }

    private void proccessOperator(String actOp) {
        if (oper.empty() == true || (czyNawias(actOp) == 1)) {
            oper.push(actOp);
            return;
        }
        String topOp;
        topOp = oper.peek();
        if (precedence(topOp) < precedence(actOp)) {
            oper.push(actOp);
            return;
        }
        while (precedence(topOp) >= precedence(actOp)) {

            oper.pop();
            postfix += topOp;
            postfix += " ";

            if (oper.empty() == true) {
                oper.push(actOp);
                return;
            }

            topOp = oper.peek();

            if (czyNawias(actOp) == 2) {
                if (czyNawias(topOp) == 1) {
                    oper.pop();
                    return;
                }
            }

            if (czyNawias(topOp) == 1) {
                oper.push(actOp);
                break;
            }
            //////////////////////////////////////

            if (precedence(topOp) < precedence(actOp)) {
                oper.push(actOp);
                return;
            }
        }
    }

    private int precedence(String op) {
        for (int i = 0; i < 2; i++) {
            if (op.equals(operatory[i]) == true)
                return 1;
        }
        for (int i = 2; i < 5; i++) {
            if (op.equals(operatory[i]) == true)
                return 2;
        }
        for (int i = 5; i < 11; i++) {
            if (op.equals(operatory[i]) == true)
                return -1;
        }
        return 3;
    }

    private boolean isOperator(String op) {
        for (int i = 0; i < 12; i++) {
            if (op.equals(operatory[i]) == true)
                return true;
        }
        return false;
    }

    public String[] StringToArray(StringTokenizer st) {
        String[] arr1;
        ArrayList<String> arr = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        arr1 = new String[arr.size()];
        arr1 = arr.toArray(arr1);
        return arr1;
    }

    public int czyNawias(String op) {
        for (int i = 5; i < 8; i++) {
            if (op.equals(operatory[i]) == true)
                return 1;
        }
        for (int i = 8; i < 11; i++)
            if (op.equals(operatory[i]) == true)
                return 2;
        return 0;
    }
}