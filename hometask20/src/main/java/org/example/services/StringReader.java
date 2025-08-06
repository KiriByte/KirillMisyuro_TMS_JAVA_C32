package org.example.services;

import java.sql.SQLException;
import java.util.List;

public interface StringReader {
    List<String> readStrings() throws SQLException;
}
