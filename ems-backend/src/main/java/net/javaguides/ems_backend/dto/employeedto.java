package net.javaguides.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class employeedto {
    private  Long id;
    private String firstname;
    private String lastname;
    private  String email;
}
