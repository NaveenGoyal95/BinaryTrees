package com.btree;

public class EditDistance {

	public static void main(String args[]) 
    { 
        String str1 = "abc"; 
        String str2 = "abcd"; 
   
        System.out.println( editDist( str1 , str2 , str1.length(), str2.length()) ); 
    } 
	
	
	public  static int editDist(String str1,String str2,int m,int n) {
		
		int[][] solution=new int[m+1][n+1];
		
		if(m==0)
			return n;
		if(n==0)
			return m;
		
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0)
					solution[i][j]=j;
				
				else if(j==0)
					solution[i][j]=i;
				
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					solution[i][j]=solution[i-1][j-1];
				
				else {
					solution[i][j]=Math.min(solution[i][j-1],Math.min(solution[i-1][j],solution[i-1][j-1]))+1;
				}
					
			}
		}
		return solution[m][n];
		
	}
}
