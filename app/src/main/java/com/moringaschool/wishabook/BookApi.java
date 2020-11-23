package com.moringaschool.wishabook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApi {
    @GET("book/search")
    Call<GoogleBookSearchResponse> getBook(
            @Query("title") String title,
            @Query("term") String term
    );
}
