package com.github.avthart.example.repository

import com.github.avthart.example.domain.Task
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface TaskRepository: ReactiveCrudRepository<Task, String> {
    fun findByTitle(title: String): Flux<Task>
}