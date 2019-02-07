package com.app.dbperform.service;

import com.app.dbperform.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LoaderService {
    private final EntityManagerFactory emf;

    @Autowired
    public LoaderService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public String loadFile(MultipartFile multipartFile) {
        long start = System.currentTimeMillis();

        EntityManager entityManager = emf.createEntityManager();

        entityManager.setFlushMode(FlushModeType.COMMIT);

        int batchSize = 50;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            List<Train> trainList = new ArrayList<>();
            String line;
            if (((line = br.readLine()) != null)) {
                int i = 0;
                while ((line = br.readLine()) != null) {
                    if (i == 0) {
                        entityManager.getTransaction().begin();
                    }
                    i++;
                    // split on comma(',')
                    String[] personCsv = line.split(",");

                    // create car object to store values
//                    Train train = new Train(
//                            Long.parseLong(personCsv[0]),
//                            personCsv[1],
//                            Integer.parseInt(personCsv[2]),
//                            Integer.parseInt(personCsv[3]),
//                            Integer.parseInt(personCsv[4]),
//                            Integer.parseInt(personCsv[5]),
//                            Integer.parseInt(personCsv[6]),
//                            Double.parseDouble(personCsv[7]),
//                            Integer.parseInt(personCsv[8]),
//                            Short.parseShort(personCsv[9]),
//                            Integer.parseInt(personCsv[10]),
//                            Integer.parseInt(personCsv[11]),
//                            personCsv[12],
//                            personCsv[13],
//                            Integer.parseInt(personCsv[14]),
//                            Integer.parseInt(personCsv[15]),
//                            Integer.parseInt(personCsv[16]),
//                            Integer.parseInt(personCsv[17]),
//                            Integer.parseInt(personCsv[18]),
//                            Integer.parseInt(personCsv[19]),
//                            Integer.parseInt(personCsv[20]),
//                            Integer.parseInt(personCsv[21]),
//                            Short.parseShort(personCsv[22]),
//                            Long.parseLong(personCsv[23]),
//                            Integer.parseInt(personCsv[24])
//                    );
                    Train train = new Train(
                            personCsv[0],
                            Integer.parseInt(personCsv[1]),
                            Integer.parseInt(personCsv[2]),
                            Integer.parseInt(personCsv[3]),
                            Integer.parseInt(personCsv[4]),
                            Integer.parseInt(personCsv[5]),
                            personCsv[6].isEmpty() ? 0D : Double.parseDouble(personCsv[6]),
                            Integer.parseInt(personCsv[7]),
                            Short.parseShort(personCsv[8]),
                            Integer.parseInt(personCsv[9]),
                            Integer.parseInt(personCsv[10]),
                            personCsv[11],
                            personCsv[12],
                            Integer.parseInt(personCsv[13]),
                            Integer.parseInt(personCsv[14]),
                            Integer.parseInt(personCsv[15]),
                            Integer.parseInt(personCsv[16]),
                            Integer.parseInt(personCsv[17]),
                            Integer.parseInt(personCsv[18]),
                            Integer.parseInt(personCsv[19]),
                            Integer.parseInt(personCsv[20]),
                            Short.parseShort(personCsv[21]),
                            Long.parseLong(personCsv[22]),
                            Integer.parseInt(personCsv[23])
                    );


                    entityManager.persist(train);
                    if (i % batchSize == 0 && i > 0) {
                        entityManager.flush();
                        entityManager.getTransaction().commit();
                        entityManager.clear();
                        i = 0;
                    }
                }
                if (i > 0) {
                    entityManager.getTransaction().commit();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;
        return Long.toString(time/1000);
    }
}