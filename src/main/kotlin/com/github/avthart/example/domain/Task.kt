package com.github.avthart.example.domain

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table
data class Task(
        @PrimaryKey
        val id: String,
        val title: String,
        val completed: Boolean,
        val starred: Boolean
)