package kauedy.habitBoot.exception;

import lombok.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private String message;
    private Integer status;
    private String extra;

}
