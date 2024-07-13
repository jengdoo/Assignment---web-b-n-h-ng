package com.fpoly.assignmentjava6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_user")
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "rolo_id",referencedColumnName = "id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    private User user;
}
