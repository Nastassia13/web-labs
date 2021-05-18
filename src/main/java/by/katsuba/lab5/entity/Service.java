package by.katsuba.lab5.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Class Service
 *
 * @author Nastassia Katsuba
 * @version 1.0
 */
@Entity(name = "Service")
@Table(name = "service")
public class Service implements Serializable {
    private static final int serialVersionUID = 1;
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
     * Property - cost
     */
    @Column(name = "cost")
    private float cost;
    /**
     * Property - subscribers
     */
    @ManyToMany(mappedBy = "services")
    private List<Subscriber> subscribers;

    /**
     * Create new object with given values
     *
     * @param id   - id
     * @param name - name
     * @param cost - cost
     */
    public Service(long id, String name, float cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    /**
     * Create new object
     */
    public Service() {

    }

    /**
     * Function for getting field value {@link Service#id}
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Function for setting the value of the field {@link Service#id}
     *
     * @param id - id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Function for getting field value {@link Service#name}
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for setting the value of the field {@link Service#name}
     *
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function for getting field value {@link Service#cost}
     *
     * @return - cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * Function for setting the value of the field {@link Service#cost}
     *
     * @param cost - cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * Function for getting field value {@link Service#subscribers}
     *
     * @return - subscribers
     */
    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    /**
     * Function for setting the value of the field {@link Service#subscribers}
     *
     * @param subscribers - subscribers
     */
    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
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
        Service service = (Service) o;
        return id == service.id && service.cost == cost && name.equals(service.name);
    }

    /**
     * Function for finding hashCode
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost);
    }

    /**
     * Function to write a service to a string
     *
     * @return string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Service: ");
        sb.append("id=").append(id);
        sb.append(", name='").append(name);
        sb.append(", cost=").append(cost);
        return sb.toString();
    }
}
