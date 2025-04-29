package net.javaguides.ems_backend.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class employee {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
@Column(name = "firstname")
    private String firstname;
@Column(name="lastname")
    private String lastname;
@Column(name = "email")
    private String email;
}
