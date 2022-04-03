package by.paulharokh.cleandictionary.feature.data.remote.dto

import by.paulharokh.cleandictionary.feature.data.local.entity.WordInfoEntity

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String?,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            word = word,
            phonetic = phonetic ?: ""
        )
    }
}