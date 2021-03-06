package iitu.midterm.demo.entities;

import iitu.midterm.demo.models.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Override
    public String getAuthority() {
        return name.toString();
    }
}
