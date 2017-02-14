/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.disease;

/**
 *
 * @author zack
 */
public class DiseaseSample {
    
    private int id;
    private String sequence;
    private String countryCode;
    private String geographicArea;
    private String referenceDate;
    private String populationSubgroup;
    private String subpopCode;
    private String sex;
    private String age;
    private String sourceID;
    private String comments;
    private String dataType;
    private String country;
    private String siteName;
    private String author;
    private String year;
    private String title;
    private String info;
    private String virusType;
    private String nocase;
    private String nodeath;
    private String prev_rate;
    private String inc_rate;
    private String specimenType;
    private String testType;
    private String samplesize;
    
    private static int count = 1;
    
    public DiseaseSample(String[] row){
//        System.out.println(row.length);
//        for(int i = 0; i < row.length;i++){
//            System.out.println(row[i]);
//        }
        id = count++;
        sequence = row[0];
        countryCode = row[1];
        geographicArea = row[2];
        referenceDate = row[3];
        populationSubgroup = row[4];
        subpopCode = row[5];
        sex = row[6];
        age = row[7];
        sourceID = row[8];
        comments = row[9];
        dataType = row[10];
        country = row[11];
        siteName = row[12];
        author = row[13];
        year = row[14];
        title = row[15];
        info = row[16];
        virusType = row[17];
        nocase = row[18];
        nodeath = row[19];
        prev_rate = row[20];
        inc_rate = row[21];
        specimenType = row[22];
        testType = row[23];
        samplesize = row[24];
    }

    public int getId() {
        return id;
    }

    
    
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getGeographicArea() {
        return geographicArea;
    }

    public void setGeographicArea(String geographicArea) {
        this.geographicArea = geographicArea;
    }

    public String getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getPopulationSubgroup() {
        return populationSubgroup;
    }

    public void setPopulationSubgroup(String populationSubgroup) {
        this.populationSubgroup = populationSubgroup;
    }

    public String getSubpopCode() {
        return subpopCode;
    }

    public void setSubpopCode(String subpopCode) {
        this.subpopCode = subpopCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVirusType() {
        return virusType;
    }

    public void setVirusType(String virusType) {
        this.virusType = virusType;
    }

    public String getNocase() {
        return nocase;
    }

    public void setNocase(String nocase) {
        this.nocase = nocase;
    }

    public String getNodeath() {
        return nodeath;
    }

    public void setNodeath(String nodeath) {
        this.nodeath = nodeath;
    }

    public String getPrev_rate() {
        return prev_rate;
    }

    public void setPrev_rate(String prev_rate) {
        this.prev_rate = prev_rate;
    }

    public String getInc_rate() {
        return inc_rate;
    }

    public void setInc_rate(String inc_rate) {
        this.inc_rate = inc_rate;
    }

    public String getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getSamplesize() {
        return samplesize;
    }

    public void setSamplesize(String samplesize) {
        this.samplesize = samplesize;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        DiseaseSample.count = count;
    }
    
    
}
