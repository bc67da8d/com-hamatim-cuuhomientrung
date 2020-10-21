package com.hamatim.cuuhomientrung.provider;

import java.util.HashMap;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.hamatim.cuuhomientrung.util.Constant.BASE_URL;
import static com.hamatim.cuuhomientrung.util.Tls12SocketFactory.enableAllTLS;

public class ProviderAPI {

    private Retrofit retrofit;
    private static ProviderAPI instance;
    private HashMap<String, Object> cached;

    private ProviderAPI() {
        cached = new HashMap<>();
    }

    public static ProviderAPI getInstance() {
        if (null == instance) {
            instance = new ProviderAPI();
        }
        return instance;
    }

    public static <T> T get(final Class<T> service) {
        return getInstance().getApi(service);
    }

    private <T> T getApi(final Class<T> service) {
        if (null == cached.get(service.getCanonicalName())) {
            cached.put(service.getCanonicalName(), getRetrofit().create(service));
        }
        return (T) cached.get(service.getCanonicalName());
    }

    private Retrofit getRetrofit() {
        if (null == retrofit) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build();
        }
        return retrofit;
    }

    public OkHttpClient getHttpClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        enableAllTLS(httpClient);
        return httpClient.build();
    }

}
