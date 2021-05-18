package by.katsuba.lab5.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Class Subscriber
 *
 * @author Nastassia Katsuba
 * @version 1.0
 */
@Entity(name = "Subscriber")
@Table(name = "subscriber")
public class Subscriber implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Property - id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * Property - name
     */
    @Column(name = "name")
    private String name;
    /**
     * Property - status
     */
    @Column(name = "status")
    private boolean status;
    /**
     * Property - sum
     */
    @Column(name = "sum")
    private float sum;
    /**
     * Property - services
     */
    @ManyToMany
    @JoinTable(
            name = "subscriber_service",
            joinColumns = @JoinColumn(name = "id_subscriber"),
            inverseJoinColumns = @JoinColumn(name = "id_service"))
    private List<Service> services;

    /**
     * Create new object with given values
     *
     * @param id - id
     */
    public Subscriber(long id) {
        this.id = id;
    }

    /**
     * Create new object
     */
    public Subscriber() {

    }

    /**
     * Function for getting field value {@link Subscriber#id}
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Function for setting the value of the field {@link Subscriber#id}
     *
     * @param id - id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Function for getting field value {@link Subscriber#name}
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for setting the value of the field {@link Subscriber#name}
     *
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function for getting field value {@link Subscriber#status}
     *
     * @return status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Function for setting the value of the field {@link Subscriber#status}
     *
     * @param status - status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Function for getting field value {@link Subscriber#sum}
     *
     * @return sum
     */
    public float getSum() {
        return sum;
    }

    /**
     * Function for setting the value of the field {@link Subscriber#sum}
     *
     * @param sum - sum
     */
    public void setSum(float sum) {
        this.sum = sum;
    }

    /**
     * Function for getting field value {@link Subscriber#services}
     *
     * @return services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Function for setting the value of the field {@link Subscriber#services}
     *
     * @param services - services
     */
    public void setServices(List<Service> services) {
        this.services = services;
    }

    /**
     * Function for comparing objects
     *
     * @param o - object to compare
     * @return Returns true - objects are equal, false - objects are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return id == that.id && status == that.status && sum == that.sum && name.equals(that.name);
    }

    /**
     * Function for finding hashCode
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, sum);
    }

    /**
     * Function to write a subscriber to a string
     *
     * @return string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Subscriber: ");
        sb.append("id=").append(id);
        sb.append(", name='").append(name);
        sb.append(", status=").append(status);
        sb.append(", sum=").append(sum);
        return sb.toString();
    }
}
