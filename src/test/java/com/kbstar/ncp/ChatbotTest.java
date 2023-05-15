package com.kbstar.ncp;
import com.kbstar.util.ChatBotUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class ChatbotTest {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Test
    void contextLoads() throws Exception {
            String txt = "채팅하자";
            String result = ChatBotUtil.chat(txt);
            log.info("===================="+result);

    }
}