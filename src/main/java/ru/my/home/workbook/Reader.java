package ru.my.home.workbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;

public class Reader {

    public HSSFWorkbook readWorkbook(String fileName) {

        try {
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(fileName));
            return new HSSFWorkbook(poifsFileSystem);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
