package org.example.io;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.example.model.GeneralInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private XmlWriter(){
    }
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());
    public static void writerXml(GeneralInfo info) {

        try {
            logger.log(Level.INFO, "Marshalling XML starting.");

            JAXBContext context = JAXBContext.newInstance(GeneralInfo.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectories(Paths.get("directoryXml"));
                logger.log(Level.INFO, "Directory created.");
            } catch (IOException e) {
                logger.log(Level.FINE, "Directory already created.", e);
            }

            File fileXml = new File("directoryXml/infoXml" + new Date().getTime() + ".xml");

            marshaller.marshal(info, fileXml);


        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Marshalling XML failed.", e);
            return;
        }
        logger.log(Level.INFO, "Marshalling XML ended.");
    }
}
