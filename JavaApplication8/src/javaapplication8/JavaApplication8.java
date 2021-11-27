package javaapplication8;

public class JavaApplication8 {

    	public static void main(String[] args) {
    	int p = (int)(Math.random()*50+1);
    	int q = (int)(Math.random()*10);
   	 
    	int a = rnd(Math.random()*5);
    	int b = rnd(Math.random()*5);
    	while (a==b) {
        	b = rnd(Math.random()*5);
    	}
   
    	int A= ((int)Math.pow(q, a)) % p;
    	int B= ((int)Math.pow(q, b)) % p;

    	int Ka=((int)Math.pow(B, a)) % p;
    	int Kb=((int)Math.pow(A, b)) % p;
    	System.out.println("Step 1:");
    	System.out.println("A || p="+p+" q="+q);
    	System.out.println("B || p="+p+" q="+q);
    	System.out.println("E || p="+p+" q="+q);
    	System.out.println("Step 2:");
    	System.out.println("A || p="+p+" q="+q+" a="+a);
    	System.out.println("B || p="+p+" q="+q+" A="+A);
    	System.out.println("E || p="+p+" q="+q+" A="+A);
    	System.out.println("Step 3:");
    	System.out.println("A || p="+p+" q="+q+" a="+a+" B="+B);
    	System.out.println("B || p="+p+" q="+q+" A="+A+" b="+b);
    	System.out.println("E || p="+p+" q="+q+" A="+A+" B="+B);
    	System.out.println("Key A= "+Ka);
    	System.out.println("Key B= "+Kb);
	}  
	public static int rnd(double number){
    	int n=(int)number;
    	int fin=2;
    	int[] base= new int[n+1];
    	int[] state= new int[n+1];
    	for (int i=1;i<=n;i++){
        	base[i]=i;
        	state[i]=0;
    	}
    	for (int i=2;(i*i)<=n;i++){
        	if ((state[i*i]!=1))
            	for (int j=(i*i);j<=n;j++)
                	if ((j%i)==0)
                    	state[j]=1;
	}
    	for (int i=n;i>0;i--){
        	if (state[i]==0)
        	{
            	fin=base[i];  
            	break;
        	}
    	}
    	return fin;
	}
}
