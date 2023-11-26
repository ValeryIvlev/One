package org.first.fileTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {
    private ClassLoader cl = FileTest.class.getClassLoader();

    @Test
    void zipParseTest() throws Exception {

        try (
                InputStream is = cl.getResourceAsStream("myZip.zip");
                ZipInputStream zis = new ZipInputStream(is)
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String entryName = entry.getName();
                if (entryName.contains(".xlsx")) {
                    XLS content = new XLS(zis);
                    assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).contains("Target");
                } else if (entryName.contains(".pdf")) {
                    PDF content = new PDF(zis);
                    assertThat(content.text).contains("PDF");
                } else if (entryName.contains(".csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = reader.readAll();
                    assertThat(content.get(0)[0]).contains("One");
                }
            }
        }
    }
    @Test
    void jsonTest() throws Exception {
        InputStream inputStream = FileTest.class.getResourceAsStream("/js.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {});
        assertThat(map.get("_id").equals("6563179628bd986edf725c68"));
        assertThat(map.get("index").equals("0"));
        assertThat(map.get("isActive").equals(true));
        assertThat(map.get("tags").equals(new String[]{
                        "dolore",
                "proident",
                "commodo",
                "ullamco",
                "eiusmod",
                "quis",
                "commodo"
  }));
    }
}