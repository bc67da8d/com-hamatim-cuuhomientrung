package com.hamatim.cuuhomientrung.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LamdaNetCallback<T> implements Callback<T> {

    private ResponseHandle<T> responseHandle;
    private FailHandle<T> failHandle;

    public static <T> LamdaNetCallback<T> getInstance(ResponseHandle<T> responseHandle, FailHandle<T> failHandle){
        return new LamdaNetCallback(responseHandle, failHandle);
    }

    public LamdaNetCallback(ResponseHandle<T> responseHandle, FailHandle<T> failHandle) {
        this.responseHandle = responseHandle;
        this.failHandle = failHandle;
    }

    public void onFailure(Call<T> call, Throwable t) {
        failHandle.handle(t);
    }

    public void onResponse(Call<T> call, Response<T> response) {
        responseHandle.handle(response);
    }

    public interface ResponseHandle<T> {
        void handle(Response<T> response);
    }

    public interface FailHandle<T> {
        void handle(Throwable t);
    }

}
