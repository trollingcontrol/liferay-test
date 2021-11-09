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
        private final int totalEntriesAmount;
        private final int skippedEntries;

        public ResultEntry(int totalEntriesAmount, int skippedEntries) {
            this.totalEntriesAmount = totalEntriesAmount;
            this.skippedEntries = skippedEntries;
        }

        public int getTotalEntriesAmount() {
            return totalEntriesAmount;
        }

        public int getSkippedEntries() {
            return skippedEntries;
        }
    }
}
