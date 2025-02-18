import java.util.Scanner;

public class body_building {
    public static int i_stop=0;
    static long calculating (int [] arr,int[] li,int [] ri,int k){
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                k=i+1;break;
            }
        }
        long sum=0;
        int min=ri[arr[0]];
        for(int i=1;i<k;i++){
            if(min>ri[arr[i]]){
                min=ri[arr[i]];
            }
        }
        for(int i=0;i<k;i++){
            sum+=li[arr[i]];
        }
        return sum*min;
    }
    static int []  attractiveness (int[] li,int[] ri,int n,int k ,int [] indexes) {
        long max = 0;
        int previous = -1;
        if (k == 1) {
            indexes[k - 1] = 0;
            previous = 0;
            max = calculating(indexes, li, ri, 1);
            for (int i = 1; i < n; i++) {
                indexes[k - 1] = i;
                if (max < calculating(indexes, li, ri, k)) {
                    previous = i;
                    max = calculating(indexes, li, ri, k);
                } else {
                    indexes[k - 1] = previous;
                }
            }
            return indexes;
        } else {
            indexes = attractiveness(li, ri, n, k - 1, indexes);
            previous = 0;
            if (i_stop == 0) {
                max = calculating(indexes, li, ri, k - 1);
                boolean ghabli_badi = false;
                boolean tekrary = false;
                for (int i = 0; i < n; i++) {
                    tekrary = false;
                    for (int j = 0; j < k - 1; j++) {
                        if (i == indexes[j]) {
                            tekrary = true;
                            break;
                        }
                    }
                    if (tekrary == false) {
                        indexes[k - 1] = i;
                        if (max < calculating(indexes, li, ri, k)) {
                            ghabli_badi = true;
                            previous = i;
                            max = calculating(indexes, li, ri, k);
                        } else {
                            indexes[k - 1] = previous;
                        }
                    }
                }
                if (ghabli_badi == true) {
                    return indexes;
                } else {
                    i_stop = k - 1;
                    return attractiveness(li, ri, n, k - 1, indexes);
                }
            }
            else {
                return indexes;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int [] li=new int [n];
        int [] ri=new int [n];
        int [] indexes =new int [k];
        for(int i=0;i<n;i++){
            li[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            ri[i]=sc.nextInt();
        }
        indexes=attractiveness(li,ri,n,k,indexes);
        System.out.println(calculating(indexes,li,ri,i_stop));
    }
}