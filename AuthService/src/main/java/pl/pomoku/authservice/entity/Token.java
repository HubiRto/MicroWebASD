package pl.pomoku.authservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.authservice.enumerated.TokenType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq_generator")
    @SequenceGenerator(name = "token_seq_generator", sequenceName = "token_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;

    private boolean revoked = false;

    private boolean expired = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Token(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
