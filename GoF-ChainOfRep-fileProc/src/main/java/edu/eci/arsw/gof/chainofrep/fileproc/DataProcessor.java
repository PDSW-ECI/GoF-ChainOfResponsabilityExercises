/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author hcadavid
 */


public class DataProcessor{

    public void loadAndProcessData(String fileName) throws DataLoadException{
        
        LOG.info("Loading data...");
        
        
        if (extension(fileName).equals("xml")){
            processXML(fileName);                
        }
        else if (extension(fileName).equals("csv")){
            processCSV(fileName);                
        }
        else if (extension(fileName).equals("json")){
            processJSON(fileName);                
        }
        else if (extension(fileName).equals("txt")){
            processTXT(fileName);                
        }
        else{
            throw new DataLoadException("Format not supported:"+extension(fileName));
        }
        
        /*
            DATA PROCESSING CORE
        */
        LOG.info("Processing data...");
        LOG.info("Done. Execution finished.");
    }
    
    public String extension(String fileName){
        return FilenameUtils.getExtension(fileName);
    }
    
    private static final Logger LOG = Logger.getLogger(DataProcessor.class.getName());
    
    private void processCSV(String fileName) {
        LOG.info("Processing CVS...");
    }

    private void processJSON(String fileName) {
        LOG.info("Processing JSON file...");
    }

    private void processXML(String fileName) {
        LOG.info("Processing XML...");
    }

    private void processTXT(String fileName) {
        LOG.info("Processing TXT...");
    }

}


