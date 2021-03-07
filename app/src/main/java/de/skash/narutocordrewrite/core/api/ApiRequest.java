package de.skash.narutocordrewrite.core.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import de.skash.narutocordrewrite.core.api.util.RequestRoute;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.function.Consumer;

public class ApiRequest<E> {
    private static final Logger LOG = LoggerFactory.getLogger(ApiRequest.class);
    private final Request request;
    private final OkHttpClient httpClient;
    private final Gson gson;
    private final RequestRoute route;

    protected ApiRequest(
            Request request,
            OkHttpClient httpClient,
            Gson gson,
            RequestRoute route
    ) {
        this.request = request;
        this.httpClient = httpClient;
        this.gson = gson;
        this.route = route;
    }

    public void executeAsync(Consumer<E> success, Consumer<Throwable> failure) {
        handleAsyncExecution(success, failure);
    }

    public E execute() {
        return handleSyncExecution();
    }

    private void handleAsyncExecution(Consumer<E> success, Consumer<Throwable> failure) {
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                failure.accept(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                var statusCode = response.code();
                var body = response.body();

                if (statusCode != 200) {
                    failure.accept(new Throwable("Request returned wrong status code"));
                    return;
                }

                if (route.getType() == Void.TYPE) {
                    return;
                }

                if (body == null) {
                    failure.accept(new Throwable("Body may not be null"));
                    return;
                }

                var responseObject = mapJsonToObject(body);

                if (responseObject == null) {
                    failure.accept(new Throwable("Unable to parse body"));
                    return;
                }

                success.accept(responseObject);
            }
        });
    }

    private E handleSyncExecution() {
        ResponseBody responseBody;
        try {
            responseBody = httpClient.newCall(request).execute().body();
        } catch (IOException e) {
            LOG.debug("Request failed");
            return null;
        }

        if (route.getType() == Void.TYPE) {
            return null;
        }

        if (responseBody == null) {
            LOG.debug("Body may not be null");
            return null;
        }

        return mapJsonToObject(responseBody);

    }

    private E mapJsonToObject(ResponseBody responseBody) {
        try {
            var jsonObject = gson.fromJson(responseBody.string(), JsonObject.class);
            var element = jsonObject.get(route.getJsonKey());
            return gson.fromJson(element, route.getType());
        } catch (IOException e) {
            LOG.debug("Failed to parse {}", route.getType().getTypeName());
            return null;
        }
    }
}
