package org.example.service;

public class SomeServiceImpl implements SomeService{
    @Override
    public void doSome(String name) {
        System.out.println("运行了"+name);
    }
}
