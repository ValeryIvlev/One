package org.first.filetest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = FileTest.class.getResourceAsStream("/js.json");
        JsonModel js = objectMapper.readValue(is, JsonModel.class);
        assertEquals("6563179628bd986edf725c68", js.getId());
        assertEquals("6e6c2c65-8582-4b34-80a6-54a7fc7e5e1c", js.getGuid());
        assertEquals(7, js.getTags().size());
    }
}