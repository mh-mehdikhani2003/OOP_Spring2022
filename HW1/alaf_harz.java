import java.util.Scanner;

public class alaf_harz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m= sc.nextInt();
        int k=sc.nextInt();
        int[][] plant_farm=new int [n][m];
        int[][] energy_farm=new int [n][m];
        boolean tagheer=true;
        int temp=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                energy_farm[i][j]=sc.nextInt();
                plant_farm[i][j]=0;
            }
        }
        int i1,j1;
        for(int i=0;i<k;i++){
            i1=sc.nextInt();
            j1= sc.nextInt();
            plant_farm[i1][j1]++;
        }
        while (tagheer){
            tagheer=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(energy_farm[i][(j+1)%m]+energy_farm[(i+1)%n][j]<energy_farm[i][j]){
                        energy_farm[i][j]=energy_farm[i][(j+1)%m]+energy_farm[(i+1)%n][j];
                        tagheer=true;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp+=plant_farm[i][j]*energy_farm[i][j];
            }
        }
        System.out.println(temp);
    }
}
