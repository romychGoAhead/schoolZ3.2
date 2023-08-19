package ru.hogwarts32.school32.service;
import org.springframework.stereotype.Service;
import ru.hogwarts32.school32.exception.StudentNotFoundException;
import ru.hogwarts32.school32.model.Student;
import ru.hogwarts32.school32.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // создаем счетчик идентификатора, который будет инкрементироваться при каждом добавлении нового объекта модели в HashMap.

// добавляем CRUD операции

    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);

    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> getByAge(int age) {
        return studentRepository.findAllByAge(age);

    }   // фильтрация по возрасту

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Long id, Student student) {
        Student exsitingStudent = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        Optional.ofNullable(student.getName()).ifPresent(exsitingStudent::setName);
        Optional.ofNullable(student.getAge()).ifPresent(exsitingStudent::setAge);
        exsitingStudent.setAge(student.getAge());
        return studentRepository.save(exsitingStudent);
    }

    public Student remove(Long id) {
        Student exsitingStudent = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        studentRepository.delete(exsitingStudent);
        return exsitingStudent;
    }

}