package com.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.util.Date;

/**
 * @author xsyz
 * @created 2020-12-09   16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Component
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Date birth;
}
