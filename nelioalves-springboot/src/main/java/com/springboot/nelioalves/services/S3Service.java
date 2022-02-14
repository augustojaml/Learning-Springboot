package com.springboot.nelioalves.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.springboot.nelioalves.exceptions.ServiceFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service {

  private Logger LOG = LoggerFactory.getLogger(S3Service.class);

  @Autowired
  private AmazonS3 s3client;

  @Value("${s3.bucket}")
  private String bucketName;

  public URI uploadFile(MultipartFile multipartFile) {
    try {
      String fileName = multipartFile.getOriginalFilename();
      InputStream inputStream = multipartFile.getInputStream();
      String contentType = multipartFile.getContentType();
      return uploadFile(inputStream, fileName, contentType);
    } catch (IOException e) {
      throw new ServiceFileException("Error of IO: " + e.getMessage());
    }
  }

  public URI uploadFile(InputStream inputStream, String fileName, String contentType) {
    try {
      ObjectMetadata meta = new ObjectMetadata();
      meta.setContentType(contentType);
      LOG.info("Starting upload");
      s3client.putObject(bucketName, fileName, inputStream, meta);
      LOG.info("Upload finalizing");
      return s3client.getUrl(bucketName, fileName).toURI();
    } catch (URISyntaxException e) {
      throw new ServiceFileException("Error converting URL to URI");
    }
  }

  // public void uploadFile(String localFilePath) {
  // try {
  // File file = new File(localFilePath);
  // LOG.info("Started upload");
  // s3client.putObject(new PutObjectRequest(bucketName, "image.jpg", file));
  // LOG.info("Finished upload");
  // } catch (AmazonServiceException e) {
  // LOG.info("AmazonServiceException error : " + e.getErrorMessage());
  // LOG.info("AmazonServiceException code : " + e.getErrorCode());
  // } catch (AmazonClientException e) {
  // LOG.info("AmazonClientException error : " + e.getMessage());
  // }
  // }
}
