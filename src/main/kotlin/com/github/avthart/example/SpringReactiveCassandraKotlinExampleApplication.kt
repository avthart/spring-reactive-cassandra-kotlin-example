package com.github.avthart.example

import com.github.avthart.example.domain.Task
import com.github.avthart.example.repository.TaskRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux
import java.util.*

@SpringBootApplication
class SpringReactiveCassandraKotlinExampleApplication {

    @Bean
    fun init(taskRepository: TaskRepository) = CommandLineRunner {
        taskRepository.deleteAll().thenMany(
                Flux.just("Create Spring Boot Project", "Learn kotlin", "Run cassandra")
                        .map { title -> Task(UUID.randomUUID().toString(), title, false, false) }
                        .flatMap(taskRepository::save))
                .thenMany(taskRepository.findAll())
                .subscribe(System.out::println)
    }
}

fun main(args: Array<String>) {
    runApplication<SpringReactiveCassandraKotlinExampleApplication>(*args)
}
