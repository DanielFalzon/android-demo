package com.example.greetingcard.di
import com.example.greetingcard.data.api.FactionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFactionApi(): FactionApi {
        val client = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .build()

        return Retrofit.Builder()
            .baseUrl("http://192.168.68.61/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(FactionApi::class.java)
    }
}