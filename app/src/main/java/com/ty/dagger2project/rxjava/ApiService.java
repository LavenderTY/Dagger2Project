package com.ty.dagger2project.rxjava;

import com.ty.dagger2project.model.GetOrderRes;
import com.ty.dagger2project.scope.UserScope;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hushun on 07/08/2017.
 */

@UserScope
public interface ApiService {

    @POST("GenOrderService.r")
    Observable<GetOrderRes> queryOrderInfo(@Body RequestBody route);
}
