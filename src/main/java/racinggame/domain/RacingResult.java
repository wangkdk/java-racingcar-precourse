package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<String> reports;

    public RacingResult() {
        this.reports = new ArrayList<>();
    }

    public void addReport(String report) {
        reports.add(report);
    }

    public List<String> getReports() {
        return reports;
    }
}
