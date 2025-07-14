package org.rtm.systemtest.cucumber.tankmaster.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    private final String configFolderPath = System.getProperty("user.dir") + "/src/test/resources/config/GlobalProperties.properties";

    public void readProperties() throws IOException {
        FileReader fileReader = new FileReader(configFolderPath);

        Properties config = new Properties();

         config.load(fileReader);
    }


}
