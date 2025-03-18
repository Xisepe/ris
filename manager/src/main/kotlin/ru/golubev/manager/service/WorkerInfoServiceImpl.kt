package ru.golubev.manager.service

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.stereotype.Service

@Service
class WorkerInfoServiceImpl(
    private val amqpAdmin: AmqpAdmin
) : WorkerInfoService {
    override fun getNumberOfActiveWorkers(queueName: String): Int {
        return amqpAdmin.getQueueInfo(queueName)?.consumerCount ?: 0
    }
}