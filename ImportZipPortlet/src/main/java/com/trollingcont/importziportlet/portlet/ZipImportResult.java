package com.trollingcont.importziportlet.portlet;

import java.util.ArrayList;
import java.util.List;

public class ZipImportResult {

    private final List<ResultEntry> resultEntries = new ArrayList<>();

    public void addResultEntry(ResultEntry resultEntry) {
        resultEntries.add(resultEntry);
    }

    public List<ResultEntry> getResultEntries() {
        return resultEntries;
    }

    public static class ResultEntry {
        private final String entryName;
        private final int totalEntriesAmount;
        private final int skippedEntries;

        public ResultEntry(String entryName, int totalEntriesAmount, int skippedEntries) {
            this.entryName = entryName;
            this.totalEntriesAmount = totalEntriesAmount;
            this.skippedEntries = skippedEntries;
        }

        public String getEntryName() { return entryName; }

        public int getTotalEntriesAmount() {
            return totalEntriesAmount;
        }

        public int getSkippedEntries() {
            return skippedEntries;
        }
    }
}
