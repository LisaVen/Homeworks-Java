package com.company;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

interface ReportGenerator<T> {
    Report generate(List<T> entities);
}

interface Report {
    byte[] asBytes();

    void writeTo(OutputStream os) throws IOException;
}

public class Generator implements Report, ReportGenerator{

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    @Override
    public void writeTo(OutputStream os) throws IOException {
        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
        assertTrue(csvOutputFile.exists());
    }


    @Override
    public byte[] asBytes() {
        return new byte[0];
    }

    @Override
    public Report generate(List entities) {
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]
                { "John", "38" });
        dataLines.add(new String[]
                { "Jane", "19" });
        return (Report) dataLines;
    }
}