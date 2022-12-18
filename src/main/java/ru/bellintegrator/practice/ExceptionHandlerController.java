package ru.bellintegrator.practice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.view.ErrorView;
import ru.bellintegrator.practice.view.ResultView;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorView handleConstraintViolationException (DataIntegrityViolationException dive){
        ErrorView errorView = new ErrorView();
        errorView.error = "Не все обязательные поля заполнены";
        return  errorView;
    }

    @ExceptionHandler(NoResultException.class)
    public ErrorView handleNoResultException (NoResultException ne) {
        ErrorView errorView = new ErrorView();
        errorView.error=  "Не подходящих записей в базе данных";
        return errorView;
    }
}
