package com.maicon.Todo.services;

import com.maicon.Todo.domain.Todo;
import com.maicon.Todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanciaBaseDeDados() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", sdf.parse("25/03/2022"), false);

        todoRepository.saveAll(Arrays.asList(t1));
    }

}
