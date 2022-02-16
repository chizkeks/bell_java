package ru.bellintegrator.practice.organization.view;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


//@ApiModel(description = "Организация")
public class OrganizationView {
    @NotEmpty
    //@ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    //@Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    //@ApiModelProperty(value = "Имя", example = "Иван")
    public String name;

    @NotEmpty(message = "fullName cannot be null")
    public String fullName;

    @NotEmpty(message = "inn cannot be null")
    @Max(12)
    public String inn;

    @NotEmpty(message = "kpp cannot be null")
    @Max(9)
    public String kpp;

    @NotEmpty(message = "address cannot be null")
    public String address;

    @Max(13)
    public String phone;

    public Boolean isActive;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";full_name:" + fullName + ";inn:" + inn + ";kpp:" + kpp + ";address:" +
        address + ";phone:" + phone + ";is_active:" + isActive + "}";
    }
}
