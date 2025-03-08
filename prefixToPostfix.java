package infixPrefixPostfixExpression;

import java.util.Stack;

public class prefixToPostfix {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        String str = "-9/*+5346";
        System.out.println("prefix expression is: "+str);
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57){
                String s = "" + ch;
                st.push(s);
            }
            else{
                String v1 = st.pop();
                String v2 = st.pop();
                if(ch == '+') st.push(v1 + v2 + ch);
                if(ch == '-') st.push(v1 + v2 + ch);
                if(ch == '*') st.push(v1 + v2 + ch);
                if(ch == '/') st.push(v1 + v2 + ch);
            }
        }
        System.out.println("postfix expression: "+st.peek());
    }
}
