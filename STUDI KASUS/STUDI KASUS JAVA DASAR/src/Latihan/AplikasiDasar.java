package Latihan;

public class AplikasiDasar {
    public static String[] data = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static void showTodoList (){
        System.out.println("TODOLIST");
        for (var i = 0; i < data.length; i++){
         var todo = data[i];
         int no = i + 1;

         if(data[i] != null){
             System.out.println(no + ". " + todo);
         }
        }
    }
    public static void testShowTodoList(){
        data[0] = "Italia";
        data[1] = "Belanda";
        showTodoList();
    }

    public static void addTodoList (String todo){
        //Cek Apakah array sudah full
        var isFull = true;
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null){
                //masih kosong
                isFull = false;
                break;
            }
        }
        //Jika sudah full tambahkan array dua kali lipat
        if(isFull) {
            var temp = data;
            data = new String[data.length * 2];

            for (var i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
        //Menambah todolist
        for ( var i = 0; i < data.length; i++){
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }
    public static void testAddTodoList(){
        for (int i = 0; i < 30; i++) {
            addTodoList("Todo ke " + i );
        }
        showTodoList();
    }

    public static boolean removeTodolist (Integer number){
        if((number - 1) >= data.length){
            return false;
        }else if (data[number -1] == null){
            return false;
        }else {
            //Menggeser
            for( var i = (number - 1); i < data.length; i++){
                if (i == (data.length - 1)) {
                    data[i] = null;
                }else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
    public static void testRemoveTodoList (){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodolist(20);
        System.out.println(result);

        result = removeTodolist(4);
        System.out.println(result);

        showTodoList();
    }
    public static String input (String info){
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }
    public static void testInput() {
        var name = input("Nama");
        System.out.println(name);
    }

    public static void viewShowTodoList (){
      while (true){
          showTodoList();

          System.out.println("MENU :");
          System.out.println("1. Tambah");
          System.out.println("2. Hapus");
          System.out.println("x. Keluar");

          var input = input("Pilih");

          if (input.equals("1")) {
              viewAddTodoList();
          }else if (input.equals("2")){
              viewRemoveTodoList();
          }else if (input.equals("x")) {
              break;
          }else {
              System.out.println("Yang anda pilih tidak dimnengerti");
          }
      }
    }
    public static void testViewShowTodoList (){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewShowTodoList();
        showTodoList();
    }

    public static void viewAddTodoList (){
        System.out.println("Menambah Todolist");

        var todo = input("Todo (x jika batal)");

        if(todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }
    public static void testViewAddTodoList () {
        viewAddTodoList();

        showTodoList();
    }

    public static void viewRemoveTodoList (){
        System.out.println("Menghapus Todolist");

        var number = input("Number (x jika batal)");

        if (number.equals("x")){
            //batal
        } else {
          boolean success = removeTodolist(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus menghapus " + number);
            }
        }
    }
    public static void testViewRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
