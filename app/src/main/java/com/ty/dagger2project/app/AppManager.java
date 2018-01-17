package com.ty.dagger2project.app;

import android.app.Activity;

import com.ty.dagger2project.model.GetOrderRes;
import com.ty.dagger2project.rxjava.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Lavender on 2018/1/12.
 * Flowable:是Observable的2.0版本，2.0以后，Observable 不再支持背压，而Flowable 支持非阻塞式的背压。并且规范要求，所有的操作符强制支持背压
 * concat:不交错的发射两个或多个Observable,concat操作符连接多个Observable的输出，
 * 就好像它们是一个Observable，第一个Observable发射的所有数据在第二个Observable发射的任何数据
 * 前面，以此类推。直到前面一个Observable终止，Concat才会订阅额外的一个Observable
 * take:操作符和interval操作符联合使用，由于一旦interval计时开始除了解绑就无法停止，
 * 所以只有在onNext方法中计算一旦释放到10秒的时候再进行解绑从而终结该计时。
 * 但使用take操作符就简单很多了，它的意思是只释放前N项，和计时配合使用的话，
 * 就可以不用担心计时会一直执行，10秒过后它会自动结束。take()输出最多指定数量的结果。
 * doOnNext():允许我们在每次输出一个元素之前做一些额外的事情，比如这里的保存标题。
 */

@Singleton
public class AppManager implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    //RxJava的接口
    private final ApiService service;
    //Subcomponent
    private final UserComponent.Builder userComponentBuilder;

    private GetOrderRes resCache;

    private UserComponent userComponent;

    @Inject
    public AppManager(ApiService service, UserComponent.Builder builder) {
        this.service = service;
        this.userComponentBuilder = builder;
    }

    public void setInjector(){
        userComponent = userComponentBuilder.build();
        userComponent.inject(this);
    }

//    public Flowable<Pokemon> loginWithUserName(String userName) {
//        //concatWith 将两个Maybe链接起来
//        return getPokemonMaybeFromCache()
//                .concatWith(service.getPokemon(userName).toMaybe())
//                .take(1)
//                .doOnNext(this::createUserSession);
//    }

//    private void createUserSession(Pokemon pokemon) {
//        userComponent = userComponentBuilder
//                .pokeMon(pokemon)
//                .build();
//        userComponent.inject(this);
//    }


//    // 2.X新增，行为类似Observable，可能会有一个数据或一个错误，也可能什么都没有。
//    // 可以将其视为一种返回可空值的方法。这种方法如果不抛出异常的话，将总是会返回一些东西，
//    // 但是返回值可能为空，也可能不为空。按照Reactive Streams规范设计，
//    // 遵循协议onSubscribe (onSuccess/onError/onComplete)
//    private Maybe<Pokemon> getPokemonMaybeFromCache() {
//        if (pokemonCache != null) {
//            //创建Maybe事件队列
//            return Maybe.just(pokemonCache);
//        } else {
//            return Maybe.empty();
//        }
//    }

    public boolean isLoggedIn() {
        return userComponent != null;
    }

    public void logOut() {
        resCache = null;
        userComponent = null;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
