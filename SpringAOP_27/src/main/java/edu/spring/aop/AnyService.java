package edu.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnyService implements APIService {

    @Autowired
    APIComponent apiComponent;

    public String executeMethodService(String s, int i, Object o) {
        return apiComponent.executeMethod(s, i, o);
    }

}
