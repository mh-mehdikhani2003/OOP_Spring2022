import java.util.Scanner;

public class Rain {
    public static long rain=0;
    static void baran(int array[],int a,int b)
    {
        int index_max_main=a,index_max_right=a,index_max_left=a;
        boolean right=false;
        boolean left=false;
        for(int i=a;i<=b;i++)
        {
            if(array[index_max_main]<array[i]){index_max_main=i;}
        }
        if(index_max_main!=a) {
            left = true;

            for (int i = a; i < index_max_main; i++) {
                if (array[index_max_left] < array[i]) {
                    index_max_left = i;
                }
            }
        }
        if(index_max_main!=b) {
            right = true;
            index_max_right=b;
            for (int i = b; i > index_max_main; i--) {
                if (array[index_max_right] < array[i]) {
                    index_max_right = i;
                }
            }
        }
        if(right)
        {
            int h_right=array[index_max_right];
            for(int i=index_max_main+1;i<index_max_right;i++)
            {
                rain+=(h_right-array[i]);
            }
        }
        if(left)
        {
            int h_left=array[index_max_left];
            for(int i=index_max_main-1;i>index_max_left;i--)
            {
                rain+=(h_left-array[i]);
            }
        }
        if(right && index_max_right!=b)
        {
            baran(array, index_max_right,b );
        }
        if(left && index_max_left!=a)
        {
            baran(array, a,index_max_left );
        }
    }
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int [] a= new int [n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
            
        }
        baran(a, 0, n-1);
        System.out.println(rain);
        sc.close();
    }
    
}