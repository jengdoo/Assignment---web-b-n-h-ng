package com.fpoly.assignmentjava6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userCode")
    private String userCode;
    @Column(name = "informationName")
    private String name;
    @Column(name = "birthDay")
    private LocalDate birthDay;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "sex")
    private Boolean sex;
    @Column(name = "userName")
    private String username;
    @Column(name = "passWords")
    private String password;
    @Column(name = "userStatus")
    private Boolean status;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<RoleUser> userRoles;
}
