package tr.com.metea.productservice.domain;

import lombok.*;
import tr.com.metea.commons.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Mete Aydin
 * @since 1.06.2022
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
}
