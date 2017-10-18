package com.example.it.hww.http;

public interface IHttpClient {

    void request(String url, HttpClient.ResponseListener listener);
}
