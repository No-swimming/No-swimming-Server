package com.example.noswimmingserver.domain.reading_journal.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateReadingJournalRequest(

    @field:NotBlank
    @Size(max = 50)
    val title: String,

    @field:NotBlank
    @Size(max = 5000)
    val content: String,

    @field:NotNull
    val teacherId: Long,
)
