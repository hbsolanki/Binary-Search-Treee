import java.util.*;

class Convertor{
    public static int prec(char c){
        switch(c){
            case '+' : return 1;
            case '-' : return 1;
            case '*' : return 2;
            case '/' : return 2;
            case '^' : return 3;
        }
        return -1;
    } 

    public static String infixTo(String exp,int x){
        String result="";
        // Initializing empty stack
        Deque<Character> stack= new ArrayDeque<Character>(); 
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
  
            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
  
            // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);
  
            // If the scanned character is an ')',pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()&& stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
  
                stack.pop();
            
            }else{ // An operator is encountered
                if(x==1){
                    while (!stack.isEmpty()&& prec(c) <= prec(stack.peek())) {
                        if(c==stack.peek()){
                            break;
                        }
                        result += stack.peek();
                        stack.pop();
                    }
                }else{
                    while (!stack.isEmpty()&& prec(c) < prec(stack.peek())) {
                        if(c=='^' && stack.peek()=='^'){
                            break;
                        }
                        result += stack.peek();
                        stack.pop();
                    }
                }   
                stack.push(c);
            }
        }
  
        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '('){
                return "Invalid Expression";
            }   
            result += stack.peek();
            stack.pop();
        }
        return result;
    }

    public static String infixToPrefix(String exp){
        StringBuilder sb1=new StringBuilder(exp);
        sb1.reverse();
        StringBuilder sb=new StringBuilder(infixTo(sb1.toString(),1));
        sb.reverse();
        return sb.toString();
    }

    public static String infixToPostfix(String str){
        return infixTo(str, 2);
    }

}

class Main{
    public static void main(String[] args) {
        Convertor c=new Convertor();
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            
            System.out.println();
            System.out.println("Select Options \n(1)Prefix\n(2)Postfix\n(3)Exit");
            choice=sc.nextInt();
            if(choice==3){
                System.exit(0);
            }
            sc.nextLine();
            System.out.print("Enter Infix : ");
            String infix=sc.nextLine();
            switch(choice){
                case 1 : System.out.println(c.infixToPrefix(infix));
                         break;
                case 2 : System.out.println(c.infixToPostfix(infix));
                         break;
                default :System.out.println("Choice Valid Option"); 
                         break;
            }

            System.out.println();
        }while(true);
    }
}