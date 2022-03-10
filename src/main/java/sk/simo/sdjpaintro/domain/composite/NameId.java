package sk.simo.sdjpaintro.domain.composite;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
//embeddable annotation is needed in order to embeddedId in AuthorEmbedded
public class NameId implements Serializable {
    private String firstName;
    private String lastName;

    public NameId() {
    }

    public NameId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameId nameId = (NameId) o;
        return firstName.equals(nameId.firstName) && lastName.equals(nameId.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
