package ru.bellintegrator.practice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.view.ErrorView;
import ru.bellintegrator.practice.view.ResultView;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ErrorView unhandledException(Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.error = "Ошибка";
        return errorView;
    }

}
