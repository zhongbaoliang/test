package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Yuanfudao1{
    public static int getNum(String boxes){
        int num=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='['){
                stack.push(boxes.charAt(i));
            }
            else if(boxes.charAt((i))==']'){
                int numi=0;
                while(stack.peek()!='[')
                    numi+=stack.pop()-'0';
                stack.pop();
                if(numi==0)numi=1;
                stack.push((char) (numi+'0'));
                //stack.push(']');
            }
            else{
                int numi=stack.pop()-'0';
                numi=numi*(boxes.charAt(i)-'0');
                stack.push((char) (numi+'0'));
            }
        }
        while(!stack.isEmpty()){
            num+=stack.pop()-'0';
        }
        return num;

    }
    public static void main(String[] args) {
        System.out.println(getNum("[][[][][]2]3"));
    }
}

class Yuanfudao2{

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        String line =scanner.nextLine();
        String[] input = line.split(" ");
        for(String data : input){
            integerList.add(Integer.parseInt(data));
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<integerList.size()-1;i++){
            if(integerList.get(i)>integerList.get(i+1)){
                if(res.isEmpty()){
                    res.add(i+1);
                }
                else
                    res.add(i+2);
            }
        }
        for(int i=0;i<res.size();i++)
            System.out.print(res.get(i)+" ");
    }

}

class Yuanfudao3{


    public static void main(String[] args) {

    }

}



public class Yuanfudao {

}
