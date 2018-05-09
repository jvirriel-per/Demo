package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

public class CriteriaCondition {
    private String name;
    private String displayName;

    public CriteriaCondition(String name, String displayName) {
        this.setName(name);
        this.setDisplayName(displayName);
    }

    public CriteriaCondition(String name) {
        this(name, name);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.displayName;
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this.name == null?0:this.name.hashCode());
        return result1;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            CriteriaCondition other = (CriteriaCondition)obj;
            if(this.name == null) {
                if(other.name != null) {
                    return false;
                }
            } else if(!this.name.equals(other.name)) {
                return false;
            }

            return true;
        }
    }
}