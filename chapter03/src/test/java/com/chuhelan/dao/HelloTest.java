import com.chuhelan.dao.Hello;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
class HelloTest {
    @Autowired
    Hello hello;

    @Test
    void sayHello() {
        System.out.println(hello.sayHello());
    }
}
