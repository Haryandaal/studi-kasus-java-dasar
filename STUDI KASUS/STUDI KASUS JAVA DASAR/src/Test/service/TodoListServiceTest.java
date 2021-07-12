package Test.service;

import Repository.TodoListRepository;
import Repository.TodoListRepositoryImpl;
import Service.TodoListService;
import Service.TodolistServiceImpl;
import entity.TodoList;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();

    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar Java Dasar");
        todoListRepository.data[1] = new TodoList("Belajar Java OOP");
        TodoListService todoListService = new TodolistServiceImpl(todoListRepository);

        todoListService.showTodolist();

    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodolistServiceImpl(todoListRepository);

        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Java OOP");

        todoListService.showTodolist();

    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodolistServiceImpl(todoListRepository);

        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Java OOP");
        todoListService.addTodolist("Belajar Java Standard Classes");

        todoListService.showTodolist();
        todoListService.removeTodolist(5);
        todoListService.removeTodolist(1);
        todoListService.showTodolist();

    }
}
