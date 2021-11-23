import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Racks{
    private double slots;
    private Books[] r ;
    private double available;
    public Racks(double s){
        this.slots = s;
        this.r = new Books[(int)slots];
        this.available = s;
    }
    private int i = 0;
    public void setRack(Books e){
        this.r[i] = e;
        this.i += 1;
        available -=1;
    }
    public boolean getAvailable(){
        if(available!=0.0){
            return true;
        }
        return false;
    }
    public void display(){
        for(int i = 0;i<slots;i++){
            System.out.println(r[i].getTitle().getTitle()+" "+r[i].getISBN().getISBN() +" "+r[i].getBarcode().getbarcode());
        }
    }
}
interface Comparable<T>{
    public int Compare(T first, T second);
}
class Books {
    private Title T1;
    private ISBN I1;
    private barcode B1;
    public Books(String T, long I, long B){
        this.T1 = new Title(T);
        this.I1 = new ISBN(I);
        this.B1 = new barcode(B);
    }
    public Title getTitle(){
        return this.T1;
    }
    public ISBN getISBN(){
        return this.I1;
    }
    public barcode getBarcode(){
        return this.B1;
    }
}
class CompareTitles implements Comparable<Title>{
    private int i = 0;
    @Override
    public int Compare(Title T1, Title T2){
        int n1 = T1.getTitle().length();
        int n2 = T2.getTitle().length();
        int N;
        if(n1<n2){
            N  = n1;
        }
        else{
            N = n2;
        }
        while(i!=N-1){
            if(getAsciiofnth(T1.getTitle(),i)<getAsciiofnth(T2.getTitle(),i)){
                return -1;
            }
            else if(getAsciiofnth(T1.getTitle(),i)>getAsciiofnth(T2.getTitle(),i)){
                return 1;
            }
            else{
                i+= 1;
            }
        }
        return 0;
    }
    public int getAsciiofnth(String s, int n){
        s = s.toLowerCase();
        if(s.equals("a")){
            return 97;
        }
        if(s.equals("b")){
            return 98;
        }
        if(s.equals("c")){
            return 99;
        }
        if(s.equals("d")){
            return 100;
        }
        if(s.equals("e")){
            return 101;
        }
        if(s.equals("f")){
            return 102;
        }
        if(s.equals("g")){
            return 103;
        }
        if(s.equals("h")){
            return 104;
        }
        if(s.equals("i")){
            return 105;
        }
        if(s.equals("j")){
            return 106;
        }
        if(s.equals("k")){
            return 107;
        }
        if(s.equals("l")){
            return 108;
        }
        if(s.equals("m")){
            return 109;
        }
        if(s.equals("n")){
            return 110;
        }
        if(s.equals("o")){
            return 111;
        }
        if(s.equals("p")){
            return 112;
        }
        if(s.equals("q")){
            return 113;
        }
        if(s.equals("r")){
            return 114;
        }
        if(s.equals("s")){
            return 115;
        }
        if(s.equals("t")){
            return 116;
        }
        if(s.equals("u")){
            return 117;
        }
        if(s.equals("v")){
            return 118;
        }
        if(s.equals("w")){
            return 119;
        }
        if(s.equals("x")){
            return 120;
        }
        if(s.equals("y")){
            return 121;
        }
        if(s.equals("z")){
            return 122;
        }
        return 0;
    }
}
class CompareISBN implements Comparable<ISBN>{
    @Override
    public int Compare(ISBN I1, ISBN I2){
        long n1 = I1.getISBN();
        long n2 = I2.getISBN();
        if(n1<n2){
            return -1;
        }
        if(n1>n2){
            return 1;
        }
        else{
            return 0;
        }
    }
}
class Comparebarcode implements Comparable<barcode>{
    @Override
    public int Compare(barcode B1, barcode B2){
        long n1 = B1.getbarcode();
        long n2 = B2.getbarcode();
        if(n1<n2){
            return -1;
        }
        if(n1>n2){
            return 1;
        }
        else{
            return 0;
        }
    }
}
class Title{
    private String T1;
    public Title(String T){
        this.T1 = T;
    }
    public String getTitle(){
        return T1;
    }
}
class ISBN{
    private long I1;
    public ISBN(long I){
        this.I1 = I;
    }
    public long getISBN(){
        return I1;
    }
}
class barcode{
    private long B1;
    public barcode(long B){
        this.B1 = B;
    }
    public long getbarcode(){
        return B1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of books: ");
        int N = sc.nextInt();
        System.out.print("Enter no. of racks: ");
        int K = sc.nextInt();
        Racks[] racks = new Racks[K];
        Books[] books = new Books[N];
        for(int i = 0;i<N;i++){
            sc.nextLine();
            System.out.println("Enter the title of book: ");
            String T = sc.nextLine();
            System.out.print("Enter the ISBN of book: ");
            long I = sc.nextLong();
            System.out.print("Enter the Barcode of book: ");
            long B = sc.nextLong();
            books[i] = new Books(T,I,B);
        }
        for(int i = 0;i<K;i++){
            racks[i] = new Racks(N/K);
        }
        books = sort(books);
        int j = 0;
        for(int i = 0;i< racks.length;i++){
            while(racks[i].getAvailable()){
                racks[i].setRack(books[j]);
                j+= 1;
            }
        }
        for(int i = 0;i< racks.length;i++){
            System.out.println("Rack"+(i+1));
            racks[i].display();
        }
    }
    public static Books[] sort(Books[] books){
        for(int i = 0;i<books.length;i++){
            for(int j = i;j<books.length;j++){
                CompareTitles c = new CompareTitles();
                int N = c.Compare(books[i].getTitle(),books[j].getTitle());
                if(N==1){
                    Books B = books[j];
                    books[j] = books[i];
                    books[i] = B;
                }
                if(N==-1){
                    continue;
                }
                if(N==0){
                    CompareISBN c1 = new CompareISBN();
                    int N1 = c1.Compare(books[i].getISBN(),books[j].getISBN());
                    if(N1==1){
                        Books B = books[j];
                        books[j] = books[i];
                        books[i] = B;
                    }
                    if(N1==-1){
                        continue;
                    }
                    if(N1==0){
                        Comparebarcode c2 = new Comparebarcode();
                        int N2 = c2.Compare(books[i].getBarcode(),books[j].getBarcode());
                        if(N2==1){
                            Books B = books[j];
                            books[j] = books[i];
                            books[i] = B;
                        }
                        if(N2==-1){
                            continue;
                        }
                    }
                }
            }
        }
        return books;
    }
}

