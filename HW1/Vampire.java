import java.util.Scanner;
import java.lang.Math;
public class man {
    static String omit (String main,String vamp){
        String eslah="";
        for(int i=0;i<vamp.length();i++){
            for(int j=0;j<main.length();j++){
                if(vamp.charAt(i)==main.charAt(j)){
                    eslah=main.substring(j,j+1);
                    main=main.replaceFirst(eslah,"");
                    break;
                }
            }
        }
        return main;
    }
    static boolean check(String major,String vampire){
        boolean temp=false;
        boolean gavab=true;
        for (int j=0;j<vampire.length();j++){
            temp=false;
            for(int i=0;i<major.length();i++){
                if(major.charAt(i)==vampire.charAt(j)){
                    temp=true;break;
                }
            }
            if(temp==false){
                gavab=false;break;
            }
        }
        return gavab;
    }
   static boolean check_vampire (String mesal){
        int vampire =Integer.parseInt(mesal);
        String vampire_delete="";
        int tedad_ragham=mesal.length()/2;
        int sting1=(int)(Math.pow(10, tedad_ragham-1));
        int sting2=0;
        while(sting1<Math.pow(10, tedad_ragham)){
         if(vampire%sting1==0){
             if(check(mesal,Integer.toString(sting1))){
                 sting2=vampire/sting1;
                 if(Integer.toString(sting2).length()==mesal.length()-tedad_ragham){
                     vampire_delete=omit(mesal,Integer.toString(sting1));
                     if(check(vampire_delete,Integer.toString(sting2))){
                         if(!(sting1%10==0 && sting2%10==0)){
                             return true;
                         }
                     }
                 }

             }
         }
         sting1++;
        }
        return false;
    }
    static  boolean tekrari_check(int[] arr,int count,int vamp){
        boolean gavab=false;
        if(count>=1){
            for(int i=0;i<count;i++){
                if(arr[i]==vamp){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n =sc.nextLine();
        int longness=((n.length()+1)*(n.length()))/2;
        String [] gens_vampire=new String[longness];
        int [] vampires=new int [longness];
        String zir_reshte="";
        int count=0,temp=0;
        String tempelton="";
        for(int i=0;i<n.length();i++){
            for(int j=i+1;j<=n.length();j++){
                zir_reshte=n.substring(i,j);
                if(zir_reshte.length()>=3) {
                    if (check_vampire(zir_reshte)) {
                        if(!tekrari_check(vampires,count,Integer.parseInt(zir_reshte))){
                            if (zir_reshte.length() % 2 == 0) {
                                gens_vampire[count] = "t";
                                vampires[count] = Integer.parseInt(zir_reshte);
                                count++;
                            }
                            if (zir_reshte.length() % 2 != 0) {
                                gens_vampire[count] = "p";
                                vampires[count] = Integer.parseInt(zir_reshte);
                                count++;
                            }
                        }

                    }
                }
            }
        }
        if(count!=0) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count-i-1; j++) {
                    if (vampires[j ] > vampires[j+1]) {
                        temp = vampires[j];
                        vampires[j] = vampires[j +1];
                        vampires[j +1] = temp;
                        tempelton = gens_vampire[j];
                        gens_vampire[j] = gens_vampire[j + 1];
                        gens_vampire[j +1] = tempelton;
                    }
                }
            }
            for (int i = 0; i < count; i++) {
                System.out.print(vampires[i]);
                if (gens_vampire[i].equals("t")){
                    System.out.println(" True Vampire");
                }
                if(gens_vampire[i].equals("p")){
                    System.out.println(" Pseudovampire");
                }
            }
        }
        else{
            System.out.println("No Vampires");
        }
        sc.close();
    }

}
