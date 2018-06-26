package com;
import java.io.File;
import java.io.RandomAccessFile;
import com.opensymphony.xwork2.ActionSupport;
public class FileUploadAction extends ActionSupport {
  private String contentType;
  private File upload;
  private String fileName;
  private String caption;
  public String getUploadFileName() {
    return fileName;
  }

  public void setUploadFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getUploadContentType() {
    return contentType;
  }

  public void setUploadContentType(String contentType) {
    this.contentType = contentType;
  }

  public File getUpload() {
    return upload;
  }

  public void setUpload(File upload) {
    this.upload = upload;
  }


  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }
  @Override
  public String toString() {
      return contentType+"\t"+fileName+"\t"+caption;
  }
  @Override
  public String execute() throws Exception {
    System.out.println(this);
    
    return SUCCESS;
  }
}