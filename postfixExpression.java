package infixPrefixPostfixExpression;

import java.util.Stack;

public class postfixExpression {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        String str = "953+4*6/-";
        System.out.println("original string is: "+str);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57){
                st.push(ascii - 48);
            }
            else {
                if(ch == '+'){
                    int v2 = st.pop();
                    int v1 = st.pop();
                    st.push(v1 + v2);
                }
                if(ch == '-'){
                    int v2 = st.pop();
                    int v1 = st.pop();
                    st.push(v1 - v2);
                }
                if(ch == '*'){
                    int v2 = st.pop();
                    int v1 = st.pop();
                    st.push(v1 * v2);
                }
                if(ch == '/'){
                    int v2 = st.pop();
                    int v1 = st.pop();
                    st.push(v1 / v2);
                }
            }
        }
        System.out.println("value is: "+st.peek());
    }
}
