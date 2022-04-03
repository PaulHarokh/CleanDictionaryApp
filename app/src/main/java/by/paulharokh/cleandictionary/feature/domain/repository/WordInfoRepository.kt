package by.paulharokh.cleandictionary.feature.domain.repository

import by.paulharokh.cleandictionary.core.util.Resource
import by.paulharokh.cleandictionary.feature.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}