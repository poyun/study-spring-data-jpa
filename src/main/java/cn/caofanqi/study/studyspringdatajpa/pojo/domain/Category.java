package cn.caofanqi.study.studyspringdatajpa.pojo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * 类别
 * @author caofanqi
 */
@Data
@Entity
@Builder
@Table(name = "jpa_category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String categoryName;

    /**
     * 门类和书是一对多的关系
     * 由多的一方来维护关联关系
     */
    @OneToMany(mappedBy = "category")
    @OrderBy("bookName DESC")
    private List<Book> books;

}