package com.trollingcont.importziportlet.portlet;

public class EntryDescriptor {

    private final CsvListWriter writer;
    private final String zipEntryName;
    private final String entryNameToDisplay;

    public EntryDescriptor(
            CsvListWriter writer,
            String zipEntryName,
            String entryNameToDisplay
    ) {
        this.writer = writer;
        this.zipEntryName = zipEntryName;
        this.entryNameToDisplay = entryNameToDisplay;
    }

    public CsvListWriter getWriter() {
        return writer;
    }

    public String getZipEntryName() {
        return zipEntryName;
    }

    public String getEntryNameToDisplay() {
        return entryNameToDisplay;
    }
}
