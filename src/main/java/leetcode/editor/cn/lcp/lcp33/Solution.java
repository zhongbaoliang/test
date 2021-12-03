package leetcode.editor.cn.lcp.lcp33;

import java.util.PriorityQueue;

public class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((root, child)->child[0]-root[0]);
        int len = bucket.length,cnt = 0,ans = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(bucket[i]==0){
                if(vat[i]!=0){
                    cnt++;
                    //pq.offer(new int[]{(int)Math.ceil(vat[i]/(bucket[i]+1.0)),i});
                    pq.offer(new int[]{(vat[i]+bucket[i])/(++bucket[i]),i});
                }
            }
            else
                pq.offer(new int[]{(vat[i]+bucket[i]-1)/bucket[i],i});
            //pq.offer(new int[]{(int)Math.ceil(vat[i]/(bucket[i]+0.0)),i});
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            ans = Math.min(cur[0] + cnt,ans);
            cur[0] = (vat[cur[1]]+bucket[cur[1]])/(++bucket[cur[1]]);
            pq.offer(cur);
            cnt++;
            if(cnt>=ans)
                return ans;
        }
        /*while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int newAns = cnt+cur[0];
            if(newAns>ans)
                return ans;
            ans = newAns;
            cur[0] = (vat[cur[1]]+bucket[cur[1]])/(++bucket[cur[1]]);
            pq.offer(cur);
            cnt++;
        }*/
        return cnt;
    }

    public static void main(String[] args) {
        int bucket[] = new int[]{21,56}, vat[] = new int[]{3230,8299};
        System.out.println(new Solution().storeWater(bucket,vat));
    }
}
