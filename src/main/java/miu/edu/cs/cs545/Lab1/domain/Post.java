package miu.edu.cs.cs545.Lab1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String title;
   private String content;
   private String author;

   @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "post")
   private Collection<Comment> comments;

}
