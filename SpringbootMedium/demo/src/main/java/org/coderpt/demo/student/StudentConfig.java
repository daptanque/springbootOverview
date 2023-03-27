package org.coderpt.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        try {
            return args -> {
                Student mariam = new Student(
                        "Mariam",
                        "maria.jamal@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 4)
                );

                Student alex = new Student(
                        "Alex",
                        "alex.jamal@gmail.com",
                        LocalDate.of(1996, Month.JANUARY, 4)
                );

                repository.saveAll(
                        List.of(mariam, alex)
                );
            };
        }catch (Exception ex){
            System.out.println(ex.getMessage() + "\n\n\n\n" + ex.getStackTrace());
            return args -> {};
        }
    };
}
