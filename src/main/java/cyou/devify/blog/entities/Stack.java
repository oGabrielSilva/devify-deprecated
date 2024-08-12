package cyou.devify.blog.entities;

import com.google.cloud.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Stack {
    private String uid;
    private String name;
    private Content content;
    private String metaDescription;
    private Content description;
    private String createdBy;
    private String updatedBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
