package calculator;

import java.util.Scanner;
import java.util.Stack;

public class nevigation {
    public static void main(String[] args) {
        Stack<String> mainst = new Stack<>();
        Stack<String> nextst = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String ch;
        do{
            System.out.println("ENTER WEBSITE NAME");
            String name = sc.nextLine();
            mainst.push(name);
            System.out.println("WANNA ADD MORE WEBSITE NAME IF YES THEN ENTER Y IF NO THEN ENTER N");
            ch = sc.nextLine().toLowerCase();
        }while (ch.equals("y"));


        System.out.println("\nNOW THAT YOU HAVE STOP ADDING WEBSITE NAME LET ME SHOW YOU THE LIST OF ALL THE WEBSITE THAT YOU ENTER: "+mainst);


        String nxtchoice;
        do{

            System.out.println("ENTER 1 FOR FORWARD NEVIGATION");
            System.out.println("ENTER 2 FOR BACKWORD NEVIGATION");
            System.out.println("ENTER 3 FOR SATISFIED");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    if(!nextst.isEmpty()){
                        mainst.push(nextst.pop());
                        System.out.println("YOUR CURRENT PAGE IS: "+ mainst.peek());
                    }
                    else{
                     //   System.out.println("YOUR CURRENT PAGE IS: "+ mainst.peek());
                        System.out.println("NO MORE NEXT PAGE");
                    }
                    break;
                case 2:
                    if(mainst.size() > 1){
                        nextst.push(mainst.pop());
                        System.out.println("YOUR CURRENT PAGE IS: "+ mainst.peek());
                    }
                    else {
                     //   System.out.println("YOUR CURRENT PAGE IS: "+ nextst.peek());
                        System.out.println("NO MORE PREVIOUS PAGE");
                    }
                    break;
                case 3:
                    System.out.println("YOU ARE SATISFIED NOW");
                    System.out.println("DONE WITH THE CODE");
                    return;
                default:
                    System.out.println("WRONG CHOICE YOU MADE");
            }
            System.out.println("IF YOU ARE NOT SATISFIED THEN ENTER Y IF YOU ARE SATISFIED ENTER N");
            nxtchoice = sc.nextLine().toLowerCase();
        }while (nxtchoice.equals("y"));
        System.out.println("DONE WITH THE CODE");
    }
}
