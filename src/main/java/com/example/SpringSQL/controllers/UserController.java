package com.example.SpringSQL.controllers;

import com.example.SpringSQL.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        String sql = "select * from userOne";
        List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
        users.forEach(System.out :: println);
        System.out.println("Listado exitoso!");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findAllOneById(@PathVariable Long id) {
        try {
            String sql = "select * from userOne where id_user=" + id;
            List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
            User user = users.get(0);
            System.out.println(user);

            System.out.println("El usuario ha sido encontrado");
            return ResponseEntity.ok(user);
        } catch (Exception exception) {
            System.out.println("El usuario no ha sido encontrado");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        if (user.getId_user() != null) {
            System.out.println("El ID no debe ser introducido");
            return ResponseEntity.badRequest().build();
        }

        String name = user.getName_user();
        int age = user.getAge_user();
        String sql = "insert into userOne(name_user, age_user) values ('" + name + "', " + age + ")";
        jdbcTemplate.execute(sql);

        System.out.println("Usuario registrado");
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users")
    public ResponseEntity<User> update(@RequestBody User user) {
        if (user.getId_user() == null || ValidateUser(user)) {
            System.out.println("El usuario no existe");
            return ResponseEntity.badRequest().build();
        }

        String name = user.getName_user();
        int age = user.getAge_user();
        String sqlName = "update userOne set name_user = '" + name + "' where id_user=" + user.getId_user();
        String sqlAge = "update userOne set age_user = " + age + " where id_user=" + user.getId_user();
        jdbcTemplate.execute(sqlName);
        jdbcTemplate.execute(sqlAge);

        System.out.println("El usuario a sido actualizado");
        return ResponseEntity.ok(user);
    }

    private boolean ValidateUser(User user) {
        try {
            String sql = "select * from userOne where id_user=" + user.getId_user();
            List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
            user = users.get(0);
            return false;
        } catch (Exception exception) {
            return true;
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<User> deleteAll() {
        String sql = "delete from userOne;";
        jdbcTemplate.execute(sql);
        System.out.println("Registros de usuarios eliminados!");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        try {
            if (ValidateUser(id)) {
                throw new Exception();
            }

            String sql = "delete from userOne where id_user=" + id;
            jdbcTemplate.execute(sql);

            System.out.println("El usuario ha sido eliminado");
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            System.out.println("El usuario no ha sido encontrado y eliminado");
            return ResponseEntity.notFound().build();
        }
    }

    private boolean ValidateUser(Long id) {
        try {
            String sql = "select * from userOne where id_user=" + id;
            List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
            User user = users.get(0);
            return false;
        } catch (Exception exception) {
            return true;
        }
    }
}
