package by.paulharokh.cleandictionary.feature.presentation

import by.paulharokh.cleandictionary.feature.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
