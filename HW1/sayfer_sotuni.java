import java.util.Scanner;
 class sayfer_sotuni {
     static void Moratab(char [] a)
     {
         char temp;
         for(int i=0;i<a.length;i++)
         {
             for(int j=0;j<a.length-1;j++)
             {
                 if(a[j]>a[j+1]){temp=a[j];a[j]=a[j+1];a[j+1]=temp;}
             }
         }
     }
    static void payam (String messege,String Key)
    {
        String eslah_messege="";
        messege = messege.toLowerCase();

        for (int i=0;i<messege.length();i++)
        {

            if(!(messege.charAt(i) > 96  && messege.charAt(i)<=122)) {
                eslah_messege = messege.substring(i, i + 1);
                messege = messege.replace(eslah_messege, "");
                i--;
            }
        }
        Key=Key.toLowerCase();
        char [] Key_sequenced;Key_sequenced=Key.toCharArray();
        Moratab(Key_sequenced);
        char[][] Locked= new char[Key.length()][(int)(messege.length()/Key.length())+1];
        int shomarande=0;
        for(int i=0;i<(int)(messege.length()/Key.length())+1;i++){
            for(int j=0;j<Key.length();j++){
                if(shomarande<messege.length()) {
                    Locked[j][i] = messege.charAt(shomarande);
                    shomarande++;
                }
                else{
                    Locked[j][i]='x';
                }
            }
        }
        int[] index_sequence=new int [Key.length()];
        for(int i=0;i< Key_sequenced.length;i++){
            for(int j=0;j<Key.length();j++){
                if(Key_sequenced[i]==Key.charAt(j)){
                    index_sequence[i]=j;break;
                }
            }
        }
        for(int i=0;i<Key.length();i++){
            for(int j=0;j<(int)(messege.length()/Key.length())+1;j++){
                System.out.print(Locked[index_sequence[i]][j]);
            }
        }
    }
    static void Ramz(String messege,String Key)
    {
        char[][] messege_locked= new char [Key.length()][(int)(messege.length()/Key.length())];
        int shomarande =0;
        for(int i=0;i<Key.length();i++){
            for(int j=0;j<messege.length()/ Key.length();j++){
                messege_locked[i][j]=messege.charAt(shomarande);shomarande++;
            }
        }
        char [] Key_sequenced;Key_sequenced=Key.toCharArray();
        Moratab(Key_sequenced);
        int[] index_sequence=new int [Key.length()];
        for(int i=0;i< Key_sequenced.length;i++){
            for(int j=0;j<Key.length();j++){
                if(Key_sequenced[i]==Key.charAt(j)){
                    index_sequence[i]=j;break;
                }
            }
        }
        char[][] decoded_messege= new char [Key.length()][(int)(messege.length()/Key.length())];
        for (int i=0;i<Key.length();i++){
            for(int j=0;j<messege.length()/Key.length();j++){
                decoded_messege[index_sequence[i]][j] = messege_locked[i][j];
            }
        }
        for(int j=0;j<messege.length()/Key.length();j++){
            for(int i=0;i<Key.length();i++){
                System.out.print(decoded_messege[i][j]);
            }
        }
    }
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        String messege="",Key="";
        messege = sc.nextLine();
        Key = sc.nextLine();
        boolean ramz =true;
        for(int i=0;i<messege.length();i++)
        {
            if(messege.charAt(i)==' '){ramz=false;break;}
        }
        if(ramz)
        {
            Ramz(messege,Key);
        }
        else
        {
            payam(messege, Key);
        }
        sc.close();
    }
}
