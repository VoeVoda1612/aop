package edu.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class AnyComponent implements APIComponent{
    public String executeMethod(String s, int i, Object o) {
        return "executeMethodService";
    }
}
