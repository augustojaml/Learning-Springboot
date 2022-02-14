package com.springboot.nelioalvesmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springboot.nelioalvesmongodb.dto.AuthorDTO;
import com.springboot.nelioalvesmongodb.dto.CommentDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "posts")
public class Post implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @EqualsAndHashCode.Include
  private String id;

  private Date date;

  private String title;

  private String body;

  private AuthorDTO author;

  private List<CommentDTO> comments = new ArrayList<>();

  public Post(String id, Date date, String title, String body, AuthorDTO author) {
    super();
    this.id = id;
    this.date = date;
    this.title = title;
    this.body = body;
    this.author = author;
  }

}
