import java.util.ArrayList;

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
class InputProcessor {
    Scanner scanner=new Scanner(System.in);
    Manager manager=new Manager();

    //passing to the right method based by starting
    public void start(){
        String input=scanner.nextLine();
        while(!input.equals("end")){
            if(input.startsWith("CREATE TABLE")){
                proses_CREATE_TABLE(input.split("\\s"));
            }else if(input.startsWith("DROP TABLE")){
                proses_DROP_TABLE(input.split("\\s"));
            }else if(input.startsWith("INSERT INTO")){
                proses_INSERT_INTO(input.split("\\s"));
            }else if(input.startsWith("SELECT")){
                proses_SELECT(input.split("\\s"));
            }else if(input.startsWith("DELETE")){
                proses_DELETE(input.split("\\s"));
            }else if(input.startsWith("UPDATE")){
                proses_UPDATE(input.split("\\s"));
            }else if(input.startsWith("show tables")){
                proses_show_tables(input.split("\\s"));
            }
            input= scanner.nextLine();
        }
    }
    //anything that starts with select
    private void proses_SELECT(String[] split_input){
        Table temp_table;
        if (split_input.length > 4){
            temp_table= manager.SELECT(split_input[3].substring(0,split_input[3].length()));
        }else {
            temp_table= manager.SELECT(split_input[3].substring(0,split_input[3].length()-1));
        }


        if(temp_table!=null) {
            ArrayList<String> temp_column_names = temp_table.getColumn_names();
            ArrayList<Record> temp_records = temp_table.getRecords();
            ArrayList<String> fields;
            if (temp_records.size() != 0) {
                //firs type printing all of table
                if (split_input[1].equals("*")) {
                    if (split_input.length > 4) {

                        String wanted_column = split_input[5];
                        String wanted_field = split_input[7].substring(1, split_input[7].length() - 2);
                        int index_wanted_field = -1;
                        for (int i = 0; i < temp_column_names.size(); i++) {
                            if (temp_column_names.get(i).equals(wanted_column)) {
                                index_wanted_field = i;
                                break;
                            }
                        }
                        //new
                        if(index_wanted_field>=0) {
                            boolean WHERE = false;
                            for (Record record : temp_records) {
                                fields = record.getFields();
                                if (fields.get(index_wanted_field).equals(wanted_field)) {
                                    WHERE = true;
                                    break;
                                }
                            }
                            if (WHERE) {
                                for (int i = 0; i < temp_column_names.size() - 1; i++) {
                                    System.out.print(temp_column_names.get(i) + " | ");
                                }
                                System.out.println(temp_column_names.get(temp_column_names.size() - 1));
                                //printed column names
                                for (Record record : temp_records) {
                                    fields = record.getFields();
                                    if (fields.get(index_wanted_field).equals(wanted_field)) {
                                        for (int i = 0; i < fields.size() - 1; i++) {
                                            System.out.print(fields.get(i) + " | ");
                                        }
                                        System.out.println(fields.get(fields.size() - 1));
                                    }
                                }
                                //printed fields
                            } else {
                                System.out.println("No result.");
                            }
                        }else {
                            System.out.println("ERROR!");
                        }
                    } else {
                        for (int i = 0; i < temp_column_names.size() - 1; i++) {
                            System.out.print(temp_column_names.get(i) + " | ");
                        }
                        System.out.println(temp_column_names.get(temp_column_names.size() - 1));
                        //printed column names
                        for (Record record : temp_records) {
                            fields = record.getFields();
                            for (int i = 0; i < fields.size() - 1; i++) {
                                System.out.print(fields.get(i) + " | ");
                            }
                            System.out.println(fields.get(fields.size() - 1));
                            //printed fields
                        }
                    }
                }
                //second type printing some columns of a table
                if (!split_input[1].equals("*")) {
                    boolean existence;
                    String[] columns_wanted = split_input[1].split(",");
                    for (String s : columns_wanted) {
                        existence = false;
                        for (String name : temp_column_names) {
                            if (s.equals(name)) {
                                existence = true;
                                break;
                            }
                        }
                        if (!existence) {
                            System.out.println("ERROR!");
                            return;
                        }
                    }
                    LinkedHashSet<String> set = new LinkedHashSet<>();
                    Collections.addAll(set, columns_wanted);
                    ArrayList<String> elements = new ArrayList<>(set);

                    //adding WHERE
                    if (split_input.length > 4) {
                        String wanted_column = split_input[5];
                        String wanted_field = split_input[7].substring(1, split_input[7].length() - 2);
                        int index_wanted_field = -1;
                        for (int i = 0; i < temp_column_names.size(); i++) {
                            if (temp_column_names.get(i).equals(wanted_column)) {
                                index_wanted_field = i;
                                break;
                            }
                        }
                        //new
                        if(index_wanted_field>=0) {
                            boolean WHERE = false;
                            for (Record record : temp_records) {
                                fields = record.getFields();
                                if (fields.get(index_wanted_field).equals(wanted_field)) {
                                    WHERE = true;
                                    break;
                                }
                            }
                            if (WHERE) {
                                for (int i = 0; i < elements.size() - 1; i++) {
                                    System.out.print(elements.get(i) + " | ");
                                }
                                System.out.println(elements.get(elements.size() - 1));
                                int[] indexes_needed = new int[elements.size()];
                                for (int i = 0; i < elements.size(); i++) {
                                    for (int i1 = 0; i1 < temp_column_names.size(); i1++) {
                                        if (elements.get(i).equals(temp_column_names.get(i1))) {
                                            indexes_needed[i] = i1;
                                        }
                                    }
                                }
                                for (Record temp_record : temp_records) {
                                    fields = temp_record.getFields();
                                    if (fields.get(index_wanted_field).equals(wanted_field)) {
                                        for (int i = 0; i < indexes_needed.length - 1; i++) {
                                            for (int i1 = 0; i1 < fields.size(); i1++) {
                                                if (indexes_needed[i] == i1) {
                                                    System.out.print(fields.get(i1) + " | ");
                                                }
                                            }
                                        }
                                        for (int i1 = 0; i1 < fields.size(); i1++) {
                                            if (indexes_needed[indexes_needed.length - 1] == i1) {
                                                System.out.println(fields.get(i1));
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("No result.");
                            }
                            //new
                        }else {
                            System.out.println("ERROR!");
                        }
                    } else {
                        int[] indexes_needed = new int[elements.size()];
                        for (int i = 0; i < elements.size(); i++) {
                            for (int i1 = 0; i1 < temp_column_names.size(); i1++) {
                                if (elements.get(i).equals(temp_column_names.get(i1))) {
                                    indexes_needed[i] = i1;
                                }
                            }
                        }
                        for (int i = 0; i < elements.size()-1; i++) {
                            System.out.print(elements.get(i)+" | ");
                        }
                        System.out.println(elements.get(elements.size()-1));
                        for (Record temp_record : temp_records) {
                            fields = temp_record.getFields();
                            for (int i = 0; i < indexes_needed.length - 1; i++) {
                                for (int i1 = 0; i1 < fields.size(); i1++) {
                                    if (indexes_needed[i] == i1) {
                                        System.out.print(fields.get(i1) + " | ");
                                    }
                                }
                            }
                            for (int i1 = 0; i1 < fields.size(); i1++) {
                                if (indexes_needed[indexes_needed.length - 1] == i1) {
                                    System.out.println(fields.get(i1));
                                }
                            }
                        }
                    }
                }
            }else {
                System.out.println("No result.");
            }
        }
        else {
            System.out.println("ERROR!");
        }
    }
    private void proses_CREATE_TABLE(String[]split_input ){
        String table_name=split_input[2];
        split_input[3]=split_input[3].substring(1,split_input[3].length()-2);
        manager.CREATE(table_name,split_input[3].split(","));
    }
    private void proses_DROP_TABLE (String[] split_input){
        manager.DROP(split_input[2].substring(0,split_input[2].length()-1));
    }
    private void proses_INSERT_INTO (String[] split_input){
        if(split_input[3].equals("VALUES")) {
            String fields="";
            for (int i = 4; i < split_input.length-1; i++) {
                fields+=split_input[i]+" ";
            }
            fields+=split_input[split_input.length-1];
            fields= fields.substring(2,fields.length() - 3);
            manager.Insert_into_type1(split_input[2], fields);
        }
        else{
            int index_of_values =0;
            for (int i = 0; i < split_input.length; i++) {
                if(split_input[i].equals("VALUES")){
                    index_of_values=i;break;
                }
            }
            String fields="";
            String column_names ="";
            for (int i = 3; i < index_of_values-1; i++) {
                column_names+=split_input[i]+" ";
            }
            column_names+=split_input[index_of_values-1];
            for (int i = index_of_values+1; i < split_input.length-1; i++) {
                fields+=split_input[i]+" ";
            }
            fields+=split_input[split_input.length-1];
            fields=fields.substring(2,fields.length() - 3);
            column_names=column_names.substring(1,column_names.length()-1);
            manager.Insert_into_type2(split_input[2],fields,column_names);
        }
    }
    private void proses_DELETE (String[] split_input){
        String table_name="";
        String[] condition=new String[2];
        if(split_input.length>3){
            table_name=split_input[2];
            condition[0]=split_input[4];
            condition[1]=split_input[6].substring(1,split_input[6].length()-2);
        }else {
            table_name=split_input[2].substring(0,split_input[2].length()-1);
            condition=null;
        }
        manager.DELETE(table_name,condition);
    }
    private void proses_UPDATE (String[] split_input){
        ArrayList<String> column_names_changing=new ArrayList<>();
        ArrayList<String> fields_names_changing=new ArrayList<>();
        String [] condition=new String[2];
        if(split_input[split_input.length-4].equals("WHERE")){
            condition[1]=split_input[split_input.length-1].substring(1,split_input[split_input.length-1].length()-2);
            condition[0]=split_input[split_input.length-3];
        }else {
            condition=null;
        }
        String Table_name=split_input[1];
        column_names_changing.add(split_input[3]);
        int index_cam;
        boolean WHERE=false;
        for (int i = 0; i < split_input.length; i++) {
            if(split_input[i].equals("WHERE")){
                WHERE=true;break;
            }
        }
        if(WHERE) {
            for (int i = 5; i < split_input.length - 6; i += 2) {
                index_cam = split_input[i].indexOf(",");
                fields_names_changing.add(split_input[i].substring(1, index_cam - 1));
                column_names_changing.add(split_input[i].substring(index_cam + 1));
            }
            fields_names_changing.add(split_input[split_input.length - 5].substring(1, split_input[split_input.length - 5].length() - 1));
            manager.UPDATE(Table_name, column_names_changing, fields_names_changing, condition);
        }else {
            for (int i = 5; i < split_input.length - 2; i += 2) {
                index_cam = split_input[i].indexOf(",");
                fields_names_changing.add(split_input[i].substring(1, index_cam - 1));
                column_names_changing.add(split_input[i].substring(index_cam + 1));
            }
            fields_names_changing.add(split_input[split_input.length - 1].substring(1, split_input[split_input.length - 1].length() - 2));
            manager.UPDATE(Table_name, column_names_changing, fields_names_changing, condition);
        }
    }
    private void proses_show_tables (String[] split_input){
        manager.SHOW();
    }
}

class Manager {
    DataBase dataBase= new DataBase();
    public  Table SELECT(String table_name){
        return dataBase.get_table(table_name);
    }
    public void Insert_into_type1(String table_name,String fields){
        String [] values=fields.split("','");
        Table temp_table =dataBase.get_table(table_name);
        if(temp_table!=null) {
            if (values.length != temp_table.getColumn_num()) {
                System.out.println("ERROR!");
            } else {
                ArrayList<Record> temp_tableRecords = temp_table.getRecords();
                Record record = new Record();
                ArrayList<String> columns = record.getFields();
                Collections.addAll(columns, values);
                record.setRecordLength(temp_table.getColumn_num());
                temp_tableRecords.add(record);
                int recordnum = temp_table.getRecord_num();
                recordnum++;
                temp_table.setRecord_num(recordnum);
                System.out.println("You have made changes to the database. Rows affected: 1");
            }
        }else{
            System.out.println("ERROR!");
        }

    }
    public void Insert_into_type2(String table_name,String certain_fields,
                                  String certain_columns) {
        String [] values=certain_fields.split("','");
        String [] certain_column_names=certain_columns.split(",");
        Table temp_table =dataBase.get_table(table_name);
        boolean repeat=false;
        for (int i = 0; i < certain_column_names.length-1; i++) {
            for (int i1 = i+1; i1 < certain_column_names.length; i1++) {
                if(certain_column_names[i].equals(certain_column_names[i1])){
                    repeat=true;break;
                }
            }
            if(repeat){
                break;
            }
        }

            if(temp_table!=null) {
                if ((values.length > temp_table.getColumn_num() || certain_column_names.length>temp_table.getColumn_num())||
                        values.length!=certain_column_names.length  || repeat) {
                    System.out.println("ERROR!");
                } else {
                    ArrayList<String> column_NAmes = temp_table.getColumn_names();
                    boolean existence = false;
                    for (String name : certain_column_names) {
                        existence = false;
                        for (String s : column_NAmes) {
                            if (name.equals(s)) {
                                existence = true;
                                break;
                            }
                        }
                        if (!existence) {
                            System.out.println("ERROR!");
                            break;
                        }
                    }
                    if (existence) {
                        ArrayList<Record> temp_tableRecords = temp_table.getRecords();

                        Record record = new Record();
                        ArrayList<String> fields = record.getFields();
                        for (int i = 0; i < temp_table.getColumn_num(); i++) {
                            for (int i1 = 0; i1 < certain_column_names.length; i1++) {
                                if (column_NAmes.get(i).equals(certain_column_names[i1])) {
                                    fields.add(values[i1]);
                                }
                            }
                            if (fields.size() != i + 1) {
                                fields.add("null");
                            }
                        }
                        record.setRecordLength(temp_table.getColumn_num());
                        temp_tableRecords.add(record);
                        System.out.println("You have made changes to the database. Rows affected: 1");
                    }
                }
            }else {
                System.out.println("ERROR!");
            }


    }
    public void UPDATE (String table_name , ArrayList<String> column_names_changing,
                        ArrayList<String> fields_changing, String[] condition){
        Table temp_table=dataBase.get_table(table_name);
        if(temp_table!=null) {
            ArrayList<String> column_names_table = temp_table.getColumn_names();
            ArrayList<Record> temp_records = temp_table.getRecords();
            ArrayList<String> temp_fields;
            int rows_effected;
            boolean existence = false;
            for (int i = 0; i < column_names_changing.size(); i++) {
                for (int i1 = 0; i1 < column_names_table.size(); i1++) {
                    if (column_names_changing.get(i).equals(column_names_table.get(i1))) {
                        existence = true;
                        break;
                    }
                }
                if (!existence) {
                    break;
                }
            }

            if (existence) {

                if (condition == null) {
                    rows_effected = 0;
                    for (int i = 0; i < column_names_changing.size(); i++) {
                        for (int i1 = 0; i1 < column_names_table.size(); i1++) {
                            if (column_names_changing.get(i).equals(column_names_table.get(i1))) {
                                for (int i2 = 0; i2 < temp_records.size(); i2++) {
                                    temp_fields = temp_records.get(i2).getFields();
                                    temp_fields.set(i1, fields_changing.get(i));
                                    rows_effected++;
                                }
                            }
                        }
                    }
                    System.out.println("You have made changes to the database. Rows affected: " +
                            rows_effected / column_names_changing.size());
                } else {
                    int index_WHERE = -1;
                    for (int i4 = 0; i4 < column_names_table.size(); i4++) {
                        if (column_names_table.get(i4).equals(condition[0])) {
                            index_WHERE = i4;
                            break;
                        }
                    }
                    rows_effected = 0;
                    for (int i = 0; i < column_names_changing.size(); i++) {
                        for (int i1 = 0; i1 < column_names_table.size(); i1++) {
                            if (column_names_changing.get(i).equals(column_names_table.get(i1))) {
                                for (int i2 = 0; i2 < temp_records.size(); i2++) {
                                    temp_fields = temp_records.get(i2).getFields();
                                    if (temp_fields.get(index_WHERE) == null || temp_fields.get(index_WHERE).equals(condition[1])) {
                                        temp_fields.set(i1, fields_changing.get(i));
                                        rows_effected++;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("You have made changes to the database. Rows affected: "
                            + rows_effected / column_names_changing.size());
                }
            } else {
                System.out.println("ERROR!");
            }
        }else {
            System.out.println("ERROR!");
        }
    }
    public void DELETE (String Table_name,String [] condition){
        Table temp_table= dataBase.get_table(Table_name);
        if(temp_table!=null) {
            temp_table.Delete(condition);
        }else {
            System.out.println("ERROR!");
        }
    }
    public void CREATE (String table_name,String [] column_names){
        if(dataBase.get_table(table_name)==null){
            boolean repeat=false;
            for (int i = 0; i < column_names.length; i++) {
                for (int i1 = i+1; i1 < column_names.length; i1++) {
                    if(column_names[i].equals(column_names[i1])){
                        repeat=true;break;
                    }
                }
            }
            if(!repeat){
                dataBase.create_table(table_name,column_names);
            }else {
                System.out.println("ERROR!");
            }
        }else {
            System.out.println("ERROR!");
        }
    }
    public void DROP (String table_name){
        dataBase.drop_table(table_name);
    }
    public void SHOW(){
        dataBase.show_tables();
    }
}

class Table {
    private String  Table_name;
    private int column_num;
    private  int record_num;
    private ArrayList<String> column_names =new ArrayList<>();
    private final ArrayList<Record> records  =new ArrayList<>();


    public ArrayList<String> getColumn_names() {
        return column_names;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setColumn_names(String column_name) {
        column_names.add(column_name);
    }

    public void Delete ( String [] condition ){
        int rows_effected=0;
        if(condition!=null) {
            int Index_wanted = -1;
            for (int i = 0; i < column_names.size(); i++) {
                if (column_names.get(i).equals(condition[0])) {
                    Index_wanted = i;
                    break;
                }
            }
            //didnt check for exitence of the column in general
            ArrayList<String> fields;

            for (int i = 0; i < records.size(); i++) {
                fields=records.get(i).getFields();
                if(fields.get(Index_wanted).equals(condition[1])){
                    records.remove(i);rows_effected++;i--;
                }
            }
            System.out.println("You have made changes to the database. Rows affected: "+rows_effected);
        }else {

            System.out.println("You have made changes to the database. Rows affected: "+records.size());
            records.clear();
            record_num=0;

        }
    }

    public void setRecord_num(int record_num) {
        this.record_num = record_num;
    }

    public void setColumn_num(int column_num) {
        this.column_num = column_num;
    }

    public void setTable_name(String table_name) {
        this.Table_name = table_name;
    }


    public int getRecord_num() {
        return record_num;
    }

    public String getTable_name() {
        return Table_name;
    }

    public int getColumn_num() {
        return column_num;
    }
}

class DataBase {
    private static int table_num;
    private ArrayList<Table> tables=new ArrayList<>();
    public void drop_table(String table_name){
        boolean change=false;
        for (Table table : tables) {
            if(table.getTable_name().equals(table_name)){
                tables.remove(table);change=true;break;
            }
        }
        if(change) {
            System.out.println("You have made changes to the database.");
        }else {
            System.out.println("ERROR!");
        }
    }
    public void create_table(String table_name,String [] column_names){
        Table table_new=new Table();
        table_new.setTable_name(table_name);
        for (String name : column_names) {
            table_new.setColumn_names(name);
        }
        table_new.setColumn_num(column_names.length);
        tables.add(table_new);
        System.out.println("You have made changes to the database.");
    }
    public void show_tables(){
        if(tables.size()!=0){
            System.out.println("Tablename | Records ");
            for (int i = 0; i < tables.size(); i++) {
                System.out.print(tables.get(i).getTable_name()+" | ");
                System.out.println(tables.get(i).getRecords().size());
            }
        }else {
            System.out.println("No result.");
        }
    }
    public int getTable_num(){
        return table_num;
    }
    public void setTable_num(int number){
        this.table_num=number;
    }
    public Table get_table(String table_name){
        for (int i = 0; i < tables.size(); i++) {
            if(tables.get(i).getTable_name().equals(table_name)){
                return tables.get(i);
            }
        }
        return null;
    }
}

class Record {
    private int recordLength;
    private ArrayList<String> fields=new ArrayList<>();

    public ArrayList<String> getFields() {
        return fields;
    }
    public int getRecordLength() {
        return recordLength;
    }

    public void setRecordLength(int recordLength) {
        this.recordLength = recordLength;
    }
}

public class main {

    public static void  main(String[] args) {
        InputProcessor inputProcessor=new InputProcessor();
             inputProcessor.start();
   }
}
