package by.paulharokh.cleandictionary.feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import by.paulharokh.cleandictionary.feature.domain.model.Meaning
import by.paulharokh.cleandictionary.feature.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            phonetic = phonetic
        )
    }
}
