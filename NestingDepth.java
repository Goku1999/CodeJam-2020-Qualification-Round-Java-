import java.util.*;
import java.io.*;
public class NestingDepth 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  
        for (int i = 1; i <= t; ++i) 
        {
            String s=sc.next();
            String ans="";
            String r="";
            for(int x=0;x<s.length();x++)
            {
                char ch=s.charAt(x);
                if(ch=='0')
                {
                    if(r.length()!=0)
                    {
                        ans=ans+solve(r,0);
                    }
                    ans=ans+"0";
                    r="";
                }
                else
                {
                    r=r+ch;
                }
            }
            if(r.length()!=0)
            {
                ans=ans+solve(r,0);
            }
            System.out.println("Case #"+i+": "+ans);
        }
    }

    /*public static String solve(String s)
    {
        String ans="";
        String r="";
        for(int x=0;x<s.length();x++)
        {
            char ch=s.charAt(x);
            if(ch=='0')
            {
                if(r.length()!=0)
                {
                    ans=ans+solve(r,0);
                }
                ans=ans+"0";
                r="";
            }
            else
            {
                r=r+ch;
            }
        }
        if(r.length()!=0)
        {
            ans=ans+solve(r);
        }
    }*/
    public static String solve(String s,int c)
    {
        String ans="";
        char min='0';
        for(char x='1';x<='9';x++)
        {
            if(s.indexOf(x)!=-1)
            {
                min=x;
                break;
            }
        }
        String r="";
        int d=min-48-c;
        //System.out.println(d);
        for(int x=0;x<s.length();x++)
        {
            char ch=s.charAt(x);
            if(ch==min)
            {
                if(r.length()!=0)
                {
                    ans=ans+solve(r,c+d);
                }
                ans=ans+min+"";
                r="";
            }
            else
            {
                r=r+ch;
            }
        }
        if(r.length()!=0)
        {
            ans=ans+solve(r,c+d);
        }
        for(int x=0;x<d;x++)
        {
            ans="("+ans+")";
        }
        return ans;
    }
}
