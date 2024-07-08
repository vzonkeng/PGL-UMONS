package be.umons_project.pgl_back_end.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.sound.midi.MetaEventListener;
import java.lang.annotation.Documented;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@Column(unique = true) // pour specifier que chauqe login est unique
    private String login;

    private String FirstName;
    private String LastName;
    private String address;
    private String role;
    private String inscriptionDate;
    private String password;


}
