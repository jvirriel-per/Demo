package com.jvirriel.database.xml.dataset;

import java.util.List;

public class AvailableDataSets {
    private List<AvailableDataSet> dataSets;

    public AvailableDataSets() {
    }

    public AvailableDataSets(List<AvailableDataSet> dataSets) {
        this.dataSets = dataSets;
    }

    public List<AvailableDataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<AvailableDataSet> dataSets) {
        this.dataSets = dataSets;
    }

    public static class AvailableDataSet {
        private String code;
        private String name;

        public AvailableDataSet() {
        }

        public AvailableDataSet(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
