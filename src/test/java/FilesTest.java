import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import model.Quiz;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesTest {

    private static final List<String> fileNames = List.of("eng_words.csv", "eng_words.xlsx", "RESTful-API-design-OCTO-Quick-Reference-Card-2.2.pdf");

    ClassLoader cl = FilesTest.class.getClassLoader();

    @Test
    public void zipParseTest() throws Exception {
        try (
                InputStream io = cl.getResourceAsStream("zip/test_files.zip");
                ZipInputStream zis = new ZipInputStream(io)
        ) {
            List<ZipEntry> zipEntryList = new ArrayList<>();
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                zipEntryList.add(zipEntry);
            }

            for (ZipEntry ze: zipEntryList) {
                assertThat(fileNames).contains(ze.getName());
            }
        }
    }

    @Test
    public void pdfParseTest() throws Exception {
        File file = new File("src/test/resources/zip/test_files.zip");
        ZipFile zipFile = new ZipFile(file, StandardCharsets.UTF_8);
        ZipEntry ze = zipFile.getEntry("RESTful-API-design-OCTO-Quick-Reference-Card-2.2.pdf");
        try (InputStream inputStream = zipFile.getInputStream(ze)) {
            PDF pdf = new PDF(inputStream);
            assertThat(pdf).isNotNull();
            assertThat(pdf.text).contains("OCTO");
        }
    }

    @Test
    void xlsxParseTest() throws Exception {
        File file = new File("src/test/resources/zip/test_files.zip");
        ZipFile zipFile = new ZipFile(file, StandardCharsets.UTF_8);
        ZipEntry ze = zipFile.getEntry("eng_words.xlsx");
        try (InputStream inputStream = zipFile.getInputStream(ze)) {
            XLS content = new XLS(inputStream);
            assertThat(content.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).contains("дом");
            assertThat(content.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).contains("house");
        }
    }

    @Test
    void csvParseTest() throws Exception {
        File file = new File("src/test/resources/zip/test_files.zip");
        ZipFile zipFile = new ZipFile(file, StandardCharsets.UTF_8);
        ZipEntry ze = zipFile.getEntry("eng_words.csv");
        try (InputStream inputStream = zipFile.getInputStream(ze)) {
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            List<String[]> content = reader.readAll();
            assertThat(content.get(0)[1]).contains("house");
            assertThat(content.get(1)[1]).contains("road");
        }
    }

    @Test
    void jsonParseTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (
                InputStream is = cl.getResourceAsStream("json_test.json");
                InputStreamReader isr = new InputStreamReader(is)
        ) {
            Quiz quiz = objectMapper.readValue(isr, Quiz.class);
            assertThat(quiz.questions[0].question).isEqualTo("Which city is the capital of Spain?");
            assertThat(quiz.questions[0].options).hasSize(4);
            assertThat(quiz.questions[0].answer).isEqualTo("Madrid");
        }
    }
}
