import java.util.*;
import java.io.*;
public class Vestigium {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();  
    for (int i = 1; i <= t; ++i) 
    {
        int n=sc.nextInt();
        int ar[][]=new int[n][n];
        int sum=0;
        for(int x=0;x<n;x++)
        {
            for(int y=0;y<n;y++)
            {
                ar[x][y]=sc.nextInt();
                if(x==y)
                {
                    sum+=ar[x][y];
                }
            }
        }
        int r=0;
        int c=0;
        for(int x=0;x<n;x++)
        {
            HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
            hash.put(ar[x][0],0);
            for(int y=1;y<n;y++)
            {
                if(hash.containsKey(ar[x][y]))
                {
                    r++;
                    break;
                }
                hash.put(ar[x][y],0);
            }
        }
        for(int x=0;x<n;x++)
        {
            HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
            hash.put(ar[0][x],0);
            for(int y=1;y<n;y++)
            {
                if(hash.containsKey(ar[y][x]))
                {
                    c++;
                    break;
                }
                hash.put(ar[y][x],0);
            }
        }
        System.out.println("Case #"+i+": "+sum+" "+r+" "+c);
    }
  }
}
