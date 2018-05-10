package com.powermilk;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class Student extends Person {
    private final String school;

    Student(final String name, final int age, final String school) {
        super(name, age);
        this.school = school;
    }

    Student() {
        super(null, 0);
        this.school = null;
    }

    public String getSchool() {
        return school;
    }

    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode())
                .append(school).build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Student student = (Student) obj;
        return new EqualsBuilder().appendSuper(super.equals(student))
                .append(this.school, student.school).build();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
