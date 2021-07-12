package Test.view;

import Repository.TodoListRepository;
import Repository.TodoListRepositoryImpl;
import Service.TodoListService;
import Service.TodolistServiceImpl;
import View.ViewTodoList;

public class TodoListViewTest {
    public static void main(String[] args) {
        testAddTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodolistServiceImpl(todoListRepository);
        ViewTodoList viewTodoList = new ViewTodoList(todoListService);

        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Java OOP");
        todoListService.addTodolist("Belajar Java Standard Classes");

        viewTodoList.showTodolist();
    }
    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodolistServiceImpl(todoListRepository);
        ViewTodoList viewTodoList = new ViewTodoList(todoListService);

        viewTodoList.addTodolist();
        todoListService.showTodolist();
        viewTodoList.addTodolist();
        todoListService.showTodolist();
    }
}
