package ru.golubev.manager.service.impl

import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Service
import ru.golubev.manager.config.CrackHashProperties
import ru.golubev.manager.model.CrackHashSubtask
import ru.golubev.manager.model.CrackHashTask
import ru.golubev.manager.service.HashCrackTaskService
import ru.golubev.manager.service.WorkerInfoService
import java.util.*
import kotlin.math.max

@Service
class HashCrackTaskServiceImpl(
    private val mongoTemplate: MongoOperations,
    private val workerInfoService: WorkerInfoService,
    private val crackHashProperties: CrackHashProperties
) : HashCrackTaskService {

    override fun createHashCrackTask(hash: String, maxLength: Int): CrackHashTask {
        val totalTasksNumber = getTotalTasks()
        val task = CrackHashTask(
            hash = hash,
            maxLength = maxLength,
            subtasks = (0..<totalTasksNumber).map {
                CrackHashSubtask(
                    id = UUID.randomUUID(),
                    partNumber = it,
                    totalParts = totalTasksNumber
                )
            }
        )
        return mongoTemplate.save(task)
    }

    private fun getTotalTasks(): Int {
        val activeNodes = workerInfoService.getNumberOfActiveWorkers(crackHashProperties.tasksQueue)
        return max(activeNodes, crackHashProperties.defaultTotalTasks)
    }
}