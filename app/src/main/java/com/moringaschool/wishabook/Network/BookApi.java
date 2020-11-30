package com.moringaschool.wishabook.Network;

import com.moringaschool.wishabook.GoogleBookSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApi {
    @GET("book")
    Call<GoogleBookSearchResponse> getBook(
            @Query("title") String title
            //@Query("term") String term
    );
}
