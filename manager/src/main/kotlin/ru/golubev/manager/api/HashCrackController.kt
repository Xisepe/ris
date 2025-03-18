package ru.golubev.manager.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.golubev.manager.api.dto.request.CrackHashRequest
import ru.golubev.manager.api.dto.response.CrackHashResponse

@RestController
class HashCrackController(
) {

    @PostMapping("/api/hash/crack")
    fun crackHash(request: CrackHashRequest): CrackHashResponse {

    }
}