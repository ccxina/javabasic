package online.cx.javabasic.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Document(collection = "demo")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Demo implements Serializable {

    @Id
    private Long id;

    private String title;

    private Date date;

    private Integer num;

    private Double price;

    private String type;
}
