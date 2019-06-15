package com.sweng.notty.Modules;


import java.util.Locale;

public class MyFile {

    private String fileURL,
                    fileType,
                    uploadedBy,
                    date,
                    course,
                    finalName;

    public MyFile (String fileURL, String uploadedBy, String date, String course) {

        this.fileURL = fileURL;
        this.fileType = getExtension(fileURL);
        this.uploadedBy = uploadedBy;
        this.date = date;
        this.course = course;
        setFinalName(this.fileURL, this.uploadedBy, this.date, this.course);

    }

    private String getExtension (String fileURL) {

        if (fileURL.endsWith("pdf")) {
            return "pdf";
        } else if (fileURL.endsWith("jpg")) {
            return "jpg";
        } else if (fileURL.endsWith("jpeg")) {
            return "jpeg";
        } else if (fileURL.endsWith("png")) {
            return "png";
        } else if (fileURL.endsWith("doc")) {
            return "doc";
        } else if (fileURL.endsWith("docx")) {
            return "docx";
        } else {
            return "";
        }



    }


    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFinalName() {
        return finalName;
    }

    public void setFinalName(String finalName) {
        this.finalName = finalName;
    }

    private void setFinalName(String fileURL, String uploadedBy, String date, String course) {
        String ext = getExtension(fileURL);
        String temp = fileURL.substring(fileURL.lastIndexOf('/') + 1);
        temp = temp.substring(0, temp.lastIndexOf('.'));
        temp += "-" + uploadedBy + "-" + date + "-" + course;
        temp = temp.replaceAll("[^a-zA-Z\\d.]+", "-").replaceAll("[-]+", "-") + "." + ext;
        this.finalName = temp.toLowerCase(Locale.getDefault());
    }
}
