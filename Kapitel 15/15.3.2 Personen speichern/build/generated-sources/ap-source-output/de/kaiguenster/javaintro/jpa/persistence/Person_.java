package de.kaiguenster.javaintro.jpa.persistence;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-05-11T10:05:38", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> titel;
    public static volatile SingularAttribute<Person, String> vorname;
    public static volatile SingularAttribute<Person, String> nachname;
    public static volatile SingularAttribute<Person, Long> id;

}