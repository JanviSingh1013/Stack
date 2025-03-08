package infixPrefixPostfixExpression;

import java.util.Stack;

public class infixToPostfix {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        String str = "9-(5+3)*4/6";
        System.out.println("infix is: "+str);
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii<= 57){
                String s = "" + ch;
                st.push(s);
            } else if (op.isEmpty() || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '('){
                    String v2 = st.pop();
                    String v1 = st.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    st.push(t);
                }
                op.pop();
            }
            else{
                if(ch == '+' || ch == '-'){
                    String v2 = st.pop();
                    String v1 = st.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    st.push(t);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        String v2 = st.pop();
                        String v1 = st.pop();
                        char o = op.pop();
                        String t = v1 + v2 + o;
                        st.push(t);
                        op.push(ch);
                    }
                    else {
                        op.push(ch);
                    }
                }
            }
        }
        while (st.size() > 1){
            String v2 = st.pop();
            String v1 = st.pop();
            char o = op.pop();
            String t = v1 + v2 + o;
            st.push(t);
        }
        System.out.println("postfix is: "+st.peek());
    }
}
