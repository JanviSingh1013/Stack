package infixPrefixPostfixExpression;

import java.util.Stack;

public class inffixToPrefix {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        System.out.println("infix expression is: "+ str);
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch  = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57){
                String s = "" + ch;
                st.push(s);
            } else if (op.isEmpty() || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '('){
                    String v2 = st.pop();
                    String v1 = st.pop();
                    char operator = op.pop();
                    String t = operator + v1 + v2;
                    st.push(t);
                }
                op.pop();
            } else {
                if(ch == '+' || ch == '-'){
                    String v2 = st.pop();
                    String v1 = st.pop();
                    char operator = op.pop();
                    String t = operator + v1 + v2;
                    st.push(t);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '+' || op.peek() == '-') op.push(ch);
                    else{
                        String v2 = st.pop();
                        String v1 = st.pop();
                        char operator = op.pop();
                        String t = operator + v1 + v2;
                        st.push(t);
                        op.push(ch);
                    }
                }
            }
        }
        while (st.size() > 1){
            String v2 = st.pop();
            String v1 = st.pop();
            char operator = op.pop();
            String t = operator + v1 + v2;
            st.push(t);
        }
        System.out.println("prefix expression is: "+ st.peek());
    }
}
