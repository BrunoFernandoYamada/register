package br.com.byamada.register.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO implements CommonDTO{

    private String name;
    private String Document;
    private int age;
    private boolean isActive;

    @Override
    public String getType() {
        return "CustomerDTO";
    }
}
