package leetcode.editor.cn.other;

import javafx.util.Pair;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Bank {
    public static void solve1(){
        int n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=scanner.nextInt();
        }
        int max=arr[0];
        for(int i=0;i<n;i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int count=0;
        for(int i=0;i<n;i++) {
            if (arr[i] == max)
                count++;
        }
        System.out.println(count);
        return;
    }

    public static void solve2(){

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt();
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        double arr[]=new double[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextDouble();
        }
        int key,val;
        for (int i = 0; i < m; i++) {
            key=scanner.nextInt();
            val= scanner.nextInt();
            list.add(new Pair<>(key,val));
        }

        List<HashSet<Integer>> setList=new ArrayList<>();
        HashSet<Integer> hashSet=new HashSet<>();
        hashSet.add(list.get(0).getKey());
        hashSet.add(list.get(0).getValue());
        setList.add(hashSet);
        for (int i = 1; i < list.size(); i++) {
            int i1 = 0;
            for (; i1 < setList.size(); i1++) {
                if(setList.get(i1).contains(list.get(i).getKey())){
                    if(setList.get(i1).contains(list.get(i).getValue())){
                        break;
                    }
                    else{
                        setList.get(i1).add(list.get(i).getValue());
                        break;
                    }
                }
                else{
                    if(setList.get(i1).contains(list.get(i).getValue())){
                        setList.get(i1).add(list.get(i).getKey());
                        break;
                    }
                }
            }
            if(i1==setList.size()){
                HashSet<Integer> hashSeti=new HashSet<>();
                hashSeti.add(list.get(i).getKey());
                hashSeti.add(list.get(i).getValue());
                setList.add(hashSeti);
            }
        }

        for (int i = 0; i < setList.size(); i++) {
            hashSet=setList.get(i);
            double sum=0;
            for(int j:hashSet){
                sum+=arr[j-1];
            }
            double avg=sum/hashSet.size();
            for(int j:hashSet) {
                arr[j-1] = avg;
            }

        }

        for (int i = 0; i < n; i++) {
            DecimalFormat decimalFormat=new DecimalFormat(".00");
            String avgS=decimalFormat.format(arr[i]);
            System.out.print(avgS+" ");
        }
    }

    public static void solve3(){

        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n=scanner.nextInt();
            ArrayList<Integer> arrayList =new ArrayList<>();
            for(int j=0;j<n;j++) {
                int numi=scanner.nextInt();
                arrayList.add(numi);
            }
            //最后一位为0
            //前面数字和为3的倍数
            if(!arrayList.contains(0)){
                System.out.println(0);
                continue;
            }
            int sum=0;
            for (int i1 = 0; i1 < arrayList.size(); i1++) {
                sum+=arrayList.get(i1);
            }
            if(sum%3==1){
                if(arrayList.indexOf(1)!=-1)
                    arrayList.remove(arrayList.indexOf(1));
                else if(arrayList.indexOf(2)!=-1 && arrayList.indexOf(2)!=arrayList.lastIndexOf(2)){
                    arrayList.remove(arrayList.indexOf(2));
                    arrayList.remove(arrayList.indexOf(2));
                }
            }
            else if(sum%3==2){
                if(arrayList.indexOf(2)!=-1)
                    arrayList.remove(arrayList.indexOf(2));
                else if(arrayList.indexOf(1)!=-1&&arrayList.indexOf(1)!=arrayList.lastIndexOf(1)){
                    arrayList.remove(arrayList.indexOf(1));
                    arrayList.remove(arrayList.indexOf(1));
                }
            }

            arrayList.sort((a,b)->{return (b-a);});
            if(arrayList.get(0)==0)
                System.out.println(0);
            else {
                for (int i1 = 0; i1 < arrayList.size(); i1++) {
                    System.out.print(arrayList.get(i1));
                }
                System.out.println();
            }



        }

    }

    public static void main(String[] args) {
        solve3();
    }
}
