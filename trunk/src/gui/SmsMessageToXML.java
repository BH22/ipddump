/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package gui;

//~--- non-JDK imports --------------------------------------------------------

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import org.quaternions.ipddump.data.InteractivePagerBackup;
import org.quaternions.ipddump.data.SMSMessage;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jimmys Daskalakis
 */
public class SmsMessageToXML {

    /**
     * Parces the db to an xml document
     *
     *
     * @param database
     */
    public static Document createSmsMessageToXML(InteractivePagerBackup database) {
        String sSent="";

        // System.out.println("uid,sent,received,sent?,far number,text");
        Document document=DocumentHelper.createDocument();

        // Add the root
        Element root=document.addElement("SMSmessages").addAttribute("TotalSMS",
                                         String.valueOf(database.smsRecords().size()));

        // System.out.println("uid,sent,received,sent?,far number,text");
        for (SMSMessage record : database.smsRecords()) {
            if (record.wasSent()) {
                sSent="true";
            } else {
                sSent="false";
            }

//          System.out.println(record.getUID()+","+record.getSent()+","+record.getReceived()+","+record.wasSent()+","
//          +record.getNumber()+",\""+record.getText()+"\"");
            Element message=root.addElement("SmsMessage").addAttribute("UID", String.valueOf(record.getUID()));

            // Create the document
            // Add the "sentDate" element
            message.addElement("sentDate").addText(record.getSent().toString());

            // Add the "receivedDate" element
            message.addElement("receivedDate").addText(record.getReceived().toString());

            // Add the "sent?" element
            message.addElement("wasSent").addText(sSent);

            // Add the "to" element
            message.addElement("to").addText(record.getNumber());

            // Add the "text" element
            message.addElement("text").addText(record.getText()+"\n");
        }

        OutputFormat format=OutputFormat.createPrettyPrint();

        format.setEncoding("UTF-8");

        // format.setTrimText(true);
//      Save it
        XMLWriter    writer;
        StringWriter str=new StringWriter();

        writer=new XMLWriter(str, format);

        try {
            writer.write(document);
            writer.close();
            document=DocumentHelper.parseText(str.toString());
        } catch (IOException ex) {
            Logger.getLogger(SmsMessageToXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SmsMessageToXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        // System.out.println(document.getDocument().getText());
        return document;

        // root.addAttribute("DbID", String.valueOf(record.getDatabaseID()));
    }

    /**
     * Method description
     *
     *
     * @param database
     * @param selectedMessages
     *
     * @return
     */
    public static Document createSmsMessageToXML(InteractivePagerBackup database, int[] selectedMessages) {
        String sSent="";

        // System.out.println("uid,sent,received,sent?,far number,text");
        Document document=DocumentHelper.createDocument();

        // Add the root
        Element root=document.addElement("SMSmessages").addAttribute("TotalSMS",
                                         String.valueOf(selectedMessages.length));

        // System.out.println("uid,sent,received,sent?,far number,text");
        int smsRecord=0;
        int j        =0;

        for (SMSMessage record : database.smsRecords()) {
//            System.out.println(smsRecord+" "+j+" "+selectedMessages[j]);

            if ((smsRecord==selectedMessages[j]) && (selectedMessages[j]<database.smsRecords().size())) {
                if (record.wasSent()) {
                    sSent="true";
                } else {
                    sSent="false";
                }

//              System.out.println(record.getUID()+","+record.getSent()+","+record.getReceived()+","+record.wasSent()+","
//              +record.getNumber()+",\""+record.getText()+"\"");
                Element message=root.addElement("SmsMessage").addAttribute("UID", String.valueOf(record.getUID()));

                // Create the document
                // Add the "sentDate" element
                message.addElement("sentDate").addText(record.getSent().toString());

                // Add the "receivedDate" element
                message.addElement("receivedDate").addText(record.getReceived().toString());

                // Add the "sent?" element
                message.addElement("wasSent").addText(sSent);

                // Add the "to" element
                message.addElement("to").addText(record.getNumber());

                // Add the "text" element
                message.addElement("text").addText(record.getText()+"\n");
                j++;

                if (j>=selectedMessages.length) {
                    break;
                }
            }

            smsRecord++;
        }

        OutputFormat format=OutputFormat.createPrettyPrint();

        format.setEncoding("UTF-8");

        // format.setTrimText(true);
//      Save it
        XMLWriter    writer;
        StringWriter str=new StringWriter();

        writer=new XMLWriter(str, format);

        try {
            writer.write(document);
            writer.close();
            document=DocumentHelper.parseText(str.toString());
        } catch (IOException ex) {
            Logger.getLogger(SmsMessageToXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SmsMessageToXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        // System.out.println(document.getDocument().getText());
        return document;

        // root.addAttribute("DbID", String.valueOf(record.getDatabaseID()));
    }


}