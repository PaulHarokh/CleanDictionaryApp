package by.paulharokh.cleandictionary.feature.data.remote.dto

import by.paulharokh.cleandictionary.feature.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
){
    fun toMeaning():Meaning{
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}