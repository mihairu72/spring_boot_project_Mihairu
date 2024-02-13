package ru.javarush.sitnikov.spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javarush.sitnikov.spring_boot_project.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
        List<UserEntity> findUserEntitiesByAgeGreaterThanOrderByAge(Integer age);

        Integer countUserEntitiesByAgeGreaterThan(Integer age);

        List<UserEntity> findUserEntitiesByAgeBetween(Integer ageMin, Integer ageMax);

}
