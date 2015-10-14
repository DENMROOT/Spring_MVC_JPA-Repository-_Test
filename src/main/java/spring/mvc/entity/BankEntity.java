package spring.mvc.entity;

/**
 * Created by Денис on 28.02.2015.
 */
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "BANK_TABLE")
public class BankEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    public BankEntity() {
    }

    public BankEntity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}