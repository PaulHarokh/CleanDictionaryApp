package by.paulharokh.cleandictionary.feature.data.remote.dto

import by.paulharokh.cleandictionary.feature.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
){
    fun toDefinition():Definition{
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}