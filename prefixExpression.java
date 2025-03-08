package infixPrefixPostfixExpression;

import java.util.Stack;

public class prefixExpression {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        String str = "-9/*+5346";
        System.out.println("original string is: "+ str);
        for (int i = str.length() - 1; i >= 0 ; i--) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57){
                st.push(ascii - 48);
            }
            else{
                if(ch == '+'){
                    int v1 = st.pop();
                    int v2 = st.pop();
                    st.push(v1 + v2);
                }
                if(ch == '-'){
                    int v1 = st.pop();
                    int v2 = st.pop();
                    st.push(v1 - v2);
                }
                if(ch == '*'){
                    int v1 = st.pop();
                    int v2 = st.pop();
                    st.push(v1 * v2);
                }
                if(ch == '/'){
                    int v1 = st.pop();
                    int v2 = st.pop();
                    st.push(v1 / v2);
                }
            }
        }
        System.out.println("value is: "+ st.peek());
    }
}
