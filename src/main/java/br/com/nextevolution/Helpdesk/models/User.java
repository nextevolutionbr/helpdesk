package br.com.nextevolution.Helpdesk.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    @NotEmpty(message = "Can not be not empty")
    private String name;
    @Column
    @Email(message = "Please provide valid email")
    @NotEmpty(message = "Can not be not empty")
    private String email;
    @Column
    @NotEmpty(message = "Can not be not empty")
    private String lastName;
    @Column
    @NotEmpty(message = "Can not be not empty")
    @Length(min = 5, message = "You need to provide a password that contains at least 5 caracters")
    private String password;
    @Column
    private boolean active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String email, String lastName, String password, boolean active) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

    public User(long id, String name, String email, String lastName, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
