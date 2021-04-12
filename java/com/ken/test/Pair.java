package com.ken.test;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(){ first = null; second = null;}
    public Pair(T first, T secod){this.first = first; this.second = secod;}

    public T getFirst(){return first;}
    public T getSecond(){return second;}

    public void setFirst(T newValue){ this.first = newValue;}
    public void setSecond(T newValue){ this.second = newValue;}
}
