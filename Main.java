import java.util.*;
import java.io.*;

class Main {
  public static long[] arrK;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine()," ");
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    arrK = new long[K];
    for(int i=0;i<K;i++){
      arrK[i] = Long.parseLong(br.readLine());
    }

    Arrays.sort(arrK);  // 랜선 길이 별 정렬

    System.out.print(cut_cnt(K,N)); // 이미 가진, 필요 랜선
  }
  public static long cut_cnt(int total, int num){
    long start = 1; 
    long end = arrK[total-1]; // 가장 긴 랜선
    long sum, mid; // 만든 랜선 총 개수

    while(end>=start){
      mid = (start+end)/2; // mid
      sum =0; 
      for(int i=0;i<total;i++){
        sum += arrK[i]/mid; // arrK를 mid로 나눈 개수 더해줌 
      }
      if(sum<num){ // 만들 총 개수 보다 만든 것이 많으면 mid+1~end
        end = mid-1;
      }
      else{
        start = mid+1;
      }
    }
    return end;
  }

}  