package calculator;

import java.util.Scanner;
import java.util.Stack;

public class solution {
    public static int priority(char op){
        if(op == '+' || op == '-') return 1;
        if(op == '*' || op == '/') return 2;
        return 3;
    }


    public static void operation(Stack<Double> st, Stack<Character> rt) {
        if (st.size() < 2 || rt.isEmpty()) return;
        double v2 = st.pop();
        double v1 = st.pop();
        char op = rt.pop();
        if(op == '+') st.push(v1 + v2);
        else if(op == '-') st.push(v1 - v2);
        else if(op == '*') st.push(v1 * v2);
        else if(op == '/') st.push(v1 / v2);
        else if(op == '^') st.push(Math.pow(v1, v2));
    }


    public static boolean balancebracket(String str){
        Stack<Character> bracketst = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') bracketst.push(ch);
            else if (ch == ')') {
                if (bracketst.isEmpty()) return false;
                bracketst.pop();
            }
        }
        return bracketst.isEmpty();
    }


    public static boolean invalidCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch) && "+-*/()^".indexOf(ch) == -1) {
                return true;
            }
        }
        return false;
    }


    public static boolean consecutiveOperator(String str) {
        for (int i = 1; i < str.length(); i++) {
            if ("+-*/^".indexOf(str.charAt(i)) != -1 && "+-*/^".indexOf(str.charAt(i - 1)) != -1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Stack<Double> st = new Stack<>();
        Stack<Character> rt = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter arithmetic expression");
        String str = sc.nextLine();
//        String str = ")9+2/3";

        if (!balancebracket(str)) {
            System.out.println(" ASUVIDHA K LIE KHED H LEKIN:- brackets are not balanced, please first balance your brackets then come again and try");
            return;
        }

        if (invalidCharacter(str)) {
            System.out.println("ASUVIDHA K LIE KHED H LEKIN:- you have used some special symbol which does not belong to basic mathematical operators hence invalid string");
            return;
        }

        if (consecutiveOperator(str)) {
            System.out.println("ASUVIDHA K LIE KHED H LEKIN:- there is consecutive operator which does not make any sense hence invalid string");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                int n = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    n = n * 10 + (str.charAt(i) - '0');
                    i++;
                }
                st.push((double) n);
                i--;
            } else if (ch == '(') {
                rt.push(ch);
            } else if (ch == ')') {
                while (!rt.isEmpty() && rt.peek() != '('){
                    if (st.size() < 2) break;
                    operation(st,rt);
                }
                if (!rt.isEmpty()) rt.pop();
            } else{
                while (!rt.isEmpty() && rt.peek() != '(' && priority(rt.peek()) >= priority(ch)){
                    if (st.size() < 2) break;
                    operation(st,rt);
                }
                rt.push(ch);
            }
        }
        while (!rt.isEmpty() && st.size() >= 2){
            operation(st,rt);
        }
        if(st.isEmpty()){
            System.out.println("invalid");
        }
        else {
//            System.out.println("your answer is: "+st.peek());
            String formattedNumber = String.format("%.2f", st.peek());
            System.out.println("your answer is: "+formattedNumber);
        }
    }
}
