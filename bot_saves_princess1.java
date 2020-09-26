import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;

public class Solution {

    
static double getscore(int n, int r1, int c1, int r2, int c2) {
    return (n*n-(Math.abs(r1-r2)+Math.abs(c1-c2)))/10.0;
}
    
static void displayPathtoPrincess(int n, String [] grid){
    int i=0;
    int columnp,rowp, columnm, rowm;
    columnp=rowp=columnm=rowm=-1;
    for(String s : grid){
        if(s.indexOf('p')!=-1) {
            columnp=s.indexOf('p');
            rowp=i;
        }
        if(s.indexOf('m')!=-1) {
            columnm=s.indexOf('m');
            rowm=i;
        }
        i++;
    }
    double initial_score = getscore(n, rowm, columnm, rowp, columnp);
    while(rowm!=rowp || columnm!=columnp)
    {
        if(getscore(n, rowm+1, columnm, rowp, columnp)>initial_score) {
            System.out.println("DOWN");
            initial_score=getscore(n, rowm+1, columnm, rowp, columnp);
            rowm++;
        }
        else if(getscore(n, rowm-1, columnm, rowp, columnp)>initial_score) {
            System.out.println("UP");
            initial_score=getscore(n, rowm-1, columnm, rowp, columnp);
            rowm--;
        }
        else if(getscore(n, rowm, columnm+1, rowp, columnp)>initial_score) {
            System.out.println("RIGHT");
            initial_score=getscore(n, rowm, columnm+1, rowp, columnp);
            columnm++;
        }
        else if(getscore(n, rowm, columnm-1, rowp, columnp)>initial_score) {
            System.out.println("LEFT");
            initial_score=getscore(n, rowm, columnm-1, rowp, columnp);
            columnm--;
        }
    }       
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}
