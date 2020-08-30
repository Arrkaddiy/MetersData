package ru.my.home.workbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
    private static Logger LOGGER = LoggerFactory.getLogger(Writer.class);

    /**
     * Запись нового Excel файла по имени
     *
     * @param workbook - Excel файл
     * @param fileName - Имя файла
     */
    public void writeWorkbook(HSSFWorkbook workbook, String fileName) {
        LOGGER.info("Запись файла - '{}'", fileName);

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            LOGGER.debug("Попытка записи файла - '{}'", fileName);
            workbook.write(fileOutputStream);

        } catch (IOException e) { //ToDo CreateException
            LOGGER.error("Ошибка записи файла - '{}'", e.getMessage());
            e.printStackTrace();
        }
    }
}
