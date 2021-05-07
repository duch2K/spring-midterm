package iitu.midterm.demo.entities;

import iitu.midterm.demo.models.RequestStatusEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="requests")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "book_id")
    private Long bookId;
    @Enumerated(EnumType.STRING)
    private RequestStatusEnum status;
    private Date day;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

//    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<RequestItem> requestItems;
}
