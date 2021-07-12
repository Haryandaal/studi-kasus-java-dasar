public class AplikasiTodolist {

    public static String[] data = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testViewRemoveTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < data.length; i++) {
            var todo = data[i];
            var no = i + 1;

            if(todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }
    public static void testShowTodoList() {
        data[0] = "Belajar Java Dasar";
        data[1] = "Belajar Java OOP";
        showTodoList();
    }

    /**
     * Menambahkan todo ke list
     */
    public static void addTodoList(String todo) {
        // ngecek apakah sudah full
        var isFull = true;
        for (var i = 0; i < data.length; i++){
            if(data[i] == null) {
                //jika masih kosong
                isFull = false;
                break;
            }
        }
        // jika sudah full tambahkan array dua kali lipat
        if(isFull) {
            var temp = data;
            data = new String[data.length * 2];

            for (var i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

        // Menambahkan todo
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Show todo ke " + i);
        }
        showTodoList();
    }
    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            // untuk menggeser
            for (int i = (number - 1); i < data.length ; i++) {
                if(i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

       result =  removeTodoList(3);
        System.out.println(result);


        showTodoList();
    }

    /**
     * INPUT DATA
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        String dataa = scanner.nextLine();
        return dataa;
    }
    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var age = input("Age");
        System.out.println(" I am " + age);
    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
       while (true) {
           showTodoList();

           System.out.println("MENU : ");
           System.out.println("1. TAMBAH");
           System.out.println("2. HAPUS");
           System.out.println("x. EXIT");

           var input = input("PILIH ");

           if(input.equals("1")) {
               viewAddTodoList();
           } else if (input.equals("2")) {
               viewRemoveTodoList();
           } else if (input.equals("x")) {
               break;
           } else {
               System.out.println("Pilihan Tidak Dimengerti");
           }
       }
    }
    public static void testViewShowTodoList() {
        System.out.println("1. Satu");
        System.out.println("2. Dua");
        System.out.println("3. Tiga");
        System.out.println("4. Empat");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambah todo list
     */
    public static void viewAddTodoList () {
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

    /**
     * Menampilkan view menghapus todo dari list
     */
    public static void viewRemoveTodoList () {
        System.out.println("Menghapus Todolist");

        var number = input("Number (x jika batal)");

        if (number.equals("x")){
            //batal
        } else {
           boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal Menghapus Todolist " + number);
            }
        }
    }
    public static void testViewRemoveTodoList() {
        addTodoList("1. satu");
        addTodoList("2. dua");

        showTodoList();

        viewRemoveTodoList();
        showTodoList();

    }
}
