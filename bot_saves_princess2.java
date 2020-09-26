import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;

public class Solution {

static double score(int n, int r1, int c1, int r2, int c2) {
    return (n*n-(Math.abs(r1-r2)+Math.abs(c1-c2)))/10.0;
}
    
    
static void nextMove(int n, int r, int c, String [] grid){
    int i=0;
    int column=-1, row=-1;
    for (String s: grid) {
        if(s.indexOf('p')!=-1) {
            column=s.indexOf('p');
            row=i;
        }
        i++;
    }
    double initial_score = score(n,r,c,row,column);
    if(score(n,r+1,c,row,column)>initial_score) System.out.println("DOWN");
    else if(score(n,r-1,c,row,column)>initial_score) System.out.println("UP");
    else if(score(n,r,c+1,row,column)>initial_score) System.out.println("RIGHT");
    else if(score(n,r,c-1,row,column)>initial_score) System.out.println("LEFT");
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);

    }
}
