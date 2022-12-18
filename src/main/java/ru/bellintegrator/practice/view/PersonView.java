package ru.bellintegrator.practice.view;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class PersonView {
    @NotEmpty
    //@ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    //@Size(max = 50)
    @NotEmpty(message = "First name cannot be null")
    //@ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    public String middleName;

    @NotEmpty(message = "Surname cannot be null")
    public String surname;

    @Max(128)
    public String jobTitle;

    public String phone;

    @Max(13)
    public Boolean isIdentified;

}
