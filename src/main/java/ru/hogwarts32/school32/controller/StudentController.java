package ru.hogwarts32.school32.controller;
import org.springframework.web.bind.annotation.*;

import ru.hogwarts32.school32.model.Student;
import ru.hogwarts32.school32.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService; // подключаем сервис

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Collection<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Long id) {
        return studentService.getById(id);
    }
    @GetMapping("/filtered")
    public Collection<Student> filtered (@RequestParam int age) {  // фильтр по возрасту
        return studentService.getByAge(age);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {          // @RequestBody-  тело запроса
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Student remove (@PathVariable Long id) {
        return studentService.remove(id);
    }
    @GetMapping("/by-age")
    public Collection<Student> filtered (@RequestParam int min,@RequestParam int max) {  // фильтр по min, max
        return studentService.findAllByAgeBetween(min,max);
    }

}
