package com.ameshi.csvupload.csvupload.service.impl;

import com.ameshi.csvupload.csvupload.config.ApplicationConfig;
import com.ameshi.csvupload.csvupload.entities.Employee;
import com.ameshi.csvupload.csvupload.repository.FileUploadRepository;
import com.ameshi.csvupload.csvupload.service.FileUploadingService;
import com.ameshi.csvupload.csvupload.utils.FileStorageUtils;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@Service
public class FileUploadingServiceImpl implements FileUploadingService {

    @Autowired
    FileStorageUtils fileStorageUtils;

    @Autowired
    private ApplicationConfig config;

    @Autowired
    FileUploadRepository fileUploadRepository;


    @Override
    public String fileUploading(MultipartFile file) {

        Pair<Boolean, String> storedPair = fileStorageUtils.storeFile(file);

        if (storedPair.getFirst()) {
            // Read the csv file and then convert in to the entity (Employee)

            // Pass the director along with fileName
            try (Reader reader = new FileReader(config.getUploadDir() + File.separator + storedPair.getSecond())) {
                CsvToBean<Employee> csvToBean=new CsvToBeanBuilder<Employee>(reader)
                        .withType(Employee.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                        .build();

                // Get the entity object
                List<Employee> employee=csvToBean.parse();

                // Store in database
                // create repositoty
                this.fileUploadRepository.saveAll(employee);

            }catch (Exception e) {
                return "Error occurred while reading and writing the file";
            }
        }
        return null;
    }

}
