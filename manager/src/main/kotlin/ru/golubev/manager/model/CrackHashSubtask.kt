package ru.golubev.manager.model

import java.util.*

data class CrackHashSubtask(
    val id: UUID,
    val partNumber: Int,
    val totalParts: Int,
    val status: CrackHashTaskStatus = CrackHashTaskStatus.CREATED,
    val result: List<String> = emptyList()
)
