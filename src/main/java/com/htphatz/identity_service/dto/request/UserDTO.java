package com.htphatz.identity_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    String username;
    String password;
    String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date dateOfBirth;
}
