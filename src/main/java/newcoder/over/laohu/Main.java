package newcoder.over.laohu;

public class Main {
    public String solve(String str){
        StringBuilder sb = new StringBuilder();
        char ch = str.charAt(0);
        int count = 1;
        for(int i=1;i<str.length();i++){
            char cur = str.charAt(i);
            if(cur==ch)
                count++;
            else{
                sb.append(ch);
                if(count>1)
                    sb.append(count);
                count = 1;
                ch = cur;
            }
        }
        sb.append(ch);
        if(count>1)
            sb.append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Main().solve("AAYYooPPlllllqwe"));
    }
}
