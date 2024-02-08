package com.github.thecooldrop.todolist;


import com.github.thecooldrop.todolist.configuration.SecurityConfiguration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.org.apache.commons.lang3.ObjectUtils;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import(SecurityConfiguration.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class GetCallShouldReturn {

        @Test
        void whenNotAuthenticatedHttpStatusCode401AndEmptyResponse() throws Exception {
            mockMvc.perform(
                            get("/hello")
                    ).andExpect(status().isForbidden())
                    .andExpect(content().string(""));
        }

        @Test
        void whenAuthenticatedHttpStatusCode200AndResponseBodyHelloWorld() throws Exception {
            mockMvc.perform(
                    get("/hello")
                            .with(jwt())
            )
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hello World!"));
        }
    }
}
