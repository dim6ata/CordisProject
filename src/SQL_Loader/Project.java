/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_Loader;

/**
 * Generic class to create Project object for further analysis
 * @author Michal Dioszegi
 * w1703164
 */
public class Project 
{
    int projectRcn;
    int projectID;
    String projectAcronym;
    String projectTitle;
    String projectStatus;
    String projectStartDate;
    String projectEndDate;
    String projectUrl;
    int projectTotalCost;
    int ecMaxContribution;
    int topicID;
    String ecCode;
    String callID;
    
    String countryName;

    /**
     * missing projectObjective - would be null, skip by index
     * @param projectRcn
     * @param projectID
     * @param projectAcronym
     * @param projectTitle
     * @param projectStatus
     * @param projectStartDate
     * @param projectEndDate
     * @param projectUrl
     * @param projectTotalCost
     * @param ecMaxContribution
     * @param topicID
     * @param ecCode
     * @param callID 
     */
    public Project(int projectRcn, int projectID, String projectAcronym, String projectTitle, String projectStatus, String projectStartDate, String projectEndDate, String projectUrl, int projectTotalCost, int ecMaxContribution, int topicID, String ecCode, String callID) {
        this.projectRcn = projectRcn;
        this.projectID = projectID;
        this.projectAcronym = projectAcronym;
        this.projectTitle = projectTitle;
        this.projectStatus = projectStatus;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectUrl = projectUrl;
        this.projectTotalCost = projectTotalCost;
        this.ecMaxContribution = ecMaxContribution;
        this.topicID = topicID;
        this.ecCode = ecCode;
        this.callID = callID;
    }

    public Project(int projectID, String projectStartDate, int projectTotalCost)
    {
        this.projectID = projectID;
        this.projectStartDate = projectStartDate;
        this.projectTotalCost = projectTotalCost;
    }
    
    public Project(int projectID, String countryName)
    {
        this.projectID = projectID;
        this.countryName = countryName;
    }
    
    public void setProjectRcn(int projectRcn) {
        this.projectRcn = projectRcn;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setProjectAcronym(String projectAcronym) {
        this.projectAcronym = projectAcronym;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public void setProjectTotalCost(int projectTotalCost) {
        this.projectTotalCost = projectTotalCost;
    }

    public void setEcMaxContribution(int ecMaxContribution) {
        this.ecMaxContribution = ecMaxContribution;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public void setEcCode(String ecCode) {
        this.ecCode = ecCode;
    }

    public void setCallID(String callID) {
        this.callID = callID;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getProjectRcn() {
        return projectRcn;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getProjectAcronym() {
        return projectAcronym;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public int getProjectTotalCost() {
        return projectTotalCost;
    }

    public int getEcMaxContribution() {
        return ecMaxContribution;
    }

    public int getTopicID() {
        return topicID;
    }

    public String getEcCode() {
        return ecCode;
    }

    public String getCallID() {
        return callID;
    }

    @Override
    public String toString() {
        return "Project{" + "projectRcn=" + projectRcn + ", projectID=" + projectID + ", projectAcronym=" + projectAcronym + ", projectTitle=" + projectTitle + ", projectStatus=" + projectStatus + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate + ", projectUrl=" + projectUrl + ", projectTotalCost=" + projectTotalCost + ", ecMaxContribution=" + ecMaxContribution + ", topicID=" + topicID + ", ecCode=" + ecCode + ", callID=" + callID + '}';
    }
    
    
    
    
}
