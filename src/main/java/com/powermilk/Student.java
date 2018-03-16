package com.powermilk;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

class Student extends Person {
    private final String school;

    public Student(final String name, final int age, final String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode())
                .append(school).toHashCode();
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
                .append(this.school, student.school).isEquals();
    }
}
