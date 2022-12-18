package ru.bellintegrator.practice.view;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class OfficeView {
    @NotEmpty
    //@ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    //@Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    //@ApiModelProperty(value = "Имя", example = "Иван")
    public String name;


    @NotEmpty(message = "address cannot be null")
    public String address;

    @Max(13)
    public String phone;

    public Boolean isActive;

    public Long orgID;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";full_name:" + "address" + address + ";phone:" + phone + ";is_active:" + isActive + "}";
    }
}
