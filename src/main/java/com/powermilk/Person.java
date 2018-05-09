package com.powermilk;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
    private final String name;
    private final int age;

    Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(age).append(name).build();
    }

    @Override
    @org.jetbrains.annotations.Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Person person = (Person) obj;
        return new EqualsBuilder().append(this.age, person.age).append(this.name, person.name).build();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
