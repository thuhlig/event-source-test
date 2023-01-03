package de.c4u.eventsourcetest.web.dto

import org.jetbrains.annotations.NotNull

data class MessageRequest(
    @field:NotNull val name: String,
    @field:NotNull val message: String
)
