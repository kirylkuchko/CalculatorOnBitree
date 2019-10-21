package biTree;

import java.util.LinkedList;
import java.util.Stack;
import stack.*;

public class BNP {
    Node root = null;

    public BNP() {
    };

    public boolean pusteBNP() {
        if (root == null) {
            return true;
        }
        return false;
    }

    public void dodacWezel(String st) {
        Node newWezel = new Node(st);
        if (pusteBNP() == true) {
            root = newWezel;
            return;
        }
        Node actWezel = root;
        int flag = 0;
        while (flag == 0) {
            if (actWezel.getRight() == null) {
                actWezel.setRight(newWezel);
                newWezel.setParent(actWezel);
                return;
            }
            if (czyOperator(actWezel.getRight().getKey()) == true) {
                actWezel = actWezel.getRight();
                continue;
            } else {
                if (actWezel.getLeft() == null) {
                    actWezel.setLeft(newWezel);
                    newWezel.setParent(actWezel);
                    return;
                }
                if (czyOperator(actWezel.getLeft().getKey()) == true) {
                    actWezel = actWezel.getLeft();
                    continue;
                } else {

                    while (actWezel.getLeft() != null) {
                        if (actWezel.getParent() != null && actWezel == actWezel.getParent().getLeft()) {
                            if (czyOperator(actWezel.getLeft().getKey()) == true) {
                                actWezel = actWezel.getLeft();
                                break;
                            }
                            actWezel = actWezel.getParent();
                        } else {
                            actWezel = actWezel.getParent();
                            if (actWezel.getLeft() == null)
                                break;
                            if (czyOperator(actWezel.getLeft().getKey()) == true)
                                break;
                            actWezel = actWezel.getParent();
                        }
                    }

                    if (actWezel.getLeft() == null) {
                        actWezel.setLeft(newWezel);
                        newWezel.setParent(actWezel);
                        return;
                    } else
                        actWezel = actWezel.getLeft();
                }
            }

        }
    }

    public void PostOrder() {
        System.out.print("PostOrder: ");
        PostOrder(root);
        System.out.println();

    }

    public void PostOrder(Node wz) {
        if (wz == null)
            return;
        PostOrder(wz.getLeft());
        PostOrder(wz.getRight());
        System.out.print(wz.getKey() + " ");

    }

    public void InOrder() {
        System.out.print("InOrder: ");
        InOrder(root);
        System.out.println();
    }

    public void InOrder(Node wz) {

        if (wz == null || wz == null)
            return;
        System.out.print("(");
        InOrder(wz.getLeft());
        System.out.print(wz.getKey());
        InOrder(wz.getRight());
        System.out.print(")");
    }

    public void ObliczaniePostOrder() {
        Stack<String> myStack = new Stack<String>();
        ObliczaniePostOrder(root, myStack);
        System.out.println("Wynik = " + myStack.pop());

    }

    public void heightTree() {
        System.out.println("Wysokosc Drzewa: " + heightTree(root));
    }

    public int heightTree(Node wz) {
        if (wz == null || root == null)
            return -1;
        else
            return 1 + Math.max(heightTree(wz.getLeft()), heightTree(wz.getRight()));

    }

    public void iloscLisc() {
        System.out.println("ILosc lisc w drzewe: " + iloscLisc(root));

    }

    public int iloscLisc(Node wz) {

        if (root == null || wz == null)
            return 0;
        if (wz.getLeft() == null && wz.getRight() == null)
            return 1;
        else
            return iloscLisc(wz.getLeft()) + iloscLisc(wz.getRight());
    }

    public void iloscWezlow() {
        System.out.println("Ilosc wezlow: " + iloscWezlow(root));
    }

    public int iloscWezlow(Node wz) {

        if (root == null || wz == null)
            return 0;
        return 1 + iloscWezlow(wz.getLeft()) + iloscWezlow(wz.getRight());

    }

    public void ObliczaniePostOrder(Node wz, Stack<String> myStack) {
        if (wz == null)
            return;
        ObliczaniePostOrder(wz.getLeft(), myStack);
        ObliczaniePostOrder(wz.getRight(), myStack);
        if (czyOperator(wz.getKey()) == false)
            myStack.push(wz.getKey());
        else {
            wyliczanie(myStack, wz.getKey());
        }

    }

    public void wyliczanie(Stack<String> myStack, String str) {
        double sum = 0;
        double i, j;
        i = Double.parseDouble(myStack.pop());
        j = Double.parseDouble(myStack.pop());
        switch (str) {
            case ("+"):
                sum = i + j;
                break;
            case ("-"):
                sum = j - i;
                break;
            case ("%"):
                sum = j % i;
                break;
            case ("/"): {
                sum = j / i;
                if (i == 0) {
                    throw new IllegalArgumentException("Division by 0");
                }
            }
            break;
            case ("*"):
                sum = i * j;
                break;
        }
        myStack.push(Double.toString(sum));
    }

    public boolean czyOperator(String st) {
        String operatory[] = { "+", "-", "*", "/", "%" };
        for (int i = 0; i < operatory.length; i++)
            if (st.equals(operatory[i]) == true)
                return true;
        return false;
    }

    public void levelOrder() {
        System.out.print("LevelOrder: ");
        for (int i = 1; i <= this.heightTree(root) + 1; i++)
            levelOrder(root, i);
        System.out.println();
    }

    public void levelOrder(Node wz, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(wz.getKey() + " ");
        else if (level > 1) {
            if (wz.getLeft() != null)
                levelOrder(wz.getLeft(), level - 1);
            if (wz.getRight() != null)
                levelOrder(wz.getRight(), level - 1);
        }
    }

    public void kolejka() {
        LinkedList<String> ll = new LinkedList<>();
        if (root == null)
            return;
        ll.add(root.getKey());
        kolejka(ll, root);

        System.out.println();
    }

    public void kolejka(LinkedList<String> ll, Node wz) {
        if (wz == null)
            return;
        if (wz.getLeft() != null)
            ll.add(wz.getLeft().getKey());
        if (wz.getRight() != null)
            ll.add(wz.getRight().getKey());

        if (ll.isEmpty() == false)
            System.out.print(ll.removeFirst() + " ");
        if (wz.getLeft() != null)
            kolejka(ll, wz.getLeft());
        if (wz.getRight() != null)
            kolejka(ll, wz.getRight());
    }
}
