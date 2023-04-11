package com.praneeth.RecruitmentApp.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ControllerAdvice
public class HandlePrevRoute {
    private boolean err;

    @ModelAttribute("error")
    public boolean error() {
        return err;
    }
    @ExceptionHandler(MyExceptionHandlerPrevRoute.class)
    public String handleRouteOnException(MyExceptionHandlerPrevRoute ex, HttpServletRequest request){
        err = true;
        String previousRoute = request.getHeader("referer");

        // Extract the path from the previous route
        URI previousUri = URI.create(previousRoute);
        String previousPath = previousUri.getPath();

        // Get the base URL for the redirect
        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();

        // Build the redirect URL using the base URL and the previous path
        String redirectUrl = ServletUriComponentsBuilder.fromUriString(baseUrl)
                .path(previousPath)
                .build()
                .toUriString();

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            err = false;
        }, 10, TimeUnit.SECONDS);

        return "redirect:" + redirectUrl;
    }
}
