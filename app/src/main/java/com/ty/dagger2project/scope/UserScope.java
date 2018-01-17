package com.ty.dagger2project.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Lavender on 2018/1/16.
 */
@Scope
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UserScope {
}
