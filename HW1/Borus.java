import java.util.Scanner;
public class man {
    static int max(int array[], int size)
    {
        int maximum_current= array[0];
        int since_now_maximum =array[0];
        for (int i=1;i<size;i++) {
            maximum_current=Math.max(array[i],maximum_current+array[i]);
            since_now_maximum=Math.max(since_now_maximum,maximum_current);
        }
        return since_now_maximum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int [] numbers=new int [n];
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
        }
        System.out.println(max(numbers, n));
        sc.close();
    }

}
