package guru.springframework.msscbrewery.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Table(name = "CUSTOMER")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime updatedDate;
}
