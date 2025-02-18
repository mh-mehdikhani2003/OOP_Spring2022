import java.util.Scanner;
public class kambiz {
static  void SWAP (int A[],int b,int a)
{
    int temp=A[a];
    A[a]=A[b];
    A[b]=temp;
}
static void QUICK_SORT (int A[],int i1,int i2)
{
    if(i2-i1>0){
    int pivot=A[i1];
    int bigger=0,smaller_equal=0;
    for(int i=i1;i<=i2;i++)
    {
        if(A[i]>pivot){bigger++;}
    }
     for(int i=i1;i<=i2;i++)
    {
        if(A[i]<=pivot){smaller_equal++;}
    }
    smaller_equal--;
    SWAP (A,i1,i1+smaller_equal);
    int komak_smaller=i1;
    
    for(int i=i1;i<=i2;i++)
    {
        if(i==(i1+smaller_equal)){continue;}
        if(A[i]<=pivot)
        {
            if(i!=komak_smaller )
            {
                SWAP (A,i,komak_smaller);
            }
            komak_smaller++;
        }
    }
    QUICK_SORT(A,i1,i1+smaller_equal-1);
    QUICK_SORT(A,smaller_equal+i1+1,i2);
    }
}
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] stores= new int [n];
        boolean [] used_stores=new boolean[n];
        for(int i=0;i<n;i++)
        {
            used_stores[i]=false;
        }
        for(int i=0;i<n;i++)
        {
            stores[i]=sc.nextInt();
        }
        QUICK_SORT(stores, 0, n-1 );
        int time=0,kambiz=0;
        for(int i=0;i<n;i++)
        {
            if(time<stores[i])
            {
                kambiz+=1;
                time+=1;
                used_stores[i]=true;
            }
        }
        System.out.println(kambiz);
        sc.close();
    }
}
