package cordismain;

/**
 * Class that represents user's data usage.
 * It is used as a data structure to retrieve data usage data from database and setup rows in Admin panel tables.
 * 
 * @author dim6ata
 */
public class DataUsage {

    private int logId;
    private String activityName;
    private String timeStamp;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {

        this.timeStamp = timeStamp.replaceAll("T", " ");

    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public DataUsage() {
    }

    @Override
    public String toString() {
        return "\nDataUsage{" + "\nLOG ID=" + logId + ", \nactivityName=" + activityName + ", \ntimeStamp=" + timeStamp + '}';
    }

}
