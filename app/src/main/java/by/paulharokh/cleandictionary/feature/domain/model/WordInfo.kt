package by.paulharokh.cleandictionary.feature.domain.model

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic:String?,
    val word: String
)
