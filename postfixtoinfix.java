package infixPrefixPostfixExpression;

import java.util.Stack;

public class postfixToInfix {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        String str = "953+4*6/-";
        System.out.println("postfix expression is: "+str);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57){
                String s = "" + ch;
                st.push(s);
            }
            else{
                String v2 = st.pop();
                String v1 = st.pop();
                if(ch == '+') st.push('(' + v1 + ch + v2 + ')');
                if(ch == '-') st.push('(' + v1 + ch + v2 + ')');
                if(ch == '*') st.push('(' + v1 + ch + v2 + ')');
                if(ch == '/') st.push('(' + v1 + ch + v2 + ')');
            }
        }
        System.out.println("infix expression is: "+ st.peek());
    }
}
