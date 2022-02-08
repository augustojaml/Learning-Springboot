package com.springboot.nelioalves.services;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.springboot.nelioalves.exceptions.ServiceFileException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

  public BufferedImage getJpgImageFromFile(MultipartFile uploadedFile) {
    String extension = FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
    if (!"png".equals(extension) && !"jpg".equals(extension)) {
      throw new ServiceFileException("Only PNG and JPG images are allowed");
    }

    try {
      BufferedImage image = ImageIO.read(uploadedFile.getInputStream());
      if ("png".equals(extension)) {
        image = pngToJpg(image);
      }
      return image;
    } catch (IOException e) {
      throw new ServiceFileException("Erro ao ler arquivo");
    }
  }

  public BufferedImage pngToJpg(BufferedImage img) {
    BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(),
        BufferedImage.TYPE_INT_RGB);
    jpgImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
    return jpgImage;
  }

  public InputStream getInputStream(BufferedImage image, String extension) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ImageIO.write(image, extension, byteArrayOutputStream);
      return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    } catch (IOException e) {
      throw new ServiceFileException("Erro ao ler arquivo");
    }
  }
  // public BufferedImage cropSquare(BufferedImage sourceImg) {
  // int min = (sourceImg.getHeight() <= sourceImg.getWidth()) ?
  // sourceImg.getHeight() : sourceImg.getWidth();
  // return Scalr.crop(
  // sourceImg,
  // (sourceImg.getWidth() / 2) - (min / 2),
  // (sourceImg.getHeight() / 2) - (min / 2),
  // min,
  // min);
  // }

  // public BufferedImage resize(BufferedImage sourceImg, int size) {
  // return Scalr.resize(sourceImg, Scalr.Method.ULTRA_QUALITY, size);
  // }
}
