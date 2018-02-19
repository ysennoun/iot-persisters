package com.xebia.iot.persister;

public abstract class Persister {

    public abstract void persiste(String data);

    public abstract void close();
}
