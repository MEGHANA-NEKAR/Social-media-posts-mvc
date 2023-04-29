package com.springpoc.springpoc.Model;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {

    @Id
    @SequenceGenerator(name = "post_id_sequence", sequenceName = "post_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_sequence")
    private Integer postId;
    private String content;
    private String authorName;
  @CreationTimestamp
  private LocalDateTime createdTime;
}


