package cordismain;

/**
 * Class that represents user's session details.
 * It is used as a data structure to retrieve session data from database and setup rows in Admin panel table.
 *
 * @author dim6ata
 */
public class SessionDetails {

    private String dateTimeIn;
    private String dateTimeOut;
    private int sessionID;

    public String getDateTimeIn() {
        return dateTimeIn;
    }

    public void setDateTimeIn(String dIn) {

        this.dateTimeIn = dIn.replaceAll("T", " ");

    }

    public String getDateTimeOut() {
        return dateTimeOut;
    }

    public void setDateTimeOut(String dOut) {

        if (dOut == null) {

            this.dateTimeOut = "N/A";
        } else {
            this.dateTimeOut = dOut.replaceAll("T", " ");
        }
    }

    @Override
    public String toString() {

        return "\nSession Details{" + "\nSESSION ID" + sessionID + "\nLOGIN TIME" + dateTimeIn + "\nLOGOUT TIME" + dateTimeOut;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

}
