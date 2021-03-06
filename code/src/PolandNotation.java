import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args){
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        int res = calculate(rpnList);
        System.out.println(res);
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List"+ infixExpressionList);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的list"+parseSuffixExpressionList);
    }
    //方法：将得到的中缀表达式对应的List，转化成后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<String>(); //符号栈
       // Stack<String> s2 = new Stack<String>(); 存储中间结果的栈
        List<String> s2 = new ArrayList<String>();
        for(String item: ls){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将（弹出
            }else{
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }
    //将中缀表达式转换成对应的List
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;//指针，用于遍历 中缀表达式字符串
        String str; //对多位数的拼接
        char c;//每遍历到一个字符，就放入c中
        do{
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else {//如果是数字，考虑多位数问题
                str = "";
                while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
    }
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split){
            list.add(ele);
        }
        return list;
    }
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<String>();
        for(String item: ls){
            //正则表达式取出数
            if(item.matches("\\d+")){//匹配的是多位数
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("WRONG");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    public static int getValue(String operation){
        int result = 0;
        switch(operation){
            case "+":
             result = ADD;
             break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
