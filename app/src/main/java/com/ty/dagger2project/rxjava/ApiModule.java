package com.ty.dagger2project.rxjava;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ty.dagger2project.contact.Contact;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lavender on 2018/1/11.
 */
@Module
public class ApiModule {

    private static final long CACHE_SIZE = 10 * 1024 * 1024; //10 MB
    private static final long TIME_OUT = 60; //请求超时

    @Provides
    @Singleton
    public HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }


    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Cache provideOkhttpCache(Application application) {
        return new Cache(application.getCacheDir(), CACHE_SIZE);
    }

    @Provides
    @Singleton
    Interceptor provideCacheOverrideInterceptor() {
        return chain -> {
            int maxStale = 60 * 60 * 24 * 7; // tolerate 1-week stale
            return chain.proceed(chain.request())
                    .newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-age=" + maxStale)
                    .build();
        };
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache,
                                     Interceptor cacheOverrideInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(cacheOverrideInterceptor);
        return builder
                .build();

    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Contact.BASE_URL)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public ApiService providePokemonService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
