package ru.my.home.workbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader {
    private static Logger LOGGER = LoggerFactory.getLogger(Reader.class);

    @PostConstruct
    public void init() {
        LOGGER.debug("Reader is enable");
    }

    @PreDestroy
    public void shutdown() {
        LOGGER.debug("Reader is disabled");
    }

    /**
     * Чтение существующего Excel файла по имени
     *
     * @param fileName - Имя Excel файла
     * @return Excel файл
     */
    public HSSFWorkbook readWorkbook(String fileName) {
        LOGGER.info("Чтение файла - '{}'", fileName);

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            LOGGER.debug("Попытка чтения файла - '{}'", fileName);

            try (POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fileInputStream)) {
                LOGGER.debug("Попытка преобразования в Excel файл - '{}'", fileName);
                return new HSSFWorkbook(poifsFileSystem);

            } catch (IOException e) { //ToDo CreateException
                LOGGER.error("Ошибка преобразования файла - '{}'", e.getMessage());
                e.printStackTrace();
                return null;
            }

        } catch (IOException e) { //ToDo CreateException
            LOGGER.error("Ошибка чтения файла - '{}'", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
