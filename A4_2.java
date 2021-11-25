import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

interface Matrix<T>{
    public String getId();
    public void display();
}
interface ComputeNegative<T>{
    public void Negative(T first);
}
class Negative implements  ComputeNegative{
    @Override
    public void Negative(Object first){
        if(first instanceof GrayscaleMatrix){
            int[][] arr1 = new int[((GrayscaleMatrix) first).getRows()][((GrayscaleMatrix) first).getColoumns()];
            for(int i= 0;i< ((GrayscaleMatrix) first).getRows();i++){
                for(int j = 0;j< ((GrayscaleMatrix) first).getColoumns();j++){
                    arr1[i][j] = 255-((GrayscaleMatrix) first).getMatrix()[i][j];
                }
            }
            System.out.println("Negative Grayscale Matrix");
            for(int i = 0;i< ((GrayscaleMatrix) first).getRows();i++){
                for(int j = 0;j< ((GrayscaleMatrix) first).getColoumns();j++){
                    System.out.print(arr1[i][j]+" |");
                }
                System.out.println();
            }
        }
        else if(first instanceof RGBMatrix){
            int[][] arr1 = new int[((RGBMatrix) first).getRows()][((RGBMatrix) first).getColoumns()];
            int[][] arr2 = new int[((RGBMatrix) first).getRows()][((RGBMatrix) first).getColoumns()];
            int[][] arr3 = new int[((RGBMatrix) first).getRows()][((RGBMatrix) first).getColoumns()];
            for(int i= 0;i< ((RGBMatrix) first).getRows();i++){
                for(int j = 0;j< ((RGBMatrix) first).getColoumns();j++){
                    arr1[i][j] = 255- ((RGBMatrix) first).getRedMatrix()[i][j];
                }
            }
            for(int i= 0;i< ((RGBMatrix) first).getRows();i++){
                for(int j = 0;j< ((RGBMatrix) first).getColoumns();j++){
                    arr2[i][j] = 255-((RGBMatrix) first).getRedMatrix()[i][j];
                }
            }
            for(int i= 0;i< ((RGBMatrix) first).getRows();i++){
                for(int j = 0;j< ((RGBMatrix) first).getColoumns();j++){
                    arr3[i][j] = 255-((RGBMatrix) first).getRedMatrix()[i][j];
                }
            }
            System.out.println("Negative Red Matrix");
            for(int i = 0;i< ((RGBMatrix) first).getRows();i++){
                for(int j = 0;j< ((RGBMatrix) first).getColoumns();j++){
                    System.out.print(arr1[i][j]+" |");
                }
                System.out.println();
            }
            System.out.println("Negative green Matrix");
            for(int i = 0;i< ((RGBMatrix) first).getRows();i++){
                for(int j = 0;j< ((RGBMatrix) first).getColoumns();j++){
                    System.out.print(arr2[i][j]+" |");
                }
                System.out.println();
            }
            System.out.println("Negative Blue Matrix");
            for(int i = 0;i< ((RGBMatrix) first).getRows();i++){
                for(int j = 0;j< ((RGBMatrix) first).getColoumns();j++){
                    System.out.print(arr3[i][j]+" |");
                }
                System.out.println();
            }
        }
    }
}
class GrayscaleMatrix implements Matrix{
    private int[][] Matrix;
    private int rows;
    private int coloumns;
    private String id;
    public GrayscaleMatrix(int[][] G, int r, int c, String i){
        this.Matrix = G;
        this.rows = r;
        this.coloumns = c;
        this.id = i;
    }
    @Override
    public String getId(){
        return this.id;
    }
    public void setMatrix(int r, int c, int elem){
        this.Matrix[r-1][c-1] = elem;
    }
    @Override
    public void display(){
        for(int i = 0;i<this.rows;i++){
            for(int j = 0;j<this.coloumns;j++){
                System.out.print(this.Matrix[i][j]+" |");
            }
            System.out.println();
        }
    }

