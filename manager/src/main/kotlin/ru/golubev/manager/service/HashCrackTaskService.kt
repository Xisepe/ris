package ru.golubev.manager.service

import ru.golubev.manager.model.CrackHashTask
import java.util.UUID

interface HashCrackTaskService {
    /**
     * Creates a task to break [hash] of [maxLength].
     * Returns [UUID] of created Task can be used to receive status
     */
    fun createHashCrackTask(hash: String, maxLength: Int): CrackHashTask
}