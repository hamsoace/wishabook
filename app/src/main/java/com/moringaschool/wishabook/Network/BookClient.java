package com.moringaschool.wishabook.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.wishabook.Constants.BOOK_API_KEY;
import static com.moringaschool.wishabook.Constants.BOOK_BASE_URL;

public class BookClient {
    private static Retrofit retrofit = null;

    public static BookApi getClient() {

        if (retrofit == null){
            Interceptor interceptor;
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization", BOOK_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder().baseUrl(BOOK_BASE_URL).client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit.create(BookApi.class);
    }

}
