package by.paulharokh.cleandictionary.feature.di

import android.app.Application
import androidx.room.Room
import by.paulharokh.cleandictionary.feature.data.local.Converters
import by.paulharokh.cleandictionary.feature.data.local.WordInfoDatabase
import by.paulharokh.cleandictionary.feature.data.remote.DictionaryApi
import by.paulharokh.cleandictionary.feature.data.repository.WordInfoRepositoryImpl
import by.paulharokh.cleandictionary.feature.data.util.GsonParser
import by.paulharokh.cleandictionary.feature.domain.repository.WordInfoRepository
import by.paulharokh.cleandictionary.feature.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }

}