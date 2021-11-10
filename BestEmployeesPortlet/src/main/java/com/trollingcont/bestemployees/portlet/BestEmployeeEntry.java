package com.trollingcont.bestemployees.portlet;

import com.trollingcont.servicebuilder.model.Employee;

public class BestEmployeeEntry {

    private final Employee employee;
    private final long cost;

    public BestEmployeeEntry(Employee employee, long cost) {
        this.employee = employee;
        this.cost = cost;
    }

    public Employee getEmployee() {
        return employee;
    }

    public long getCost() {
        return cost;
    }
}
