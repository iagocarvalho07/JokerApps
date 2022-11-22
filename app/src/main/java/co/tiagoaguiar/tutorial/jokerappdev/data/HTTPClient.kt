package co.tiagoaguiar.tutorial.jokerappdev.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HTTPClient {

  private const val BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"
  const val API_KEY = "6fec191e-1531-48c2-bc07-67f070927685"

  private fun httpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
      .addInterceptor(logging)
      .build()
  }

  fun retrofit() = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(httpClient())
    .build()

}