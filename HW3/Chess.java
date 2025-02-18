import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

class InputProcessor {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    public void start(){
        String input=scanner.nextLine();
        while (!input.equals("exit")){
            if(input.contains("register")){
                processes_register(input.split("\\s"));
            }else if(input.contains("login")){
                processes_login(input.split("\\s"));
            }else if(input.contains("remove")) {
                processes_remove(input.split("\\s"));
            }else if(input.contains("list_users")){
                processes_list_users();
            }else if(input.equals("help")){
                processes_help();
            }else if(input.contains("new_game")){
                processes_newgame(input.split("\\s"));
            }else if(input.equals("scoreboard")){
                processes_scoreboard();
            }else if(input.equals("logout")) {
                processes_logout();
            } else if(input.equals("deselect")){
                    processes_deselect();
             } else if(input.contains("select")) {
                processes_select(input.split("\\s"));
            }else if(input.equals("show_moves")) {
                processes_show_moves();
            }else if(input.equals("show_moves -all")){
                    processes_show_moves_all();
            }else if(input.contains("move")){
                processes_move(input.split("\\s"));
            }else if(input.contains("next_turn")){
                processes_next_turn();
            }else if(input.contains("show_turn")){
                processes_show_turn();
            }else if(input.equals("undo")){
                processes_UNDO();
            }else if(input.equals("undo_number")){
                processes_UNDO_Number();
            }else if(input.equals("show_killed")){
                processes_show_killed();
            } else if(input.equals("show_killed -all")){
                processes_show_killed_all();
            } else if(input.equals("show_board")){
                processes_show_board();
            } else if(input.equals("forfeit")){
                processes_forfeit();
            }else {
                System.out.println("invalid command");
            }
            input = scanner.nextLine();
        }
        System.out.println("program ended");
        System.exit(0);
    }
    private void processes_register(String[] split_input){
        if(Controller.isMenu_register() && split_input.length==3 ){
            controller.register(split_input[1],split_input[2]);
        }else {
            System.out.println("invalid command");
        }

    }
    private void processes_login(String[] split_input){
        if(Controller.isMenu_register() && split_input.length==3){
            controller.login(split_input[1],split_input[2]);
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_remove(String[] split_input){
        if(Controller.isMenu_register()){
            controller.remove(split_input[1],split_input[2]);
        }else {
            System.out.println("invalid command");
        }

    }
    private void processes_list_users(){
        if(Controller.isMenu_main()||Controller.isMenu_register()){
            controller.list_users();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_help(){
        controller.Help();
    }
    private void processes_newgame(String[] split_input){
        if(Controller.isMenu_main() || Controller.isMenu_game() ){
            String number = split_input[2];
            boolean temp = false;
            for (int i = 0; i < number.length(); i++) {
                if(!(number.charAt(i)>=48 && number.charAt(i)<=57)){
                    if(!(i==0 && number.charAt(i)=='-')) temp = true;
                }
            }
            if(!temp){
                controller.new_game(split_input[1],Integer.parseInt(split_input[2]));
            }else {
                System.out.println("invalid command");
            }
        }else {
            System.out.println("invalid command");
        }

    }
    private void processes_scoreboard(){
        if(Controller.isMenu_main()){
            controller.scoreboard();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_logout(){
        if(Controller.isMenu_main()){
            controller.logout();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_select(String[] split_input){
        if(Controller.isMenu_game()){
            if(split_input[1].length()>3){
                System.out.println("wrong coordination");
            }else {
                controller.select(Integer.parseInt(split_input[1].substring(0,1)),Integer.parseInt(split_input[1].substring(2,3)));
            }
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_deselect(){
        if(Controller.isMenu_game()){
            controller.deselct();
        }else {
            System.out.println("invalid command");
        }

    }
    private void processes_move(String[] split_input){
        if(Controller.isMenu_game()){
            if(split_input[1].length()>3){
                System.out.println("wrong coordination");
            }else {
                controller.move(Integer.parseInt(split_input[1].substring(0,1)),Integer.parseInt(split_input[1].substring(2,3)));
            }
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_next_turn(){
        if(Controller.isMenu_game()){
            controller.next_turn();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_show_turn(){
        if(Controller.isMenu_game()){
            controller.show_turn();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_UNDO(){
        if(Controller.isMenu_game()){
            controller.Undo();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_UNDO_Number(){
        if(Controller.isMenu_game()){
            controller.Undo_number();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_show_moves(){
        if(Controller.isMenu_game()){
            controller.Show_moves();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_show_moves_all(){
        if(Controller.isMenu_game()){
            controller.Show_moves_all();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_show_killed(){
        if(Controller.isMenu_game()){
            controller.Show_killed();
        }else {
            System.out.println("invalid command");
        }
    }
    private void processes_show_killed_all(){
        if(Controller.isMenu_game()){
            controller.Show_killed_all();
        }else {
            System.out.println("invalid command");
        }

    }
    private void processes_show_board(){
        if(Controller.isMenu_game()){
            controller.Show_board();
        }else {
            System.out.println("invalid command");
        }

    }
    private void processes_forfeit(){
        if(Controller.isMenu_game()){
            controller.forfeit();
        }else {
            System.out.println("invalid command");
        }

    }
}

class Sort_score implements Comparator<User> {

    public int compare(User o1, User o2) {
        return o1.getScore()-o2.getScore();
    }
}
class Sort_wins implements Comparator<User> {

    public int compare(User o1, User o2) {
        return o1.getWins()-o2.getWins();
    }
}
class Sort_draws implements Comparator<User> {

    public int compare(User o1, User o2) {
        return o1.getDraws()-o2.getDraws();
    }
}
class Sort_looses implements Comparator<User> {

    public int compare(User o1, User o2) {
        return o1.getLooses()-o2.getLooses();
    }
}
class Sort_names implements Comparator<User> {

    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

 class Controller {

    private static boolean menu_register;
    private static boolean menu_game;
    private static boolean menu_main;

    public Controller() {
        menu_register=true;
        menu_game=false;
        menu_main=false;
    }

    public void register(String name, String pass) {
        if(User.Check_user(name,pass)){
            User.getUsers().add(new User(name, pass));
        }

    }

    public void login(String name, String pass) {
        if(User.Search(name)) {
            if(User.Search(pass)){
                boolean temp=true;
                for (User user : User.getUsers()) {
                    if(user.getName().equals(name)){
                        if(user.getPassword().equals(pass)){
                            System.out.println("login successful");
                            user.setLogged_in(true);
                            menu_main = true;
                            menu_register = false;
                        }else {
                            System.out.println("incorrect password");
                        }
                        temp=false;break;
                    }
                }
                if(temp){
                    System.out.println("no user exists with this username");
                }
            }else {
                System.out.println("password format is invalid");
            }
        }else {
            System.out.println("username format is invalid");
        }
    }

    public void remove(String name, String pass){
        if(User.Search(name)) {
            if(User.Search(pass)){


                boolean temp=false;
                Iterator<User> itr1 =User.getUsers().iterator();
                while (itr1.hasNext()){
                    User a= itr1.next();
                    if(a.getName().equals(name)) {
                        temp=true;
                        if(a.getPassword().equals(pass)){
                            System.out.println("removed "+name+" successfully");
                            itr1.remove();break;
                        }else {
                            System.out.println("incorrect password");
                            break;
                        }
                    }
                }
                if(!temp){
                    System.out.println("no user exists with this username");
                }


            }else {
                System.out.println("password format is invalid");
            }
        }else {
            System.out.println("username format is invalid");
        }
    }

    public void list_users(){
        User.List_users();
    }

    public void Help(){
        if(menu_main){
            Game.getGames().get(Game.getGames().size()-1).help_second();
        }else if(menu_game){
            Game.getGames().get(Game.getGames().size()-1).help_3();
        }else if(menu_register){
            User.help_first();
        }
    }

    public void new_game(String black,int moves){
        String white = new String();
        for (User user : User.getUsers()) {
            if(user.isLogged_in()){
                white= user.getName();
            }
        }
        if(Game.CheckGame(white,black,moves)){
            Game game = new Game(white,black,moves);
            menu_game=true;menu_main=false;
            Game.getGames().add(game);
        }
    }

    public static void setMenu_main(boolean b) {
        Controller.menu_main = b;
    }

    public static void setMenu_register(boolean b) {
        Controller.menu_register = b;
    }

    public static void setMenu_Game(boolean b) {
        Controller.menu_game = b;
    }

    public void logout (){
        for (User user : User.getUsers()) {
            if(user.isLogged_in()){
                user.logout();
                break;
            }
        }
    }

    public void select (int x,int y){
        Game.getGames().get(Game.getGames().size()-1).Select(x,y);
    }

    public void deselct (){
        Game.getGames().get(Game.getGames().size()-1).Deselect();
    }

    public void move (int x,int y){
        Game.getGames().get(Game.getGames().size()-1).movement_Handling(x,y);
    }

    public void scoreboard (){
        negative_draws();
        negative_scores();
        negative_wins();
        Collections.sort(User.getUsers(),new Sort_score().thenComparing(new Sort_wins())
                .thenComparing(new Sort_draws()).thenComparing(new Sort_looses()).thenComparing(new Sort_names()));
        negative_draws();
        negative_scores();
        negative_wins();
        for (int i = 0; i < User.getUsers().size(); i++) {
            System.out.println(User.getUsers().get(i).getName()+" "+User.getUsers().get(i).getScore()+
                    " "+User.getUsers().get(i).getWins()+" "+User.getUsers().get(i).getDraws()
                    +" "+User.getUsers().get(i).getLooses());
        }
    }

    public void negative_wins ( ){
        for (User user : User.getUsers()) {
            user.setWins(user.getWins()*-1);
        }
    }
    public void negative_draws ( ){
        for (User user : User.getUsers()) {
            user.setDraws(user.getDraws()*-1);
        }
    }
    public void negative_scores ( ){
        for (User user : User.getUsers()) {
            user.setScore(user.getScore()*-1);
        }
    }

    public void next_turn (){
        Game.getGames().get((Game.getGames().size()-1)).next_turn();
    }

    public void show_turn (){
        Game.getGames().get((Game.getGames().size()-1)).show_turn();
    }

    public void Undo_number () {Game.getGames().get((Game.getGames().size()-1)).Undo_Number();}

    public void Show_moves(){
        Game.getGames().get((Game.getGames().size()-1)).Show_moves();
    }
    public void Show_moves_all(){
        Game.getGames().get((Game.getGames().size()-1)).Show_moves_all();
    }
    public void Show_killed(){
        Game.getGames().get((Game.getGames().size()-1)).Show_killed();;
    }

    public static boolean isMenu_main() {
        return menu_main;
    }

    public static boolean isMenu_register() {
        return menu_register;
    }

    public static boolean isMenu_game() {
        return menu_game;
    }
    public void Show_killed_all(){
        Game.getGames().get((Game.getGames().size()-1)).Show_killed_all();
    }
    public void Show_board(){
        Game.getGames().get((Game.getGames().size()-1)).Show_Board();
    }
    public void forfeit(){
        Game.getGames().get((Game.getGames().size()-1)).forfeit();
    }

    public void Undo(){
        Game.getGames().get((Game.getGames().size()-1)).UNDO();
    }
}

 class User {


    private static ArrayList<User> users=new ArrayList<>();
    private String Name;
    private String Password;
    private boolean logged_in;
    private int score;
    private int Wins;
    private int Draws;
    private int Looses;
    private int UNDO_Num;

    User(String a, String b){

        this.Name = a;
        this.score=0;Wins=0;Draws=0;Looses=0;
        this.Password = b;
        this.logged_in = false;
        this.UNDO_Num = 2;
    }

    public static boolean Check_user(String a,String b){
        //a is username b is password
        if(Search(a)) {
            if(Search(b)){
                boolean temp=true;
                for (User user : users) {
                    if(user.getName().equals(a)){
                        temp=false;break;
                    }
                }
                if(temp){
                    System.out.println("register successful");
                    return true;
                }else {
                    System.out.println("a user exists with this username");
                    return false;
                }
            }else {
                System.out.println("password format is invalid");
                return false;
            }
        }else {
            System.out.println("username format is invalid");
            return false;
        }
    }

    public void logout(){
        System.out.println("logout successful");
        logged_in=false;
        Controller.setMenu_register(true);
        Controller.setMenu_main(false);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public static void help_first (){
        System.out.println("register [username] [password]");
        System.out.println("login [username] [password]");
        System.out.println("remove [username] [password]");
        System.out.println("list_users");
        System.out.println("help");
        System.out.println("exit");
    }

    public void setName(String name) {
        Name = name;
    }

    public static void List_users(){
        ArrayList<String> UserName = new ArrayList<>();
        for (User user : users) {
            UserName.add(user.getName());
        }
        for(int i = 0; i < UserName.size()-1; ++i) {
            for (int j = i + 1; j < UserName.size(); ++j) {
                if (UserName.get(i).compareTo(UserName.get(j)) > 0) {
                    Collections.swap(UserName,i,j);
                }
            }
        }
        for (int i = 0; i < users.size(); i++) {
            System.out.println(UserName.get(i));
        }
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public boolean isLogged_in() {
        return logged_in;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    //returns false if the String is not right
    public static boolean Search(String str){
        boolean right=true;
        for (int i = 0; i < str.length(); i++) {
            if(!((str.charAt(i)>=48 && str.charAt(i)<=57)||(str.charAt(i)>=65 && str.charAt(i)<=90)
                    ||(str.charAt(i)>=97 && str.charAt(i)<=122)||(str.charAt(i)==95))){
                right=false;break;
            }
        }
        return (right);
    }

    public int getUNDO_Num() {
        return UNDO_Num;
    }

    public void setUNDO_Num(int UNDO_Num) {
        this.UNDO_Num = UNDO_Num;
    }

    public void setLogged_in(boolean logged_in) {
        this.logged_in = logged_in;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public int getDraws() {
        return Draws;
    }

    public void setDraws(int draws) {
        Draws = draws;
    }

    public int getLooses() {
        return Looses;
    }

    public void setLooses(int looses) {
        Looses = looses;
    }

}

 class Game {

    private static ArrayList<Game> games = new ArrayList<>();
    private int limit;
    private String Player_white;
    private String Player_black;
    private String Turn;
    private static Mohre [][] Surface =new Mohre[8][8];
    private boolean Selecting;
    private int [][] Selected = new int[1][2];
    private boolean Done_movement;
    private boolean Done_Undo;
    private static ArrayList<String> movements=new ArrayList<>();
    private  ArrayList<String> destroyed_mohre=new ArrayList<>();

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static ArrayList<String> getMovements() {
        return movements;
    }

    Game(String white,String black,int moves){
        this.Player_black= black;
        this.limit = moves;
        this.Player_white=white;
        this.Turn="white";
        this.Selecting = false;
        this.Done_movement = false;
        this.Done_Undo = false;
        for (User user : User.getUsers()) {
            if(user.getName().equals(Player_white)){
                user.setUNDO_Num(2);
            }else if(user.getName().equals(Player_black)){
                user.setUNDO_Num(2);
            }
        }
        movements.clear();
        this.Surface[0][0]=new Castle(0,0,"white");
        this.Surface[0][1]=new Horse(0,1,"white");
        this.Surface[0][2]=new Elephant(0,2,"white");
        this.Surface[0][3]=new PrimeMinister(0,3,"white");
        this.Surface[0][4]=new King(0,4,"white");
        this.Surface[0][5]=new Elephant(0,5,"white");
        this.Surface[0][6]=new Horse(0,6,"white");
        this. Surface[0][7]=new Castle(0,7,"white");
        this.Surface[1][0]=new Soldier(1,0,"white");
        this. Surface[1][1]=new Soldier(1,1,"white");
        this.Surface[1][2]=new Soldier(1,2,"white");
        this.Surface[1][3]=new Soldier(1,3,"white");
        this.Surface[1][4]=new Soldier(1,4,"white");
        this.Surface[1][5]=new Soldier(1,5,"white");
        this.Surface[1][6]=new Soldier(1,6,"white");
        this. Surface[1][7]=new Soldier(1,7,"white");

        this.Surface[2][0]=new Empty(2,0);
        this. Surface[2][1]=new Empty(2,1);
        this. Surface[2][2]=new Empty(2,2);
        this.Surface[2][3]=new Empty(2,3);
        this.Surface[2][4]=new Empty(2,4);
        this. Surface[2][5]=new Empty(2,5);
        this.Surface[2][6]=new Empty(2,6);
        this.Surface[2][7]=new Empty(2,7);
        this.Surface[3][0]=new Empty(3,0);
        this.Surface[3][1]=new Empty(3,1);
        this.Surface[3][2]=new Empty(3,2);
        this.Surface[3][3]=new Empty(3,3);
        this.Surface[3][4]=new Empty(3,4);
        this.Surface[3][5]=new Empty(3,5);
        this.Surface[3][6]=new Empty(3,6);
        this.Surface[3][7]=new Empty(3,7);
        this. Surface[4][0]=new Empty(4,0);
        this. Surface[4][1]=new Empty(4,1);
        this. Surface[4][2]=new Empty(4,2);
        this.Surface[4][3]=new Empty(4,3);
        this.Surface[4][4]=new Empty(4,4);
        this.Surface[4][5]=new Empty(4,5);
        this.Surface[4][6]=new Empty(4,6);
        this.Surface[4][7]=new Empty(4,7);
        this. Surface[5][0]=new Empty(5,0);
        this.Surface[5][1]=new Empty(5,1);
        this.Surface[5][2]=new Empty(5,2);
        this. Surface[5][3]=new Empty(5,3);
        this. Surface[5][4]=new Empty(5,4);
        this. Surface[5][5]=new Empty(5,5);
        this.Surface[5][6]=new Empty(5,6);
        this.Surface[5][7]=new Empty(5,7);

        this.Surface[6][0]=new Soldier(6,0,"black");
        this.Surface[6][1]=new Soldier(6,1,"black");
        this. Surface[6][2]=new Soldier(6,2,"black");
        this.Surface[6][3]=new Soldier(6,3,"black");
        this.Surface[6][4]=new Soldier(6,4,"black");
        this.Surface[6][5]=new Soldier(6,5,"black");
        this.Surface[6][6]=new Soldier(6,6,"black");
        this.Surface[6][7]=new Soldier(6,7,"black");
        this. Surface[7][0]=new Castle(7,0,"black");
        this. Surface[7][1]=new Horse(7,1,"black");
        this.Surface[7][2]=new Elephant(7,2,"black");
        this.Surface[7][3]=new PrimeMinister(7,3,"black");
        this.Surface[7][4]=new King(7,4,"black");
        this. Surface[7][5]=new Elephant(7,5,"black");
        this.  Surface[7][6]=new Horse(7,6,"black");
        this. Surface[7][7]=new Castle(7,7,"black");
    }

    public static  boolean CheckGame(String white,String black,int moves ){
        if(User.Search(black)){
            if(moves<0){
                System.out.println("number should be positive to have a limit or 0 for no limit");
                return false;
            }else {
                if(white.equals(black)){
                    System.out.println("you must choose another player to start a game");
                    return false;
                }else {
                    boolean temp=false;
                    for (User user : User.getUsers()) {
                        if(user.getName().equals(black)){
                            temp=true;break;
                        }
                    }
                    if(temp){
                        System.out.println("new game started successfully between "+white+
                                " and "+black+" with limit "+moves);
                        return true;
                    }else {
                        System.out.println("no user exists with this username");
                        return false;
                    }
                }

            }

        }else {
            System.out.println("username format is invalid");
            return false;
        }
    }

    public void help_second(){
        System.out.println("new_game [username] [limit]");
        System.out.println("scoreboard");
        System.out.println("list_users");
        System.out.println("help");
        System.out.println("logout");
    }

    public void Select(int x,int y){
        if(x>0 && x<=8 && y>0 && y<=8){
            if(Turn.equals("white")){
                if(!Surface[x-1][y-1].getColor().equals("non")){
                    if(Surface[x-1][y-1].getColor().equals("white")){
                        Selected[0][0]=x-1;
                        Selected[0][1]=y-1;
                        System.out.println("selected");
                        Selecting = true;
                    }else {
                        System.out.println("you can only select one of your pieces");
                    }
                }else{
                    System.out.println("no piece on this spot");
                }
            }else {
                if(!Surface[x-1][y-1].getJob().equals("Empty")){
                    if(Surface[x-1][y-1].getColor().equals("black")){
                        Selected[0][0]=x-1;
                        Selected[0][1]=y-1;
                        System.out.println("selected");
                        Selecting = true;
                    }else {
                        System.out.println("you can only select one of your pieces");
                    }
                }else{
                    System.out.println("no piece on this spot");
                }
            }
        }else {
            System.out.println("wrong coordination");
        }

    }

    public void Deselect(){
        if(Selecting){
            Selecting = false;
            System.out.println("deselected");
        }else {
            System.out.println("no piece is selected");
        }
    }

    public void next_turn () {
        if(Done_movement){
            if(limit==0){
                System.out.println("turn completed");
                System.out.println("draw");
                Controller.setMenu_Game(false);
                Controller.setMenu_main(true);
                for (User user : User.getUsers()) {
                    if(user.getName().equals(Player_white)){
                        user.setDraws(user.getDraws()+1);
                        user.setScore(user.getScore()+1);
                    }else if(user.getName().equals(Player_black)){
                        user.setDraws(user.getDraws()+1);
                        user.setScore(user.getScore()+1);
                    }
                }
                return;
            }
            if(Turn.equals("white")){
                Turn="black";
                Done_Undo=false;
                Done_movement=false;
                Selecting= false;
                System.out.println("turn completed");
                if(destroyed_mohre.size()>0 && destroyed_mohre.get(destroyed_mohre.size()-1).charAt(0)=='K'){
                    System.out.println("player "+Player_white+" with color white won");
                    for (User user : User.getUsers()) {
                        if(user.getName().equals(Player_black)){
                            user.setLooses(user.getLooses()+1);
                        }else if(user.getName().equals(Player_white)){
                            user.setWins(user.getWins()+1);
                            user.setScore(user.getScore()+3);
                        }
                    }
                    Controller.setMenu_Game(false);
                    Controller.setMenu_main(true);
                }

            }else {
                Turn="white";
                Done_Undo=false;
                Done_movement=false;
                Selecting = false;
                System.out.println("turn completed");
                if(destroyed_mohre.size()>0 &&  destroyed_mohre.get(destroyed_mohre.size()-1).charAt(0)=='K'){
                    System.out.println("player "+Player_black+" with color black won");
                    for (User user : User.getUsers()) {
                        if(user.getName().equals(Player_black)){
                            user.setWins(user.getWins()+1);
                            user.setScore(user.getScore()+3);
                        }else if(user.getName().equals(Player_white)){
                            user.setLooses(user.getLooses()+1);
                        }
                    }
                    Controller.setMenu_Game(false);
                    Controller.setMenu_main(true);
                }
            }
        }else{
            System.out.println("you must move then proceed to next turn");
        }
    }

    //handling kind of mohre to done_movement
    void movement_Handling (int x,int y){
        if(Done_movement) {
            System.out.println("already moved");

        }else if(!(x>=1 && x<=8 && y>=1 && y<=8)) {
            System.out.println("wrong coordination");

        }else  if(!Selecting) {
            System.out.println("do not have any selected piece");

        }else if(Surface [Selected[0][0]][Selected[0][1]].Move(x-1,y-1,Turn,Selected, Done_movement,Selecting,games.get(games.size()-1))){
            Done_movement=true;
            limit-=1;
        }


    }

     public ArrayList<String> getDestroyed_mohre() {
         return destroyed_mohre;
     }

     public  int[][] getSelected() {
        return Selected;
    }

    public static Mohre[][] getSurface() {
        return Surface;
    }

    public void show_turn(){
        if(Turn.equals("white")){
            System.out.println("it is player "+Player_white+" turn with color "+Turn);
        }else {
            System.out.println("it is player "+Player_black+" turn with color "+Turn);
        }

    }

    public void UNDO(){
        if(Turn.equals("white")){
            for (User user : User.getUsers()) {
                if(user.getName().equals(Player_white)){

                    if(user.getUNDO_Num()==0){
                        System.out.println("you cannot undo anymore");return;
                    }else if(!Done_movement){
                        System.out.println("you must move before undo");return;
                    }else  if(Done_Undo){
                        System.out.println("you have used your undo for this turn");return;
                    }else if(!Done_Undo && Done_movement && user.getUNDO_Num()!=0){
                        System.out.println("undo completed");
                        Done_Undo=true;
                       Done_movement = false;
                        limit+=1;
                        user.setUNDO_Num(user.getUNDO_Num()-1);
                        String movement= movements.get(movements.size()-1);
                        movements.remove(movements.size()-1);
                        int [] first = new int[2];
                        first[0]= Integer.parseInt(movement.substring(3,4))-1;
                        first[1]= Integer.parseInt(movement.substring(5,6))-1;
                        int [] second = new int[2];
                        second[0]= Integer.parseInt(movement.substring(10,11))-1;
                        second[1]= Integer.parseInt(movement.substring(12,13))-1;
                        if(movement.length()<=13){
                            Undo_movement(movement.substring(0,2),first,second);
                        }else {
                            Undo_Destroy(movement.substring(24,26),movement.substring(0,2),first,second);
                        }
                    }
                }
            }
        }else {
            for (User user : User.getUsers()) {
                if(user.getName().equals(Player_black)){
                    if(user.getUNDO_Num()==0){
                        System.out.println("you cannot undo anymore");
                    }
                    if(!Done_movement){
                        System.out.println("you must move before undo");return;
                    }
                    if(Done_Undo){
                        System.out.println("you have used your undo for this turn");return;
                    }
                    if(!Done_Undo && Done_movement && user.getUNDO_Num()!=0){
                        user.setUNDO_Num(user.getUNDO_Num()-1);
                        System.out.println("undo completed");
                        Done_Undo=true;
                        Done_movement = false;
                        limit+=1;
                        user.setUNDO_Num(user.getUNDO_Num()-1);
                        user.setUNDO_Num(user.getUNDO_Num()-1);
                        String movement= movements.get(movements.size()-1);
                        movements.remove(movements.size()-1);
                        int [] first = new int[2];
                        first[0]= Integer.parseInt(movement.substring(3,4))-1;
                        first[1]= Integer.parseInt(movement.substring(5,6))-1;
                        int [] second = new int[2];
                        second[0]= Integer.parseInt(movement.substring(10,11))-1;
                        second[1]= Integer.parseInt(movement.substring(12,13))-1;
                        if(movement.length()<=13){
                            Undo_movement(movement.substring(0,2),first,second);
                        }else {
                            Undo_Destroy(movement.substring(24,26),movement.substring(0,2),first,second);
                        }
                    }
                }
            }
        }
    }



    public void Undo_movement(String mohre,int [] firstCordinate,int [] SecondCordinate){
        switch (mohre){
            case "Pw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Soldier(firstCordinate[0],firstCordinate[1],"white");break;
            case "Kw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new King(firstCordinate[0],firstCordinate[1],"white");break;
            case "Qw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new PrimeMinister(firstCordinate[0],firstCordinate[1],"white");break;
            case "Nw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Horse(firstCordinate[0],firstCordinate[1],"white");break;
            case "Bw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Elephant(firstCordinate[0],firstCordinate[1],"white");break;
            case "Rw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Castle(firstCordinate[0],firstCordinate[1],"white");break;
            case "Pb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Soldier(firstCordinate[0],firstCordinate[1],"black");break;
            case "Kb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new King(firstCordinate[0],firstCordinate[1],"black");break;
            case "Qb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new PrimeMinister(firstCordinate[0],firstCordinate[1],"black");break;
            case "Nb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Horse(firstCordinate[0],firstCordinate[1],"black");break;
            case "Bb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Elephant(firstCordinate[0],firstCordinate[1],"black");break;
            case "Rb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Castle(firstCordinate[0],firstCordinate[1],"black");break;
        }
        Surface[SecondCordinate[0]][SecondCordinate[1]] = new Empty(SecondCordinate[0],SecondCordinate[1]);
    }

    public void Undo_Destroy(String mohre_destroyrd,String Mohre_moved,int [] firstCordinate,int [] SecondCordinate){
        switch (Mohre_moved){
            case "Pw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Soldier(firstCordinate[0],firstCordinate[1],"white");
            case "Kw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new King(firstCordinate[0],firstCordinate[1],"white");
            case "Qw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new PrimeMinister(firstCordinate[0],firstCordinate[1],"white");
            case "Nw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Horse(firstCordinate[0],firstCordinate[1],"white");
            case "Bw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Elephant(firstCordinate[0],firstCordinate[1],"white");
            case "Rw":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Castle(firstCordinate[0],firstCordinate[1],"white");
            case "Pb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Soldier(firstCordinate[0],firstCordinate[1],"black");
            case "Kb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new King(firstCordinate[0],firstCordinate[1],"black");
            case "Qb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new PrimeMinister(firstCordinate[0],firstCordinate[1],"black");
            case "Nb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Horse(firstCordinate[0],firstCordinate[1],"black");
            case "Bb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Elephant(firstCordinate[0],firstCordinate[1],"black");
            case "Rb":
                Surface[firstCordinate[0]][firstCordinate[1]] = new Castle(firstCordinate[0],firstCordinate[1],"black");
        }
        switch (mohre_destroyrd){
            case "Pw":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Soldier(SecondCordinate[0],SecondCordinate[1],"white");
            case "Kw":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new King(SecondCordinate[0],SecondCordinate[1],"white");
            case "Qw":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new PrimeMinister(SecondCordinate[0],SecondCordinate[1],"white");
            case "Nw":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Horse(SecondCordinate[0],SecondCordinate[1],"white");
            case "Bw":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Elephant(SecondCordinate[0],SecondCordinate[1],"white");
            case "Rw":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Castle(SecondCordinate[0],SecondCordinate[1],"white");
            case "Pb":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Soldier(SecondCordinate[0],SecondCordinate[1],"black");
            case "Kb":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new King(SecondCordinate[0],SecondCordinate[1],"black");
            case "Qb":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new PrimeMinister(SecondCordinate[0],SecondCordinate[1],"black");
            case "Nb":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Horse(SecondCordinate[0],SecondCordinate[1],"black");
            case "Bb":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Elephant(SecondCordinate[0],SecondCordinate[1],"black");
            case "Rb":
                Surface[SecondCordinate[0]][SecondCordinate[1]] = new Castle(SecondCordinate[0],SecondCordinate[1],"black");
        }
    }

    public void Undo_Number(){
        if(Turn.equals("white")){
            for (User user : User.getUsers()) {
                if(user.getName().equals(Player_white)){
                    System.out.println("you have "+user.getUNDO_Num()+" undo moves");
                }
            }
        }else {
            for (User user : User.getUsers()) {
                if(user.getName().equals(Player_black)){
                    System.out.println("you have "+user.getUNDO_Num()+" undo moves");
                }
            }
        }
    }

    public void Show_moves(){
        if(Turn.equals("white")){
            for (int i = 0; i <movements.size() ; i++) {
                if(movements.get(i).charAt(1)=='w'){
                    System.out.println(movements.get(i));
                }
            }
        }else {
            for (int i = 0; i <movements.size() ; i++) {
                if(movements.get(i).charAt(1)=='b'){
                    System.out.println(movements.get(i));
                }
            }
        }

    }

    public void Show_moves_all(){
        for (int i = 0; i < movements.size(); i++) {
            System.out.println(movements.get(i));
        }
    }

    public void Show_killed(){
        if(Turn.equals("white")){
            for (String s : destroyed_mohre) {
                if(s.charAt(1)=='w'){
                    System.out.println(s);
                }
            }
        }else {
            for (String s : destroyed_mohre) {
                if(s.charAt(1)=='b'){
                    System.out.println(s);
                }
            }
        }
    }

    public void Show_killed_all(){
        for (String s : destroyed_mohre) {
            System.out.println(s);
        }
    }

    public void Show_Board(){
        for (int i = 7; i >=0; i--) {
            for (int j = 0; j < 7; j++) {
                System.out.print(abbreviation(Surface[i][j].getJob(),Surface[i][j].getColor())+"|");
            }
            System.out.println(abbreviation(Surface[i][7].getJob(),Surface[i][7].getColor())+"|");
        }
    }

    public String abbreviation(String Job,String Color){
        String ans=new String();
        if(Color.equals("white")){
            switch (Job){
                case "Soldier":
                    ans="Pw";break;
                case "King":
                    ans="Kw";break;
                case "PrimeMinister":
                    ans="Qw";break;
                case "Horse":
                    ans="Nw";break;
                case "Elephant":
                    ans="Bw";break;
                case "Castle":
                    ans="Rw";break;
                case "non":
                    ans="  ";break;
            }
        }else if(Color.equals("black")) {
            switch (Job){
                case "Soldier":
                    ans="Pb";break;
                case "King":
                    ans="Kb";break;
                case "PrimeMinister":
                    ans="Qb";break;
                case "Horse":
                    ans="Nb";break;
                case "Elephant":
                    ans="Bb";break;
                case "Castle":
                    ans="Rb";break;
                case "non":
                    ans="  ";break;
            }
        }else {
            ans="  ";
        }
        return ans;
    }

    void help_3(){
        System.out.println("select [x],[y]");
        System.out.println("deselect");
        System.out.println("move [x],[y]");
        System.out.println("next_turn");
        System.out.println("show_turn");
        System.out.println("undo");
        System.out.println("undo_number");
        System.out.println("show_moves [-all]");
        System.out.println("show_killed [-all]");
        System.out.println("show_board");
        System.out.println("help");
        System.out.println("forfeit");
    }

    void forfeit(){
        if (Turn.equals("white")){
            for (User user : User.getUsers()) {
                if(user.getName().equals(Player_white)){
                    user.setScore(user.getScore()-1);
                    user.setLooses(user.getLooses()+1);
                }else if(user.getName().equals(Player_black)) {
                    user.setScore(user.getScore()+2);
                    user.setWins(user.getWins()+1);
                }
            }
            Controller.setMenu_Game(false);
            Controller.setMenu_main(true);
            System.out.println("you have forfeited");
            System.out.println("player "+Player_black+" with color black won");
        }else {
            for (User user : User.getUsers()) {
                if(user.getName().equals(Player_black)){
                    user.setScore(user.getScore()-1);
                    user.setLooses(user.getLooses()+1);
                }else if(user.getName().equals(Player_white)) {
                    user.setScore(user.getScore()+2);
                    user.setWins(user.getWins()+1);
               }
            }
            Controller.setMenu_Game(false);
            Controller.setMenu_main(true);
            System.out.println("you have forfeited");
            System.out.println("player "+Player_white+" with color white won");
        }
    }

}

 class Mohre {
    protected int x;
    protected int y;
    protected String Color;
    protected String Job;



    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean Move(int x, int y, String turn, int[][] selected,boolean Done_move,boolean selecting,Game game) {
        return true;
    }

}

 class Castle extends  Mohre {
    Castle(int first,int second ,String Color){
        super.x=first;
        super.y=second;
        super.Color=Color;
        super.Job="Castle";
    }
    @Override
    public boolean Move(int x, int y, String Turn, int selected[][],boolean Done_move,boolean selecting,Game game){


        if(selected[0][0]==x){
            if(selected[0][1]>y){
                for (int i = selected[0][1]-1; i >y ; i--) {
                    if(!Game.getSurface()[x][i].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }else {
                for (int i = selected[0][1]+1; i <y ; i++) {
                    if(!Game.getSurface()[x][i].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }
        }else  if(selected[0][1]==y){
            if(selected[0][0]>x){
                for (int i = selected[0][0]-1; i >x ; i--) {
                    if(!Game.getSurface()[i][y].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }else {
                for (int i = selected[0][0]+1; i <x ; i++) {
                    if(!Game.getSurface()[i][y].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }
        }else {
            System.out.println("cannot move to the spot");
            return false;
        }
        if(x!=selected[0][0] && y!=selected[0][1]){
            System.out.println("cannot move to the spot");
            return false;
        }

        //after this is different for every mohre
        if((Game.getSurface() [x][y].getColor().equals(Turn))){
            System.out.println("cannot move to the spot");
            return false;
        }else {
            //doubts:
            Mohre temp = new Mohre();
            if(Game.getSurface() [x][y].getColor().equals("non")){
                System.out.println("moved");
                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }

                //having doubts about below lines
                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;

                return true;
            }else {
                System.out.println("rival piece destroyed");


                String thing=new String();
                if(Game.getSurface()[x][y].getColor().equals("white")){
                    switch (Game.getSurface()[x][y].getJob()){
                        case "Soldier":
                            thing="Pw";break;
                        case "Castle":
                            thing ="Rw";break;
                        case "Horse":
                            thing="Nw";break;
                        case "Elephant":
                            thing="Bw";break;
                        case "PrimeMinister":
                            thing="Qw";break;
                        case "King":
                            thing="Kw";break;
                    }
                }else if (Game.getSurface()[x][y].getColor().equals("black")) {
                    switch (Game.getSurface()[x][y].getJob()) {
                        case "Soldier":
                            thing = "Pb";
                            break;
                        case "Castle":
                            thing = "Rb";
                            break;
                        case "Horse":
                            thing = "Nb";
                            break;
                        case "Elephant":
                            thing = "Bb";
                            break;
                        case "PrimeMinister":
                            thing = "Qb";
                            break;
                        case "King":
                            thing = "Kb";
                            break;
                    }
                }
                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){

                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }

                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;
                return true;
            }
        }
    }
}

 class Elephant extends Mohre {
     Elephant(int first, int second, String Color) {
         super.x = first;
         super.y = second;
         super.Color = Color;
         super.Job = "Elephant";
     }

     @Override
     public boolean Move(int x, int y, String Turn, int selected[][], boolean Done_move, boolean selecting,Game game) {

         if (Math.abs(y - selected[0][1]) == Math.abs(x - selected[0][0])) {
             if (selected[0][1] < y && selected[0][0] < x) {
                 for (int i = selected[0][0] + 1, j = selected[0][1] + 1; i < x && j < y; i++, j++) {
                     if (!Game.getSurface()[i][j].getJob().equals("non")) {
                         System.out.println("cannot move to the spot");
                         return false;
                     }
                 }
             } else if (selected[0][1] < y && selected[0][0] > x) {

                 for (int i = selected[0][0] - 1, j = selected[0][1] + 1; i > x && j < y; i--, j++) {
                     if (!Game.getSurface()[i][j].getJob().equals("non")) {
                         System.out.println("cannot move to the spot");
                         return false;
                     }
                 }
             } else if (selected[0][1] > y && selected[0][0] < x) {
                 for (int i = selected[0][0] + 1, j = selected[0][1] - 1; i < x && j > y; j--, i++) {
                     if (!Game.getSurface()[i][j].getJob().equals("non")) {
                         System.out.println("cannot move to the spot");
                         return false;
                     }
                 }
             } else if (selected[0][1] > y && selected[0][0] > x) {
                 for (int i = selected[0][0] - 1, j = selected[0][1] - 1; i > x && j > y; j--, i--) {
                     if (!Game.getSurface()[i][j].getJob().equals("non")) {
                         System.out.println("cannot move to the spot");
                         return false;
                     }
                 }
             }
         } else {
             System.out.println("cannot move to the spot");
             return false;
         }


         //after this is different for every mohre
         if ((Game.getSurface()[x][y].getColor().equals(Turn))) {
             System.out.println("cannot move to the spot");
             return false;
         } else {
             //doubts:
             Mohre temp = new Mohre();
             if (Game.getSurface()[x][y].getColor().equals("non")) {
                 System.out.println("moved");
                 if (Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")) {
                     switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                         case "Soldier":
                             Game.getMovements().add("Pw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "Castle":
                             Game.getMovements().add("Rw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "Horse":
                             Game.getMovements().add("Nw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "Elephant":
                             Game.getMovements().add("Bw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "PrimeMinister":
                             Game.getMovements().add("Qw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "King":
                             Game.getMovements().add("Kw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                     }
                 } else {
                     switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                         case "Soldier":
                             Game.getMovements().add("Pb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "Castle":
                             Game.getMovements().add("Rb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "Horse":
                             Game.getMovements().add("Nb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "Elephant":
                             Game.getMovements().add("Bb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "PrimeMinister":
                             Game.getMovements().add("Qb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                         case "King":
                             Game.getMovements().add("Kb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1));
                             break;
                     }
                 }
                 //having doubts about below lines
                 temp = Game.getSurface()[selected[0][0]][selected[0][1]];
                 Game.getSurface()[selected[0][0]][selected[0][1]] = new Empty(selected[0][0], selected[0][1]);
                 Game.getSurface()[x][y] = temp;
                 return true;
             } else {
                 System.out.println("rival piece destroyed");
                 String thing = new String();
                 if (Game.getSurface()[x][y].getColor().equals("white")) {
                     switch (Game.getSurface()[x][y].getJob()) {
                         case "Soldier":
                             thing = "Pw";
                             break;
                         case "Castle":
                             thing = "Rw";
                             break;
                         case "Horse":
                             thing = "Nw";
                             break;
                         case "Elephant":
                             thing = "Bw";
                             break;
                         case "PrimeMinister":
                             thing = "Qw";
                             break;
                         case "King":
                             thing = "Kw";
                             break;
                     }
                 } else if (Game.getSurface()[x][y].getColor().equals("black")) {
                     switch (Game.getSurface()[x][y].getJob()) {
                         case "Soldier":
                             thing = "Pb";
                             break;
                         case "Castle":
                             thing = "Rb";
                             break;
                         case "Horse":
                             thing = "Nb";
                             break;
                         case "Elephant":
                             thing = "Bb";
                             break;
                         case "PrimeMinister":
                             thing = "Qb";
                             break;
                         case "King":
                             thing = "Kb";
                             break;
                     }
                 }
                 if (Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")) {

                     switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                         case "Soldier":
                             Game.getMovements().add("Pw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "Castle":
                             Game.getMovements().add("Rw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "Horse":
                             Game.getMovements().add("Nw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "Elephant":
                             Game.getMovements().add("Bw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "PrimeMinister":
                             Game.getMovements().add("Qw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "King":
                             Game.getMovements().add("Kw" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                     }
                 } else {
                     switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                         case "Soldier":
                             Game.getMovements().add("Pb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "Castle":
                             Game.getMovements().add("Rb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "Horse":
                             Game.getMovements().add("Nb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "Elephant":
                             Game.getMovements().add("Bb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "PrimeMinister":
                             Game.getMovements().add("Qb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                         case "King":
                             Game.getMovements().add("Kb" + " " + (selected[0][0] + 1) + "," + (selected[0][1] + 1) + " to " + (x + 1) + "," + (y + 1) + " destroyed " + thing);
                             game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                     Game.getMovements().get(Game.getMovements().size()-1).length())
                                     +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                             break;
                     }
                 }
                 temp = Game.getSurface()[selected[0][0]][selected[0][1]];
                 Game.getSurface()[selected[0][0]][selected[0][1]] = new Empty(selected[0][0], selected[0][1]);
                 Game.getSurface()[x][y] = temp;
                 return true;
             }
         }
     }
 }

 class Horse extends Mohre {

       Horse(int first, int second, String Color) {
           super.x = first;
           super.y = second;
           super.Color = Color;
           super.Job = "Horse";
       }

       @Override
       public boolean Move(int x, int y, String Turn, int selected[][], boolean Done_move,boolean selecting, Game game ) {


           if(!((x==selected[0][0]+2 && y==selected[0][1]-1)||(x==selected[0][0]+2 && y==selected[0][1]+1)
                   ||(x==selected[0][0]-2 && y==selected[0][1]+1)||(x==selected[0][0]-2 && y==selected[0][1]-1)||
                   (x==selected[0][0]+1 && y==selected[0][1]-2)||(x==selected[0][0]-1 && y==selected[0][1]-2)||
                   (x==selected[0][0]-1 && y==selected[0][1]+2)||(x==selected[0][0]+1 && y==selected[0][1]+2))){
               System.out.println("cannot move to the spot");
               return false;
           }
           //after this is different for every mohre
           if ((Game.getSurface()[x][y].getColor().equals(Turn))) {
               System.out.println("cannot move to the spot");
               return false;
           } else {
               //doubts:
               Mohre temp = new Mohre();
               if (Game.getSurface()[x][y].getColor().equals("non")) {
                   System.out.println("moved");
                   if (Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")) {
                       switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                           case "Soldier":
                               Game.getMovements().add("Pw" + " " +(selected[0][0]+1)+ "," +(selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "Castle":
                               Game.getMovements().add("Rw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1)+ "," + (y+1));
                               break;
                           case "Horse":
                               Game.getMovements().add("Nw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "Elephant":
                               Game.getMovements().add("Bw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1)+ " to " + (x+1) + "," + (y+1));
                               break;
                           case "PrimeMinister":
                               Game.getMovements().add("Qw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "King":
                               Game.getMovements().add("Kw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                       }
                   } else {
                       switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                           case "Soldier":
                               Game.getMovements().add("Pb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "Castle":
                               Game.getMovements().add("Rb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "Horse":
                               Game.getMovements().add("Nb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "Elephant":
                               Game.getMovements().add("Bb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "PrimeMinister":
                               Game.getMovements().add("Qb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                           case "King":
                               Game.getMovements().add("Kb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1));
                               break;
                       }
                   }
                   //having doubts about below lines
                   temp = Game.getSurface()[selected[0][0]][selected[0][1]];
                   Game.getSurface()[selected[0][0]][selected[0][1]] = new Empty(selected[0][0], selected[0][1]);
                   Game.getSurface()[x][y] = temp;
                   return true;
               } else {
                   System.out.println("rival piece destroyed");
                   String thing = new String();
                   if (Game.getSurface()[x][y].getColor().equals("white")) {
                       switch (Game.getSurface()[x][y].getJob()) {
                           case "Soldier":
                               thing = "Pw";
                               break;
                           case "Castle":
                               thing = "Rw";
                               break;
                           case "Horse":
                               thing = "Nw";
                               break;
                           case "Elephant":
                               thing = "Bw";
                               break;
                           case "PrimeMinister":
                               thing = "Qw";
                               break;
                           case "King":
                               thing = "Kw";
                               break;
                       }
                   } else if (Game.getSurface()[x][y].getColor().equals("black")) {
                       switch (Game.getSurface()[x][y].getJob()) {
                           case "Soldier":
                               thing = "Pb";
                               break;
                           case "Castle":
                               thing = "Rb";
                               break;
                           case "Horse":
                               thing = "Nb";
                               break;
                           case "Elephant":
                               thing = "Bb";
                               break;
                           case "PrimeMinister":
                               thing = "Qb";
                               break;
                           case "King":
                               thing = "Kb";
                               break;
                       }
                   }
                   if (Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")) {

                       switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                           case "Soldier":
                               Game.getMovements().add("Pw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "Castle":
                               Game.getMovements().add("Rw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "Horse":
                               Game.getMovements().add("Nw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "Elephant":
                               Game.getMovements().add("Bw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "PrimeMinister":
                               Game.getMovements().add("Qw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "King":
                               Game.getMovements().add("Kw" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1)+ " to " + (x+1)+ "," + (y+1)+ " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                       }
                   } else {
                       switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()) {
                           case "Soldier":
                               Game.getMovements().add("Pb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "Castle":
                               Game.getMovements().add("Rb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1)+ " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "Horse":
                               Game.getMovements().add("Nb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "Elephant":
                               Game.getMovements().add("Bb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "PrimeMinister":
                               Game.getMovements().add("Qb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1)+ " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                           case "King":
                               Game.getMovements().add("Kb" + " " + (selected[0][0]+1) + "," + (selected[0][1]+1) + " to " + (x+1) + "," + (y+1) + " destroyed " + thing);
                               game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                       Game.getMovements().get(Game.getMovements().size()-1).length())
                                       +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                               break;
                       }
                   }
                   temp = Game.getSurface()[selected[0][0]][selected[0][1]];
                   Game.getSurface()[selected[0][0]][selected[0][1]] = new Empty(selected[0][0], selected[0][1]);
                   Game.getSurface()[x][y] = temp;
                   return true;
               }
           }
       }
   }

 class King extends Mohre {
    King(int first,int second ,String Color){
        super.x=first;
        super.y=second;
        super.Color=Color;
        super.Job="King";
    }
    @Override
    public boolean Move(int x, int y, String Turn, int selected[][],boolean Done_move,boolean selecting,Game game){

        if(!((x==selected[0][0]+1 && y==selected[0][1]-1)||(x==selected[0][0]+1 && y==selected[0][1]+1)
                ||(x==selected[0][0]+1 && y==selected[0][1])||(x==selected[0][0]-1 && y==selected[0][1]-1)||
                (x==selected[0][0]-1 && y==selected[0][1]+1)||(x==selected[0][0]-1 && y==selected[0][1])||
                (x==selected[0][0] && y==selected[0][1]+1)||(x==selected[0][0] && y==selected[0][1]-1))){
            System.out.println("cannot move to the spot");
            return false;
        }
        //after this is different for every mohre
        if((Game.getSurface() [x][y].getColor().equals(Turn))){
            System.out.println("cannot move to the spot");
            return false;
        }else {
            //doubts:
            Mohre temp = new Mohre();
            if(Game.getSurface() [x][y].getColor().equals("non")){
                System.out.println("moved");
                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }
                //having doubts about below lines
                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;
                return true;
            }else {
                System.out.println("rival piece destroyed");
                String thing=new String();
                if(Game.getSurface()[x][y].getColor().equals("white")){
                    switch (Game.getSurface()[x][y].getJob()){
                        case "Soldier":
                            thing="Pw";break;
                        case "Castle":
                            thing ="Rw";break;
                        case "Horse":
                            thing="Nw";break;
                        case "Elephant":
                            thing="Bw";break;
                        case "PrimeMinister":
                            thing="Qw";break;
                        case "King":
                            thing="Kw";break;
                    }
                }else if (Game.getSurface()[x][y].getColor().equals("black")) {
                    switch (Game.getSurface()[x][y].getJob()) {
                        case "Soldier":
                            thing = "Pb";
                            break;
                        case "Castle":
                            thing = "Rb";
                            break;
                        case "Horse":
                            thing = "Nb";
                            break;
                        case "Elephant":
                            thing = "Bb";
                            break;
                        case "PrimeMinister":
                            thing = "Qb";
                            break;
                        case "King":
                            thing = "Kb";
                            break;
                    }
                }

                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){

                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }
                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;
                return true;
            }
        }
    }

}

 class PrimeMinister extends Mohre {
    PrimeMinister(int first,int second ,String Color){
        super.x=first;
        super.y=second;
        super.Color=Color;
        super.Job="PrimeMinister";
    }
    @Override
    public boolean Move(int x,int y,String Turn,int selected [][],boolean Done_move,boolean selecting,Game game){



        if(selected[0][1]<y && selected[0][0]<x){
            for (int i = selected[0][0]+1,j=selected[0][1]+1  ; i <x && j<y ; i++,j++) {
                if(!Game.getSurface()[i][j].getColor().equals("non")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }
        }else if(selected[0][1]<y && selected[0][0]>x){

            for (int i = selected[0][0]-1 , j=selected[0][1]+1 ; i > x && j<y ; i--,j++) {
                if(!Game.getSurface()[i][j].getColor().equals("non")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }
        }else if(selected[0][1]>y && selected[0][0]<x){
            for (int i = selected[0][0]+1 , j=selected[0][1]-1 ; i <x && j>y ; j--,i++) {
                if(!Game.getSurface()[i][j].getColor().equals("non")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }
        }else if(selected[0][1]>y && selected[0][0]>x){
            for (int i = selected[0][0]-1 , j=selected[0][1]-1 ; i > x && j>y ; j--,i--) {
                if(!Game.getSurface()[i][j].getColor().equals("non")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }
        }

        if(selected[0][0]==x){
            if(selected[0][1]>y){
                for (int i = selected[0][1]-1; i >y ; i--) {
                    if(!Game.getSurface()[x][i].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }else {
                for (int i = selected[0][1]+1; i <y ; i++) {
                    if(!Game.getSurface()[x][i].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }
        }


        if(selected[0][1]==y){
            if(selected[0][0]>x){
                for (int i = selected[0][0]-1; i >x; i--) {
                    if(!Game.getSurface()[i][y].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }else {
                for (int i = selected[0][0]+1; i <x ; i++) {
                    if(!Game.getSurface()[i][y].getColor().equals("non")){
                        System.out.println("cannot move to the spot");
                        return false;
                    }
                }
            }
        }



        if(x!=selected[0][0] && y!=selected[0][1] && (Math.abs(y-selected[0][1])!=Math.abs(x-selected[0][0]))){
            System.out.println("cannot move to the spot");
            return false;
        }
        //after this is different for every mohre
        if((Game.getSurface() [x][y].getColor().equals(Turn))){
            System.out.println("cannot move to the spot");
            return false;
        }else {
            //doubts:
            Mohre temp = new Mohre();
            if(Game.getSurface() [x][y].getColor().equals("non")){
                System.out.println("moved");
                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }
                //having doubts about below lines
                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;
                return true;
            }else {
                System.out.println("rival piece destroyed");
                String thing=new String();
                if(Game.getSurface()[x][y].getColor().equals("white")){
                    switch (Game.getSurface()[x][y].getJob()){
                        case "Soldier":
                            thing="Pw";break;
                        case "Castle":
                            thing ="Rw";break;
                        case "Horse":
                            thing="Nw";break;
                        case "Elephant":
                            thing="Bw";break;
                        case "PrimeMinister":
                            thing="Qw";break;
                        case "King":
                            thing="Kw";break;
                    }
                }else if (Game.getSurface()[x][y].getColor().equals("black")) {
                    switch (Game.getSurface()[x][y].getJob()) {
                        case "Soldier":
                            thing = "Pb";
                            break;
                        case "Castle":
                            thing = "Rb";
                            break;
                        case "Horse":
                            thing = "Nb";
                            break;
                        case "Elephant":
                            thing = "Bb";
                            break;
                        case "PrimeMinister":
                            thing = "Qb";
                            break;
                        case "King":
                            thing = "Kb";
                            break;
                    }
                }

                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){

                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }
                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;
                return true;
            }
        }
    }
}

 class Soldier extends Mohre {
    Soldier(int first,int second ,String Color){
        super.x=first;
        super.y=second;
        super.Color=Color;
        super.Job="Soldier";
    }
    @Override
    public boolean Move(int x,int y,String Turn,int selected [][],boolean Done_move,boolean selecting,Game game){

        if(selected[0][0]+2==x && selected[0][1]==y){
                if(selected[0][0]!=1) {
                    System.out.println("cannot move to the spot");
                    return false;
                }
        }else if(Turn.equals("white")&&(!((selected[0][0]+1==x && selected[0][1]==y) || (selected[0][0]+1==x && selected[0][1]+1==y)||
                (selected[0][0]+1==x && selected[0][1]-1==y)))){
            System.out.println("cannot move to the spot");
            return false;
        }


        if(selected[0][0]-2==x && selected[0][1]==y){
            if(selected[0][0]!=6) {
                System.out.println("cannot move to the spot");
                return false;
            }
        }else if(Turn.equals("black") && (!((selected[0][0]-1==x && selected[0][1]==y) || (selected[0][0]-1==x && selected[0][1]+1==y)||
                (selected[0][0]-1==x && selected[0][1]-1==y)))){
            System.out.println("cannot move to the spot");
            return false;
        }


        if(Turn.equals("white")){
            if(selected[0][0]+1==x && selected[0][1]==y+1 ){
                if(!Game.getSurface()[x][y].getColor().equals("black")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }else if(selected[0][0]+1==x && selected[0][1]==y-1){
                if(!Game.getSurface()[x][y].getColor().equals("black")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }else if(selected[0][0]==x-1 && selected[0][1]==y){
                if(!Game.getSurface()[x][y].getColor().equals("non")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }
        }else {
            if(selected[0][0]-1==x && selected[0][1]==y+1 ){
                if(!Game.getSurface()[x][y].getColor().equals("white")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }else if(selected[0][0]-1==x && selected[0][1]==y-1){
                if(!Game.getSurface()[x][y].getColor().equals("white")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }else if(selected[0][0]==x+1 && selected[0][1]==y){
                if(!Game.getSurface()[x][y].getColor().equals("non")){
                    System.out.println("cannot move to the spot");
                    return false;
                }
            }
        }


        //after this is different for every mohre
        if((Game.getSurface() [x][y].getColor().equals(Turn))){
            System.out.println("cannot move to the spot");
            return false;
        }else {
            //doubts:
            Mohre temp = new Mohre();
            if(Game.getSurface() [x][y].getColor().equals("non")){
                System.out.println("moved");
                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1));break;
                    }
                }
                //having doubts about below lines
                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;
                return true;
            }else {
                System.out.println("rival piece destroyed");
                String thing=new String();
                if(Game.getSurface()[x][y].getColor().equals("white")){
                    switch (Game.getSurface()[x][y].getJob()){
                        case "Soldier":
                            thing="Pw";break;
                        case "Castle":
                            thing ="Rw";break;
                        case "Horse":
                            thing="Nw";break;
                        case "Elephant":
                            thing="Bw";break;
                        case "PrimeMinister":
                            thing="Qw";break;
                        case "King":
                            thing="Kw";break;
                    }
                }else if (Game.getSurface()[x][y].getColor().equals("black")) {
                    switch (Game.getSurface()[x][y].getJob()) {
                        case "Soldier":
                            thing = "Pb";
                            break;
                        case "Castle":
                            thing = "Rb";
                            break;
                        case "Horse":
                            thing = "Nb";
                            break;
                        case "Elephant":
                            thing = "Bb";
                            break;
                        case "PrimeMinister":
                            thing = "Qb";
                            break;
                        case "King":
                            thing = "Kb";
                            break;
                    }
                }
                if(Game.getSurface()[selected[0][0]][selected[0][1]].getColor().equals("white")){

                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kw"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }else {
                    switch (Game.getSurface()[selected[0][0]][selected[0][1]].getJob()){
                        case "Soldier":
                            Game.getMovements().add("Pb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Castle":
                            Game.getMovements().add("Rb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Horse":
                            Game.getMovements().add("Nb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "Elephant":
                            Game.getMovements().add("Bb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "PrimeMinister":
                            Game.getMovements().add("Qb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                        case "King":
                            Game.getMovements().add("Kb"+" "+(selected[0][0]+1)+","+(selected[0][1]+1)+" to "+(x+1)+","+(y+1)+" destroyed "+thing);
                            game.getDestroyed_mohre().add((Game.getMovements().get(Game.getMovements().size()-1).substring(Game.getMovements().get(Game.getMovements().size()-1).length()-2,
                                    Game.getMovements().get(Game.getMovements().size()-1).length())
                                    +" killed in spot "+Game.getMovements().get(Game.getMovements().size()-1).substring(10,13)));
                            break;
                    }
                }
                temp=Game.getSurface()[selected[0][0]][selected[0][1]] ;
                Game.getSurface()[selected[0][0]][selected[0][1]]=new Empty(selected[0][0],selected[0][1]);
                Game.getSurface()[x][y]=temp;
                return true;
            }
        }
    }
}

 class Empty extends Mohre{
    Empty(int first,int second){
        super.x=first;
        super.y=second;
        super.Color="non";
        super.Job="non";
    }
}


public class main {
    public static void  main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();
        inputProcessor.start();
    }
}
