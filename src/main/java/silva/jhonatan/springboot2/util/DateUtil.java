package silva.jhonatan.springboot2.util;

import org.springframework.stereotype.Component;

/**
 * Component é uma anotação que transforma a classe em spring bean
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
