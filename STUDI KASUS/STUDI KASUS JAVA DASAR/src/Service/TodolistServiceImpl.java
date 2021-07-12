package Service;

import Repository.TodoListRepository;
import entity.TodoList;

public class TodolistServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodolistServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodolist() {
        TodoList[] data = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (var i = 0; i < data.length; i++) {
            var todoList = data[i];
            var no = i + 1;

            if(todoList != null) {
                System.out.println(no + ". " + todoList.getTodo());
            }
        }
    }

    @Override
    public void addTodolist(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("SUKSES MENAMBAH TODO " + todo);

    }

    @Override
    public void removeTodolist(Integer number) {
       boolean success = todoListRepository.remove(number);
       if (success){
           System.out.println("SUKSES MENGAHAPUS TODO " + number);
       } else {
           System.out.println("GAGAL MENGHAPUS TODO " + number);
       }

    }
}
