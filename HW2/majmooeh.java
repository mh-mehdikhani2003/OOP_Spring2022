import java.util.ArrayList;
import java.util.Scanner;
import java. lang. Math;
public class majmooeh {
    public static String paper="";
    public static ArrayList<String> sets = new ArrayList<String>();
    public static ArrayList<ArrayList<Integer> > x = new ArrayList<ArrayList<Integer> >();
   // public static ArrayList<Integer> A=new ArrayList<Integer>();
   // public static ArrayList<Integer> B=new ArrayList<Integer>();
    static ArrayList<Integer> minus(ArrayList<Integer> first,ArrayList<Integer> second){
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<Integer> B=new ArrayList<Integer>();
        ArrayList<Integer> C=new ArrayList<Integer>();
        boolean rost=false;
        for (int i = 0; i < first.size(); i++) {
            A.add(first.get(i));
        }
        for (int i = 0; i < second.size(); i++) {
            B.add(second.get(i));
        }
        for (int i = 0; i < A.size(); i++) {
            rost=false;
            for (int i1 = 0; i1 < B.size(); i1++) {
                if(A.get(i)==B.get(i1)){
                    rost=true;
                }
            }
            if(!rost){
                C.add(A.get(i));
            }
        }
        return C;
    }
    static ArrayList<Integer> unify (ArrayList<Integer> first,ArrayList<Integer> second){
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<Integer> B=new ArrayList<Integer>();
        for (int i = 0; i < first.size(); i++) {
            A.add(first.get(i));
        }
        for (int i = 0; i < second.size(); i++) {
            B.add(second.get(i));
        }
        A=minus(A,B);
        for (int i = 0; i < B.size(); i++) {
            A.add(B.get(i));
        }
        return A;
    }
    static ArrayList<Integer> eshterak (ArrayList<Integer> first,ArrayList<Integer> second){
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<Integer> B=new ArrayList<Integer>();
        ArrayList<Integer> C=new ArrayList<Integer>();
        for (int i = 0; i < first.size(); i++) {
            A.add(first.get(i));
        }
        for (int i = 0; i < second.size(); i++) {
            B.add(second.get(i));
        }
        for (int i = 0; i < A.size(); i++) {
            for (int i1 = 0; i1 < B.size(); i1++) {
                if(A.get(i)==B.get(i1)){
                    C.add(A.get(i));
                }
            }
        }
        return C;
    }
    static void printSubsets(int  set[]) {
        int n = set.length;
        String ans="";
        for (int i = 0; i < (1<<n); i++)
        {
            ans="{";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    ans += Integer.toString(set[j]) + ",";
                }
            }
            if(ans.length()>1) {
                ans = ans.substring(0, ans.length() - 1);
            }
            ans+="}";
            System.out.println(ans);
        }
    }
    static void subset (String sample){
        String name=sample.substring(sample.length()-1,sample.length());
        int index=-1;
        for(int i=0;i<sets.size();i++){
            if(sets.get(i).equals(name)){
                index=i;break;
            }
        }
        if(index<0){
            System.out.println(name+" is not defined");return;
        }
        int[]arr=new int[x.get(index).size()];
        for(int i=0;i<x.get(index).size();i++){
            arr[i]=x.get(index).get(i);
        }
       printSubsets (arr);
            arr=null;
    }
    static ArrayList<Integer> algebra (String sample){
        int index_left=-1,index_right=-1,index_min=0;
        int counter=0;
        for(int i=1;i<sample.length()-1;i++){
            if(sample.charAt(i)=='('){
                counter++;
            }
            if(sample.charAt(i)==')'){
                counter--;
            }
            if(sample.charAt(i)=='+' && counter==0){
                if(sample.substring(1,i).length()==1  && sample.substring(i+1,sample.length()-1).length()==1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(1,i).equals(sets.get(i1))){
                            index_left=i1;
                        }
                        if(sample.substring(i+1,sample.length()-1).equals(sets.get(i1))) {
                            index_right=i1;
                        }
                        if(index_right>=0 && index_left>=0){
                            return   unify(x.get(index_left),x.get(index_right));
                        }
                    }

                }
            }
            if(sample.charAt(i)=='-' && counter==0){
                if(sample.substring(1,i).length()==1  && sample.substring(i+1,sample.length()-1).length()==1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(1,i).equals(sets.get(i1))){
                            index_left=i1;
                        }
                        if(sample.substring(i+1,sample.length()-1).equals(sets.get(i1))) {
                            index_right=i1;
                        }
                        if(index_right>=0 && index_left>=0){
                            return minus(x.get(index_left),x.get(index_right));
                        }
                    }

                }
            }
            if(sample.charAt(i)=='*' && counter==0){
                if(sample.substring(1,i).length()==1  && sample.substring(i+1,sample.length()-1).length()==1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(1,i).equals(sets.get(i1))){
                            index_left=i1;
                        }
                        if(sample.substring(i+1,sample.length()-1).equals(sets.get(i1))) {
                            index_right=i1;
                        }
                        if(index_right>=0 && index_left>=0){
                            return  eshterak(x.get(index_left),x.get(index_right));
                        }
                    }

                }
            }
            if(sample.charAt(i)=='+' && counter==0){
                if(sample.substring(1,i).length()==1  && sample.substring(i+1,sample.length()-1).length()!=1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(1,i).equals(sets.get(i1))){
                            index_left=i1;
                        }
                        if( index_left>=0){
                            return   unify(x.get(index_left),algebra(sample.substring(i+1,sample.length()-1)));
                        }
                    }
                }
            }
            if(sample.charAt(i)=='-' && counter==0){
                if(sample.substring(1,i).length()==1  && sample.substring(i+1,sample.length()-1).length()!=1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(1,i).equals(sets.get(i1))){
                            index_left=i1;
                        }
                        if( index_left>=0){
                            return   minus(x.get(index_left),algebra(sample.substring(i+1,sample.length()-1)));
                        }
                    }
                }
            }
            if(sample.charAt(i)=='*' && counter==0){
                if(sample.substring(1,i).length()==1  && sample.substring(i+1,sample.length()-1).length()!=1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(1,i).equals(sets.get(i1))){
                            index_left=i1;
                        }
                        if( index_left>=0){
                            return  eshterak(x.get(index_left),algebra(sample.substring(i+1,sample.length()-1)));
                        }
                    }
                }
            }
            if(sample.charAt(i)=='+' && counter==0){
                if(sample.substring(1,i).length()!=1  && sample.substring(i+1,sample.length()-1).length()==1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(i+1,sample.length()-1).equals(sets.get(i1))) {
                            index_right=i1;
                        }
                        if( index_right>=0){
                            return   unify(algebra(sample.substring(1,i)),x.get(index_right));
                        }
                    }
                }
            }
            if(sample.charAt(i)=='-' && counter==0){
                if(sample.substring(1,i).length()!=1  && sample.substring(i+1,sample.length()-1).length()==1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(i+1,sample.length()-1).equals(sets.get(i1))) {
                            index_right=i1;
                        }
                        if( index_right>=0){
                            return   minus(algebra(sample.substring(1,i)),x.get(index_right));
                        }
                    }
                }
            }
            if(sample.charAt(i)=='*' && counter==0){
                if(sample.substring(1,i).length()!=1  && sample.substring(i+1,sample.length()-1).length()==1){
                    for (int i1 = 0; i1 < sets.size(); i1++) {
                        if(sample.substring(i+1,sample.length()-1).equals(sets.get(i1))) {
                            index_right=i1;
                        }
                        if( index_right>=0){
                            return   eshterak(algebra(sample.substring(1,i)),x.get(index_right));
                        }
                    }
                }
            }
            if(sample.charAt(i)=='+' && counter==0){
                if(sample.substring(1,i).length()!=1  && sample.substring(i+1,sample.length()-1).length()!=1){
                    return   unify(algebra(sample.substring(1,i)),algebra(sample.substring(i+1,sample.length()-1)));
                }
            }
            if(sample.charAt(i)=='-' && counter==0){
                if(sample.substring(1,i).length()!=1  && sample.substring(i+1,sample.length()-1).length()!=1){
                    return   minus(algebra(sample.substring(1,i)),algebra(sample.substring(i+1,sample.length()-1)));
                }
            }
            if(sample.charAt(i)=='*' && counter==0){
                if(sample.substring(1,i).length()!=1  && sample.substring(i+1,sample.length()-1).length()!=1){
                    index_min=i;
                }
            }
        }
        return eshterak(algebra(sample.substring(1,index_min)),algebra(sample.substring(index_min+1,sample.length()-1)));
    }
    static void add (String sample){
        sample=sample.replaceAll(" ","");
        String name=sample.substring(sample.length()-1,sample.length());
        int number=Integer.parseInt(sample.substring(3,sample.length()-3)),index_set=-1;
        boolean set_existance=false;
        boolean number_existance=false;
        for (int i=0;i<sets.size();i++){
            if(sets.get(i).equals(name)){
                set_existance=true;index_set=i;break;
            }
        }
        for(int j=0;set_existance==true &&j<x.get(index_set).size();j++){
            if(x.get(index_set).get(j)==number){
                number_existance=true;
            }
        }
        if(set_existance==false){
            System.out.println(name+" is not defined");
        }
        if(set_existance==true && number_existance==false){
            x.get(index_set).add(x.get(index_set).size(),number);
            System.out.println("added successfully");
        }
        if(set_existance==true &&  number_existance==true){
            System.out.println(number+" is already in "+name);
        }
    }
    static void complicated_things (String sample){
        boolean check=false;
        sample=sample.replaceAll(" ","");
        for(int i=2;i<sample.length();i++){
            if(sample.charAt(i)>=65 && sample.charAt(i)<=90){
                check=false;
                for (int j=0;j<sets.size();j++){
                    if(sample.substring(i,i+1).equals(sets.get(j))){
                        check=true;break;
                    }
                }
                if(check==false){
                    System.out.println("some sets are not defined");return;
                }
            }
        }
        ArrayList<Integer> pokh=new ArrayList<>();
        pokh=algebra("("+sample.substring(2,sample.length())+")");
        String set="={";
        for (int i = 0; i < pokh.size()-1; i++) {
            set+=Integer.toString(pokh.get(i))+",";
        }
        if(pokh.size()>=1) {
            set += Integer.toString(pokh.get(pokh.size() - 1));
        }
        set=set+"}.";
        definition(sample.substring(0,1)+set);
    }
    static void print (String sample){
        int temp=0,index=-1;
        for(int i=0;i< sets.size();i++){
            if(sets.get(i).equals(sample.substring(sample.length()-1,sample.length()))){
                index=i;break;
            }
        }
        if(index<0){
            System.out.println(sample.substring(sample.length()-1,sample.length())+" is not defined");return;
        }
        for(int i=0;i<x.get(index).size();i++){
            for(int j=0;j<x.get(index).size()-1;j++){
                if(x.get(index).get(j)>x.get(index).get(j+1)){
                    temp=x.get(index).get(j);
                    x.get(index).set(j,x.get(index).get(j+1));
                    x.get(index).set(j+1,temp);
                }
            }
        }
        System.out.print(sets.get(index)+" = {");
        for(int i=0;i<x.get(index).size()-1;i++){
            System.out.print(x.get(index).get(i)+",");
        }
        if(x.get(index).size()>0) {
            System.out.print(x.get(index).get(x.get(index).size() - 1));
        }
        System.out.println("}");
    }
    static void definition (String sample){
        boolean print=true;
        if(sample.charAt(sample.length()-1)=='.'){
            print=false;
            sample=sample.substring(0,sample.length()-1);
        }
        int counter=0;
        boolean tagheer=false;
        sample=sample.replaceAll(" ","");
        for(int i=0;i< sets.size();i++){
            if(sample.substring(0,1).equals(sets.get(i))){
                sets.remove(i);
                x.remove(i);
                tagheer=true;break;
            }
        }
        sets.add(sample.substring(0,1));
        x.add(new ArrayList<Integer>());
        if(sample.length()>4) {
            sample = sample.substring(3, sample.length());
            sample = sample.replace("}", ",");
            paper = sample.substring(0, sample.indexOf(","));
            while (sample.length() != paper.length() + 1) {
                sample = sample.substring(paper.length() + 1, sample.length());
                x.get(sets.size() - 1).add(counter, Integer.parseInt(paper));
                counter++;
                paper = sample.substring(0, sample.indexOf(","));
            }
            paper = sample.substring(0, sample.indexOf(","));
            x.get(sets.size() - 1).add(counter, Integer.parseInt(paper));
            counter++;
            for (int i = 0; i < counter; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (x.get(sets.size() - 1).get(i) == x.get(sets.size() - 1).get(j)) {
                        x.get(sets.size() - 1).remove(i);
                        i--;
                        counter--;
                        break;
                    }
                }
            }
        }
        if(tagheer && print){
            System.out.println("set updated successfully");
        }
        if(!tagheer  && print ) {
            System.out.println("set created successfully");
        }
    }
    static void simple_things (String sample){
        String ans=sample.substring(0,1);
        String first=sample.substring(4,5);
        String sign=sample.substring(5,6);
        String sec=sample.substring(6,7);
        int index_first=-1,index_sec=-1;
        for(int i=0;i<sets.size();i++){
            if(sets.get(i).equals(first)){
                index_first=i;
            }
            if(sets.get(i).equals(sec)){
                index_sec=i;
            }
        }
        if(index_first<0 || index_sec<0){
            System.out.println("some sets are not defined");return;
        }
        if(sign.equals("*")){

            for(int i=0;i<x.get(index_first).size();i++){
                for(int j=0;j<x.get(index_sec).size();j++){
                    if(x.get(index_first).get(i)==x.get(index_sec).get(j)){
                        sign+=Integer.toString(x.get(index_first).get(i))+",";
                    }
                }
            }
            sign = sign.substring(0, sign.length() - 1);
            if(sign.contains("*")){
                sign = sign.substring(1, sign.length());
            }
            definition(ans+"={"+sign+"}.");
        }
        if(sign.equals("+")){

            for(int j=0;j<x.get(index_sec).size();j++){
                sign+=Integer.toString(x.get(index_sec).get(j))+",";
            }
            for(int i=0;i<x.get(index_first).size();i++){
                sign+=Integer.toString(x.get(index_first).get(i))+",";
            }
            sign = sign.substring(0, sign.length() - 1);
            if(sign.contains("+")){
                sign = sign.substring(1, sign.length());
            }
            definition(ans+"={"+sign+"}.");
        }  if(sign.equals("-")){
            boolean rost=false;
            for(int i=0;i<x.get(index_first).size();i++){
                rost=false;
                for(int j=0;j<x.get(index_sec).size()&&rost==false;j++){
                    if(x.get(index_first).get(i)==x.get(index_sec).get(j)){
                        rost=true;
                    }
                }
                if(rost==false){
                    sign+=Integer.toString(x.get(index_first).get(i))+",";
                }
            }
            sign = sign.substring(0, sign.length() - 1);
            if(sign.contains("-")){
                sign = sign.substring(1, sign.length());
            }
            definition(ans+"={"+sign+"}.");
        }
    }
    static void menu (String sample ){
        if(sample.contains("{")){
            definition(sample);
        }
        if(sample.contains("print")){
            print(sample);
        }
        if(sample.contains("add")){
            add(sample);
        }
        if(sample.contains("subsets")){
            subset(sample);
        }
        if((sample.contains("+") || sample.contains("*")|| sample.contains("-"))&& !sample.contains("(")){
            simple_things(sample);
        }
        if(sample.contains("(")){
            complicated_things(sample);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Input=sc.nextLine();
        while (!Input.equals("end")){
            menu(Input);
            Input=sc.nextLine();
        }
        sc.close();
    }
}
