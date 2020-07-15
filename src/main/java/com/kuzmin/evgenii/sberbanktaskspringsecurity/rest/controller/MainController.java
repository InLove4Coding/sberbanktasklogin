package com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.controller;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.Session;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.response.ErrorResponse;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.response.ErrorResponseEnum;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.response.Response;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.security.auth.login.CredentialException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final SessionService sessionService;

    @PostMapping(path = "/auth/login")
    public Response<Session> login(@RequestParam String login, @RequestParam String password) {
        Response<Session> response = new Response<>();
        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            return createErrorResponse(response);
        }
        try {
            response.setResult(sessionService.login(login, password));
        } catch (CredentialException e) {
            return createErrorResponse(response);
        }
        return response;
    }

    @PostMapping(path = "/auth/logout/{sessionId}")
    public void logoutSession(@PathVariable UUID sessionId) {

    }

    @GetMapping(path = "/auth/session/{login}")
    public Response<List<Session>> getActiveSession(@PathVariable String login) {
        Response<List<Session>> response = new Response<>();
        List<Session> activeSession = sessionService.getActiveSession(login);
        response.setResult(activeSession);
        return response;
    }

    private Response<Session> createErrorResponse(Response<Session> response) {
        response.setErrorResponse(ErrorResponse.builder()
                .statusCode(ErrorResponseEnum.INVALID_CREDENTIALS.getCode())
                .statusDescription(ErrorResponseEnum.INVALID_CREDENTIALS.getDescription()).build());
        return response;
    }
}
