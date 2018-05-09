package com.jvirriel.database.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Result {
    private List<Map<String, String>> rows;

    public Result() {
        this.rows = new ArrayList<>();
    }

    public Result(List<Map<String, String>> rows) {
        this.rows = rows;
    }

    public Result(Result result) {
        this.rows = result.rows;
    }

    public void addRow(Map<String, String> row) {
        this.rows.add(row);
    }

    public List<Map<String, String>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, String>> rows) {
        this.rows = rows;
    }

    public Result withRow(Map<String, String> row) {
        this.rows.add(row);

        return this;
    }

    public Result withRows(List<Map<String, String>> rows) {
        this.rows = rows;

        return this;
    }
}
