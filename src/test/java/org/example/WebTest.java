package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = MainApp.class)
@AutoConfigureMockMvc
public class WebTest {

    @Autowired
    private AddressBookController addressBookController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception{
        assertThat(addressBookController).isNotNull();
    }

    @Test
    void GETTest() throws Exception {
        this.mockMvc.perform(get("/addressbook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Joe")))
                .andExpect(content().string(containsString("222-222-2222")));
    }

    @Test
    void POSTTest() throws Exception {
        this.mockMvc.perform(post("/addressbook").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content("name=Connor&phoneNumber=111-111-1111"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Connor")))
                .andExpect(content().string(containsString("111-111-1111")))
                .andExpect(content().string(containsString("Joe")))
                .andExpect(content().string(containsString("222-222-2222")));
    }
}
