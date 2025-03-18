package ru.golubev.manager.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CrackHashTask(
    @Id
    val id: ObjectId = ObjectId(),
    val hash: String,
    val maxLength: Int,
    val status: CrackHashTaskStatus = CrackHashTaskStatus.CREATED,
    val subtasks: List<CrackHashSubtask> = emptyList(),
    val result: List<String> = emptyList()
)
