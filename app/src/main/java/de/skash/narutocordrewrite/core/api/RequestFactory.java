package de.skash.narutocordrewrite.core.api;

import com.google.gson.Gson;
import de.skash.narutocordrewrite.core.api.util.RequestRoute;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class RequestFactory {
    private static final Logger LOG = LoggerFactory.getLogger(RequestFactory.class);
    private static final String BASE_ROUTE = "http://127.0.0.1:8080/api/";

    private final Gson gson = new Gson();
    private final OkHttpClient httpClient = createHttpClient();

    public <E> ApiRequest<E> createRequest(RequestRoute route, String query, @Nullable RequestBody body) {
        var requestBuilder = new Request.Builder()
                .url(BASE_ROUTE + query);

        var request = setRequestType(requestBuilder, route, body).build();

        return new ApiRequest<>(
                request,
                httpClient,
                gson,
                route
        );
    }

    public <T> RequestBody mapToJsonBody(T model) {
        var bodyString = gson.toJson(model);
        return RequestBody.create(bodyString.getBytes(StandardCharsets.UTF_8));
    }

    private OkHttpClient createHttpClient() {
        return new OkHttpClient()
                .newBuilder()
                .connectionPool(
                        new ConnectionPool(5, 5, TimeUnit.SECONDS)
                )
                .addInterceptor(new HttpLoggingInterceptor(LOG::info)
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    private Request.Builder setRequestType(Request.Builder requestBuilder, RequestRoute route, RequestBody requestBody) {
        switch (route.getRequestType()) {
            case GET:
                return requestBuilder.get();
            case PUT:
                if (requestBody == null) break;
                return requestBuilder.put(requestBody);
            case POST:
                if (requestBody == null) break;
                return requestBuilder.post(requestBody);
            case DELETE:
                return requestBuilder.delete();
        }
        throw new IllegalArgumentException("RequestBody may not be null");
    }
}
