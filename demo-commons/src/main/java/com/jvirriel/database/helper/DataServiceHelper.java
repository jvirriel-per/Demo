package com.jvirriel.database.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jvirriel.database.xml.catalogue.ColumnMetaData;
import com.jvirriel.database.xml.dataset.DataSetParameter;
import com.jvirriel.database.xml.definition.RepositoryXmlDefinition;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.sql.ResultSetMetaData.columnNoNulls;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class DataServiceHelper {
    private static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    private static final String NOT_AVAILABLE = "NA";

    private static final String BLANK = " ";
    private static final String NEW_LINE = "\n";

    private static final String DATE = "DATE";
    private static final String CHAR = "CHAR";
    private static final String TEXT = "TEXT";
    private static final String TIME = "TIME";
    private static final String TIMESTAMP = "TIMESTAMP";

    private static final String DRIVER = "driver";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String URL = "url";

    public static List<Map<String, String>> convertRows(List<Map<String, Object>> rows) {
        if (isNull(rows)) {
            return null;
        }

        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            if (row.isEmpty()) {
                continue;
            }

            result.add(getStrStrMapFromStrObjMap(row));
        }

        return result;
    }

    private static Map<String, String> getStrStrMapFromStrObjMap(Map<String, Object> input) {
        Map<String, String> result = new HashMap<>();

        if (isNull(input)) {
            return null;
        }

        for (Map.Entry<String, Object> entry : input.entrySet()) {
            if (isEmpty(entry.getKey()) || isNull(entry.getValue())) {
                continue;
            }

            if (entry.getValue() instanceof String) {
                result.put(entry.getKey(), (String) entry.getValue());
            } else {
                result.put(entry.getKey(), entry.getValue().toString());
            }
        }

        return result;
    }

    public static Connection getConnection(RepositoryXmlDefinition repository) {
        if (isNull(repository.getConnectionAttribute(DRIVER)) ||
                isNull(repository.getConnectionAttribute(USER)) ||
                isNull(repository.getConnectionAttribute(PASSWORD)) ||
                isNull(repository.getConnectionAttribute(URL))) {
            return null;
        }

        try {
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

            driverManagerDataSource.setDriverClassName(repository.getConnectionAttribute(DRIVER));
            driverManagerDataSource.setUrl(repository.getUrl().asString());
            driverManagerDataSource.setUsername(repository.getConnectionAttribute(USER));
            driverManagerDataSource.setPassword(repository.getConnectionAttribute(PASSWORD));

            return driverManagerDataSource.getConnection();
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<ColumnMetaData> getResultSetMetaData(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();

            List<ColumnMetaData> result = new ArrayList<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                result.add(new ColumnMetaData()
                        .withColumnClass(metaData.getColumnClassName(i))
                        .withColumnName(metaData.getColumnName(i))
                        .withColumnType(metaData.getColumnTypeName(i))
                        .withLength(metaData.getPrecision(i))
                        .withNullable(metaData.isNullable(i) == columnNoNulls)
                        .withReadOnly(metaData.isReadOnly(i))
                        .withWritable(metaData.isWritable(i)));
            }

            return result;
        } catch (SQLException exp) {
            return null;
        }
    }

    public static List<Map<String, Object>> getRowsFromResultSet(ResultSet rs, ResultSetMetaData md) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try {
            Integer columnCount = md.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();

                for (Integer i = 1; i <= columnCount; i++) {
                    String label = md.getColumnLabel(i);

                    Object o = rs.getObject(label);

                    row.put(label, isNull(o) ? NOT_AVAILABLE : o);
                }

                rows.add(row);
            }
        } catch (SQLException e) {
            return null;
        }

        return rows;
    }

    public static String parseParameters(String queryCode, List<DataSetParameter> parameters) {
        String result = queryCode.replace(NEW_LINE, BLANK);

        for (DataSetParameter parameter : parameters) {
            result = result.replace(parameter.getName(), valueByType(parameter.getValue(), parameter.getType()));
        }

        return result;
    }

    private static String valueByType(String value, String type) {
        Boolean isDate = !type.contains(TIMESTAMP) && (type.contains(DATE) || type.contains(TIME));
        Boolean isText = type.contains(CHAR) || type.contains(TEXT);

        if (isDate || isText) {
            return format("'%s'", value);
        }

        return value;
    }

    public static Result resultFromJson(String json) {
        return gson.fromJson(json, Result.class);
    }

    public static String resultToJson(Result result) {
        return gson.toJson(result);
    }
}
