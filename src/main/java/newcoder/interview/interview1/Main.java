package newcoder.interview.interview1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    public static List<String[]> list = new LinkedList<>();
    public static Stack<String> maxTime = new Stack<>();
    public static int  max = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String[]strs = new String[n];
        for(int i=0;i<n;i++)
            strs[i] = scanner.nextLine();
        Arrays.sort(strs);
        solve(strs,0);
        System.out.println(max);
    }


    public static void solve(String[] strs,int idx){
        if(list.size()==3){
            int cur = getL();
            if(max<cur)max=cur;
            return;
        }

        for(int i = idx;i<strs.length;i++){
            String[] ss = strs[i].split("-");
            if(!maxTime.isEmpty()&&(maxTime.peek().compareTo(ss[0])>0))continue;
            list.add(ss);
            maxTime.push(ss[1]);
            solve(strs,i+1);
            list.remove(list.size()-1);
            maxTime.pop();
        }

    }

    public static int getL(){
        int res=0;
        for(int i=0;i<3;i++){
            String begin = list.get(i)[0],end = list.get(i)[1];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            Date dateBegin,dateEnd;
            long diff =0;
            try {
                dateBegin = simpleDateFormat.parse(begin);
                dateEnd = simpleDateFormat.parse(end);
                diff = dateEnd.getTime() - dateBegin.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            res+=diff/(60*1000);

        }
        return res;
    }

}
