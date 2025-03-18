package ru.golubev.manager.config

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties("crack.hash")
data class CrackHashProperties(
    val defaultTotalTasks: Int,
    val tasksQueue: String
)