import java.util.*;
import java.lang.*;
import java.io.*;

class Polynomial1{
    double coeff[];
    int deg;
    Polynomial(){
        coeff[]=new coeff[1000];
        deg=0;
    }
    getPolynomial(){
        int a[]=new int[1000];int i=0;
        while(sc.hasNextInt()){
            a[i++]=sc.nextInt();
        }
        deg=i;
        coeff=a.clone();
    }
    public static void main{
        P1=new Polynomial();
        P2=new Polynomial();
        Scanner sc=new Scanner(system.in);
        System.out.prinln("Enter the type of value to give\n");
        System.out.println("1.String");
        System.out.println("2.Int");
        int choice= sc.nextInt();
        if(choice==1){
                    P1.getPolynomial();
                    P2.getPolynomial();
        }
        if(choice==2){
            P1.getPolynomialFromString(s);
            P2.getPolynomialFromString(s);
        }
        Polynomial P3=P1.add(P2);
        P3.toString();
        P3=P1.subtract(P2);
        P3.toString();
        P3=P1.multiply(P2);
        P3.toString();
    }
}