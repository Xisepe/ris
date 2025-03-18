package ru.golubev.manager.service

interface WorkerInfoService {
    fun getNumberOfActiveWorkers(queueName: String): Int
}