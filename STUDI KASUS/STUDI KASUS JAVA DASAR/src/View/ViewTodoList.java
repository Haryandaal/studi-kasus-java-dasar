package View;

import Service.TodoListService;
import Util.InputUtil;

public class ViewTodoList {

    private TodoListService todoListService;

    public ViewTodoList(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodolist(){
        while (true) {
           todoListService.showTodolist();

            System.out.println("MENU : ");
            System.out.println("1. TAMBAH");
            System.out.println("2. HAPUS");
            System.out.println("x. EXIT");

            var input = InputUtil.input("PILIH ");

            if(input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")) {
                removeTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }
    }

    public void addTodolist(){
        System.out.println("Menambah Todolist");

        var todo = InputUtil.input("Todo (x jika batal)");

        if(todo.equals("x")) {
            //batal
        } else {
            todoListService.addTodolist(todo);
        }
    }

    public void removeTodolist(){
        System.out.println("Menghapus Todolist");

        var number = InputUtil.input("Number (x jika batal)");

        if (number.equals("x")){
            //batal
        } else {
            todoListService.removeTodolist(Integer.valueOf(number));
        }
    }
}
