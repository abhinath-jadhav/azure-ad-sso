package com.azure.sso.first.annoatation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GroupsAllowed {
    String value();
}