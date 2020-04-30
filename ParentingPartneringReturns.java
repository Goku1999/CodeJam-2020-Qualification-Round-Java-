import java.util.*;
import java.io.*;
public class ParentingPartneringReturns 
{
    static class Data
    {
        int start,end,index;
    }
    static class Sort implements Comparator<Data> 
    {
        public int compare(Data ob1,Data ob2)
        {
            return ob1.start - ob2.start ;
        }
    }
    public static String checkandcal(Data arr[],int n, char ch[])
    {
        int j=-1;
        int c=-1;
        for(int i=0;i<n;i++)
        {
            if((j== -1) || (j<= arr[i].start))
            {
                j=arr[i].end;
                ch[arr[i].index]='J';
            }
            else if((c== -1) || (c<=arr[i].start))
            {
                c=arr[i].end;
                ch[arr[i].index]='C';
            }
            else
            {
                return "IMPOSSIBLE";
            }
        }
        return "$";
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  
        for (int i = 1; i <= t; ++i) 
        {
            int n=sc.nextInt();
            Data arr[]=new Data[n];
            for(int x=0;x<n;x++)
            {
                arr[x]=new Data();
                arr[x].start=sc.nextInt();
                arr[x].end=sc.nextInt();
                arr[x].index=x;
            }
            Arrays.sort(arr, new Sort());
            char ch[]=new char[n];
            String s= checkandcal(arr,n,ch);
            //System.out.println(ch);
            if(!s.equals("$"))
            {
                System.out.println("Case #"+i+": "+s);
            }
            else
            {
                s=ch.toString();
                System.out.println("Case #"+i+": "+String.valueOf(ch));
            }
        }
    }
}
