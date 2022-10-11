package ru.exdata.moex.response;

public interface ResponseMapper<T> {

    T map(String content);

}
