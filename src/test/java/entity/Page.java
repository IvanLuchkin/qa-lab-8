package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import serialization.ZonedDateTimeDeserializer;
import serialization.ZonedDateTimeSerializer;

@Data
@AllArgsConstructor
public class Page {
    private Long id;
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime createdAt;
    private String name;
    private String pageUrl;

    public Page(ZonedDateTime createdAt, String name, String pageUrl) {
        new Page(-1L, createdAt, name, pageUrl);
    }
}
