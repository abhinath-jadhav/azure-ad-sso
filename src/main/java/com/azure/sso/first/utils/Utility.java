package com.azure.sso.first.utils;

import com.azure.sso.first.annoatation.GroupsAllowed;
import com.azure.sso.first.controller.AdminController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Utility {

    @Autowired
    private JwtDecoder jwtDecoder;

    public void validateGroups(String jwt,Class<?> targetClass, String method) {

        List<String> groupsAllowed = getGroupsAllowedValue(method, targetClass);
        log.info("token: {}", jwt);
        log.info("Groups: {}", groupsAllowed);
        List<String> jwtGroups = jwtDecoder.decode(jwt).getClaim("groups");
        List<String> groups = getGroupsForGroupId(jwtGroups);
        if(groups.isEmpty() || jwtGroups.isEmpty()){
            throw new RuntimeException("Invalid request");
        }
        List<String> groupsTrimmed = groups.stream().map(String::trim).collect(Collectors.toList());

        //TODO update code
        if(groupsAllowed != null && groupsAllowed.size() > 1){
            return;
        }

        Optional<String> first = jwtGroups.stream().filter(o -> {
            ResponseEntity<Object> forEntity = new RestTemplate().getForEntity("", Object.class);

            //TODO update as per response
            Object body = forEntity.getBody();
            return groupsTrimmed.contains(body);
        }).findFirst();

        if(first.isEmpty()){
            throw new RuntimeException("Invalid Groups");
        }
    }

    private List<String> getGroupsForGroupId(List<String> groupIds){
        List<String> list = new ArrayList<>();
        for(String groupId: groupIds){
            list.add(groupId);
        }
        return list;
    }

    private List<String> getGroupsAllowedValue(String methodName, Class<?> targetClass) {
        try {
            Method method = targetClass.getMethod(methodName);
            GroupsAllowed groupsAllowed = method.getAnnotation(GroupsAllowed.class);
            if (groupsAllowed != null) {
                String[] split = groupsAllowed.value().split(",");
                return Arrays.stream(split).map(String::trim).collect(Collectors.toList());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
