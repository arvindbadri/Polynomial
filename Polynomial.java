import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
	
	 double[] coeff;
	 int deg;
	
	
	public Polynomial() {
		coeff = new double[1000];
		deg = 0;
	}
	
	public Polynomial multiply(Polynomial p2) {
		Polynomial p3 = new Polynomial();
		for(int i = 0;  i <= deg; i++)
			for(int j = 0; j <= p2.deg; j++) {
				p3.coeff[i+j] = coeff[i]*p2.coeff[j];
				if((i+j)>p3.deg) {
					p3.deg = i+j;
				}
			}
		return p3;
	}
	
	public static void p(Object o) {
		System.out.print(o);
	}
	
	public void getPolynomial(){
		Scanner sc = new Scanner(System.in);
	        int a[]=new int[1000];int i=0;
	        while(sc.hasNextInt()){
	            a[i++]=sc.nextInt();
	        }
	        deg=i;
	        for(int i1=0;i1<deg;i1++)
	        	coeff[i1] = a[i1];
	    }
	
	public Polynomial add (Polynomial p) {
		//code
		Polynomial result = new Polynomial();
		result.deg = (deg>p.deg) ? deg:p.deg;
		p(result.deg+" ");
	    for(int i=0;i<=result.deg;i++)
	    {
	    	p(coeff[i]+" "+p.coeff[i]+"\n");
	       result.coeff[i] = coeff[i] + p.coeff[i];
	 	}
	    return result;
	}
	
	public Polynomial subtract (Polynomial p) {
		//code
		Polynomial result = new Polynomial();
		result.deg = (deg>p.deg)? deg : p.deg;
	    for(int i=0;i<=result.deg;i++)
	    {
	       result.coeff[i] = coeff[i] - p.coeff[i];
	 	}
	    return result;
	}
	
	    public static void main(String[] args){
	        Polynomial P1=new Polynomial();
	        Polynomial P2=new Polynomial();
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter the type of value to give\n");
	        System.out.println("1.String");
	        System.out.println("2.Int");
	        int choice= sc.nextInt();
	        if(choice==2){
	                    P1.getPolynomial();
	                    P2.getPolynomial();
	        }
	        if(choice==1){
	        	String s1 = sc.next();
	            P1 = getPolynomialFromString(s1);
	            String s2 = sc.next();
	            P2 = getPolynomialFromString(s2);
	        }
	        

	        // Testing
	        Polynomial P3=P1.add(P2);
	        p(P3.toString()+"\n");
	        Polynomial P4=P1.subtract(P2);
	        p(P4.toHTML()+"\n");
	        Polynomial P5 = P1.multiply(P2);
	        p(P5.deg+"\n");
	        p(P5.toString()+"\n");
	        
	    }
	
	public static Polynomial getPolynomialFromString(String input) {
		Polynomial P = new Polynomial();
		Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
		Matcher m = p.matcher( input );
		while (m.find()) {
			if(Integer.parseInt(m.group(2))>P.deg)
				P.deg = Integer.parseInt(m.group(2));
			P.coeff[Integer.parseInt(m.group(2))] = Double.parseDouble(m.group(1));		
		}
		return P;
	}
	
	public String toHTML() {
		String HTML = "<p>";
		
		for(int i = 0; i <= deg; i++) {
			
			if(coeff[i] != 0) {
				if(coeff[i] > 0)
					HTML += "+";
				HTML += (coeff[i]+"x<sup>"+i+"</sup> ");
			}
		}
		HTML += "</p>";
		return HTML;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i <= deg; i++) {
			if(coeff[i]!=0) {
				if(coeff[i] > 0)
					str += "+";
			}
				str += coeff[i]+"x^"+i+" ";
		}	
		return str;
	}
	

}
