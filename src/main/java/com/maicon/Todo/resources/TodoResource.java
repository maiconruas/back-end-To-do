package com.maicon.Todo.resources;

import com.maicon.Todo.domain.Todo;
import com.maicon.Todo.services.TodoService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

    @CrossOrigin("*")
    @RestController
    @RequestMapping(value = "/todos")
    public class TodoResource{

        @Autowired
        private TodoService service;

        @GetMapping(value = "/{id}")
        public ResponseEntity<Todo> findById(@PathVariable Integer id) throws ObjectNotFoundException {
            Todo obj = service.findById(id);
            return  ResponseEntity.ok().body(obj);
        }

        @GetMapping(value = "/open")
        public ResponseEntity<List<Todo>> listOpen() {
            List<Todo> list = service.findAllOpen();
            return ResponseEntity.ok().body(list);
        }

        @GetMapping(value = "/close")
        public ResponseEntity<List<Todo>> listClose() {
            List<Todo> list = service.findAllClose();
            return ResponseEntity.ok().body(list);
        }



        @GetMapping
        public ResponseEntity<List<Todo>> listAll() {
            List<Todo> list = service.findAll();
            return ResponseEntity.ok().body(list);
        }

        @PostMapping
        public ResponseEntity<Todo> create(@RequestBody Todo obj) {
            obj = service.create(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj) throws ObjectNotFoundException {
            Todo newObj = service.update(id, obj);
            return ResponseEntity.ok().body(newObj);
        }
    }

