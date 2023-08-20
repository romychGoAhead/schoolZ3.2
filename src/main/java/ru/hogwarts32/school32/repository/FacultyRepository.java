package ru.hogwarts32.school32.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts32.school32.model.Faculty;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByColor(String color); //реализовать метод и не реализ. их.
    List<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase(String color, String name); // ищем по цвету и имени
    Optional<Faculty> findByStudent_id(Long studentId);
}
