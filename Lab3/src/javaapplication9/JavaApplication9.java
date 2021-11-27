package javaapplication9;

public class JavaApplication9 {
	public static void main(String[] args) {
    	int d=1;
    	int e=1;
    	int F=1;
    	int m=1;
    	int p=1;
    	int q=1;
    	while ((d*e)%F!=1)
    	{
        	p = rnd(Math.random()*10+2);
        	q = rnd(Math.random()*10+2);
        	while (p==q)
            	q = rnd(Math.random()*5+2);
        	m = p*q;
        	F = (p-1)*(q-1);
        	e=rnde(F);
        	d=(int)(Math.random()*10);
    	}
    	int[] OKa = new int[] {e,m};
    	int[] CKa = new int[] {d,m};
   	 
    	e=1;
    	d=1;
    	F=1;
   	 
    	while ((d*e)%F!=1)
    	{
        	p = rnd(Math.random()*10+2);
        	q = rnd(Math.random()*10+2);
        	while (p==q)
            	q = rnd(Math.random()*5+2);
        	m = p*q;
        	F = (p-1)*(q-1);
        	e=rnde(F);
        	d=(int)(Math.random()*10);
    	}
    	int[] OKb = new int[] {e,m};
    	int[] CKb = new int[] {d,m};
   	 
    	System.out.println("Step 1:");
    	System.out.println("A || OKa={"+OKa[0]+", "+OKa[1]+"} CKa={"+CKa[0]+", "+CKa[1]+"}");
    	System.out.println("B || OKb={"+OKb[0]+", "+OKb[1]+"} CKb={"+CKb[0]+", "+CKb[1]+"}");
    	System.out.println("E || OKa={"+OKa[0]+", "+OKa[1]+"} OKb={"+OKb[0]+", "+OKb[1]+"}");
   	 
    	System.out.println("Step 2: A generate message");
    	int[] mess = new int[10];
    	for (int i=0;i<10;i++){
        	mess[i]=(int)(Math.random()*9+1);
        	System.out.print(mess[i]+" ");
    	}
     	System.out.println();
    	System.out.println("-------");
    	for (int i=0;i<10;i++){
        	mess[i]=((int)Math.pow(mess[i],OKb[0]))%OKb[1];
        	System.out.print(mess[i]+" ");
    	}
     	System.out.println();
    	System.out.println("	A send message");
    	System.out.println("	B decifering message");
    	for (int i=0;i<10;i++){
        	mess[i]=((int)Math.pow(mess[i],CKb[0]))%CKb[1];
        	System.out.print(mess[i]+" ");
    	}
    	System.out.println();
   	 
    	System.out.println("Step 3: B generate message");
    	for (int i=0;i<10;i++){
        	mess[i]=(int)(Math.random()*9+1);
        	System.out.print(mess[i]+" ");
    	}
     	System.out.println();
    	System.out.println("-------");
    	for (int i=0;i<10;i++){
        	mess[i]=((int)Math.pow(mess[i],OKa[0]))%OKa[1];
        	System.out.print(mess[i]+" ");
    	}
     	System.out.println();
    	System.out.println("	B send message");
    	System.out.println("	A decifering message");
    	for (int i=0;i<10;i++){
        	mess[i]=((int)Math.pow(mess[i],CKa[0]))%CKa[1];
        	System.out.print(mess[i]+" ");
    	}
    	System.out.println();
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
	public static int rnde(double number){
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
        	if (state[i]==0 && n%base[i]!=0)
        	{
            	fin=base[i];  
            	break;
        	}
    	}
    	return fin;
	}
}
