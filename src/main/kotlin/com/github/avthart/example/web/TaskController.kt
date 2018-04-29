package com.github.avthart.example.web

import com.github.avthart.example.domain.Task
import com.github.avthart.example.repository.TaskRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
class TaskController(val taskRepository: TaskRepository) {
    @GetMapping(value = [ "/tasks" ], produces = [ MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE ])
    fun findAll(): Flux<Task> {
        return taskRepository.findAll()
                .delayElements(Duration.ofMillis(500)) // delay each element with 500 ms to see that Server-Sent events are streamed
    }
}