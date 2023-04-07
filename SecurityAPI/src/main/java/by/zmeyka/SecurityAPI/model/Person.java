package by.zmeyka.SecurityAPI.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")

    //@Size(min=2, max = 15,message = "can't be this size")
    private String username;
    @Column(name="year_of_birth")
    //@NotEmpty(message = "can't be empty")
    private int year_of_birth;
    @Column(name="password")
   // @NotEmpty(message = "can't be empty")
    private String password;
}
