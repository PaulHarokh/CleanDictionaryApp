package by.paulharokh.cleandictionary.feature.domain.use_case

import by.paulharokh.cleandictionary.core.util.Resource
import by.paulharokh.cleandictionary.feature.domain.model.WordInfo
import by.paulharokh.cleandictionary.feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}