    public int getRows(){
        return this.rows;
    }
    public int getColoumns(){
        return this.coloumns;
    }
    public int[][] getMatrix(){
        return this.Matrix;
    }
}
class RGBMatrix implements Matrix{
    private int[][] Red_Matrix;
    private int[][] Green_Matrix;
    private int[][] Blue_Matrix;
    private int rows;
    private int coloumns;
    private String id;
    public RGBMatrix(int[][] R, int[][] G, int[][] B, int r, int c, String i){
        this.Red_Matrix = R;
        this.Green_Matrix = G;
        this.Blue_Matrix = B;
        this.rows = r;
        this.coloumns = c;
        this.id = i;
    }
    @Override
    public String getId(){
        return this.id;
    }
    public void setRedMatrix(int r, int c, int elem){
        this.Red_Matrix[r-1][c-1] = elem;
    }
    public void setGreenMatrix(int r, int c, int elem){
        this.Green_Matrix[r-1][c-1] = elem;
    }
    public void setBlueMatrix(int r, int c, int elem){
        this.Blue_Matrix[r-1][c-1] = elem;
    }
    @Override
    public void display(){
        System.out.println("Red Matrix");
        for(int i = 0;i<this.rows;i++){
            for(int j = 0;j<this.coloumns;j++){
                System.out.print(this.Red_Matrix[i][j]+" |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Green Matrix");
        for(int i = 0;i<this.rows;i++){
            for(int j = 0;j<this.coloumns;j++){
                System.out.print(this.Green_Matrix[i][j]+" |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Blue Matrix");
        for(int i = 0;i<this.rows;i++){
            for(int j = 0;j<this.coloumns;j++){
                System.out.print(this.Blue_Matrix[i][j]+" |");
            }
            System.out.println();
        }
    }
    public int getRows(){
        return this.rows;
    }
    public int getColoumns(){
        return this.coloumns;
    }
    public int[][] getRedMatrix(){
        return this.Red_Matrix;
    }
    public int[][] getGreenMatrix(){
        return this.Green_Matrix;
    }
    public int[][] getBlueMatrix(){
        return this.Blue_Matrix;
    }
}
public class A4_2 {
    public static void main(String[] args){
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        ArrayList<Matrix> A = new ArrayList();
        while(flag){
            Menu();
            int n = sc.nextInt();
            if(n==1){
                System.out.println("1. Color Image");
                System.out.println("2. Grayscale Image");
                int n1 = sc.nextInt();
                if(n1==1){
                    System.out.println("Enter id: ");
                    String id = sc.next();
                    System.out.println("Enter Dimensions of RGB-Matrices");
                    System.out.println("Rows: ");
                    int N = sc.nextInt();
                    System.out.println("Coloumns: ");
                    int M = sc.nextInt();
                    int[][] arr = new int[N][M];
                    int[][] arr1 = new int[N][M];
                    int[][] arr2 = new int[N][M];
                    for(int i = 0;i<N;i++){
                        System.out.println("Enter elements of "+(i+1)+"th row of R-Matrix");
                        for(int j = 0;j<M;j++){
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    for(int i = 0;i<N;i++){
                        System.out.println("Enter elements of "+(i+1)+"th row of G-Matrix");
                        for(int j = 0;j<M;j++){
                            arr1[i][j] = sc.nextInt();
                        }
                    }
                    for(int i = 0;i<N;i++){
                        System.out.println("Enter elements of "+(i+1)+"th row of B-Matrix");
                        for(int j = 0;j<M;j++){
                            arr2[i][j] = sc.nextInt();
                        }
                    }
                    RGBMatrix RGB = new RGBMatrix(arr,arr1,arr2 ,N, M, id);
                    A.add(RGB);
                }
                if(n1==2){
                    System.out.println("Enter id: ");
                    String id = sc.next();
                    System.out.println("Enter Dimensions");
                    System.out.println("Rows: ");
                    int N = sc.nextInt();
                    System.out.println("Coloumns: ");
                    int M = sc.nextInt();
                    int[][] arr = new int[N][M];
                    for(int i = 0;i<N;i++){
                        System.out.println("Enter elements of "+(i+1)+"th row");
                        for(int j = 0;j<M;j++){
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    GrayscaleMatrix G = new GrayscaleMatrix(arr, N, M, id);
                    A.add(G);
                }
            }
            if(n==3){
                System.out.println("Enter id: ");
                String id = sc.next();
                Matrix m = null;
                for(int i = 0;i<A.size();i++){
                    if(A.get(i).getId().equals(id)){
                        m = A.get(i);
                    }
                }
                if(m!=null){
                    if(m instanceof GrayscaleMatrix){
                        System.out.println("Enter the row of the element to be updated: ");
                        int r = sc.nextInt();
                        System.out.println("Enter the coloumn of the element to be updated: ");
                        int c = sc.nextInt();
                        System.out.println("Enter the element to be updated with: ");
                        int elem = sc.nextInt();
                        ((GrayscaleMatrix) m).setMatrix(r,c,elem);
                        System.out.println("Element updated");
                    }
                    else if(m instanceof RGBMatrix){
                        System.out.println("Select which Matrix needs to be updated: ");
                        System.out.println("1. Red-Matrix");
                        System.out.println("2. Green-Matrix");
                        System.out.println("3. Blue-Matrix");
                        int x = sc.nextInt();
                        if(x==1){
                            System.out.println("Enter the row of the element to be updated: ");
                            int r = sc.nextInt();
                            System.out.println("Enter the coloumn of the element to be updated: ");
                            int c = sc.nextInt();
                            System.out.println("Enter the element to be updated with: ");
                            int elem = sc.nextInt();
                            ((RGBMatrix) m).setRedMatrix(r,c,elem);
                            System.out.println("Element updated");
                        }
                        if(x==2){
                            System.out.println("Enter the row of the element to be updated: ");
                            int r = sc.nextInt();
                            System.out.println("Enter the coloumn of the element to be updated: ");
                            int c = sc.nextInt();
                            System.out.println("Enter the element to be updated with: ");
                            int elem = sc.nextInt();
                            ((RGBMatrix) m).setGreenMatrix(r,c,elem);
                            System.out.println("Element updated");
                        }
                        if(x==3){
                            System.out.println("Enter the row of the element to be updated: ");
                            int r = sc.nextInt();
                            System.out.println("Enter the coloumn of the element to be updated: ");
                            int c = sc.nextInt();
                            System.out.println("Enter the element to be updated with: ");
                            int elem = sc.nextInt();
                            ((RGBMatrix) m).setBlueMatrix(r,c,elem);
                            System.out.println("Element updated");
                        }
                    }
                }
            }
            if(n==4){
                System.out.println("Enter id: ");
                String id = sc.next();
                Matrix m = null;
                for(int i = 0;i<A.size();i++){
                    if(A.get(i).getId().equals(id)){
                        m = A.get(i);
                    }
                }
                if(m!=null){
                    m.display();
                }
            }
            if(n==5){
                System.out.println("Enter id: ");
                String id = sc.next();
                Matrix m = null;
                for(int i = 0;i<A.size();i++){
                    if(A.get(i).getId().equals(id)){
                        m = A.get(i);
                    }
                }
                if(m!=null){
                    Negative Neg = new Negative();
                    Neg.Negative(m);
                }
            }
            if(n==6){
                flag = false;
            }
        }
    }
    public static void Menu(){
        System.out.println("----------------");
        System.out.println("1.Input Matrices");
        System.out.println("2.Create Matrices");
        System.out.println("3.Update Matrices");
        System.out.println("4.Display Matrices");
        System.out.println("5.Compute Negatives");
        System.out.println("6. Exit");
    }
}