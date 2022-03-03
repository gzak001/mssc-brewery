package guru.springframework.msscbrewery.domain;




import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;


@Entity
@Table(name = "BEER")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Beer {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime updatedDate;
}