package ru.golubev.manager.api.dto.request

import jakarta.validation.constraints.Positive

data class CrackHashRequest(
    val hash: String,
    @Positive
    val maxLength: Int
)
