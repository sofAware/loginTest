package com.example.test.entity;

import com.example.test.VO.UserVO;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user") //table 명
public class User extends UserVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private long id;

    @Column(nullable = false, unique = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Builder
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
