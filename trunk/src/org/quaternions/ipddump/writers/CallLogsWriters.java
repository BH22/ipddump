/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package org.quaternions.ipddump.writers;

//~--- non-JDK imports --------------------------------------------------------

import org.dom4j.*;

import org.quaternions.ipddump.data.CallLog;
import org.quaternions.ipddump.data.InteractivePagerBackup;

/**
 *
 * @author Jimmys Daskalakis - jimdaskalakis01@gmail.com
 */
public class CallLogsWriters extends BasicWriter {
    public CallLogsWriters(InteractivePagerBackup database) {
        super(database);
    }

    //~--- get methods --------------------------------------------------------

    /**
     * Returns the total of the CallLog messages
     *
     *
     * @return
     */
    public int getSize() {
        if (database!=null) {
            return database.callLogs().size();
        } else {
            return 0;
        }
    }

    //~--- methods ------------------------------------------------------------

    /**
     * Get the cvs of the parsed CallLog's
     *
     *
     * @return
     */
    public String toCSV(int[] selectedCallLogs) {
        StringBuilder temp=new StringBuilder();    // fast builder!!

        temp.delete(0, temp.capacity());
        temp.append("Name,Duration,Status,Date,Number\n");

        int RecordIndex=0;
        int j          =0;

        for (CallLog record : database.callLogs()) {
            if ((RecordIndex==selectedCallLogs[j]) && (selectedCallLogs[j]<database.callLogs().size())) {
                temp.append(record.getName()+","+record.getDuration()+","+record.getStatus()+","
                            +record.getDate().toString()+","+record.getNumber()+"\n");
                j++;

                if (j>=selectedCallLogs.length) {
                    break;
                }
            }

            RecordIndex++;
        }

        return temp.toString();
    }

    /**
     * Get a represantation of the parsed CallLog's
     * in plain text
     *
     *
     * @param database
     * @param CallLogselectedRows
     *
     * @return
     */
    public String toPlainText(int[] CallLogselectedRows) {
        StringBuilder tmp=new StringBuilder();

        if (database!=null) {
            int RecordIndex=0;
            int j          =0;

            for (CallLog record : database.callLogs()) {
                if ((RecordIndex==CallLogselectedRows[j]) && (CallLogselectedRows[j]<database.callLogs().size())) {
                    tmp.append(record.getNameAndNumber()+"\nStatus: "+record.getStatus()+"\nDate: "+record.getDate()
                               +"\nDuration: "+record.getDuration().toString()+"\n\n");
                    j++;

                    if (j>=CallLogselectedRows.length) {
                        break;
                    }
                }

                RecordIndex++;
            }

            return tmp.toString();
        }

        return tmp.toString();
    }

    /**
     * Get the XML of the parsed CallLog's
     *
     * @param database
     * @param selectedCallLogs
     *
     * @return
     */
    public Document toXML(int[] selectedCallLogs) {
        Document document=DocumentHelper.createDocument();

        // Add the root
        Element root=document.addElement("CallLogs").addAttribute("TotalCallLogs",
                                         String.valueOf(selectedCallLogs.length));
        int RecordIndex=0;
        int j          =0;

        for (CallLog record : database.callLogs()) {
            if ((RecordIndex==selectedCallLogs[j]) && (selectedCallLogs[j]<database.callLogs().size())) {
                Element message=root.addElement("CallLog").addAttribute("UID", String.valueOf(record.getUID()));

                message.addElement("Name").addText(record.getName());
                message.addElement("Date").addText(record.getDate().toString());
                message.addElement("Status").addText(record.getStatus());
                message.addElement("Duration").addText(record.getDuration());
                message.addElement("Number").addText(record.getNumber());
                j++;

                if (j>=selectedCallLogs.length) {
                    break;
                }
            }

            RecordIndex++;
        }

        return createPrettyPrint(document);
    }
}
