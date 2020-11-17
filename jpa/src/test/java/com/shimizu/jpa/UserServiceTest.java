//package com.shimizu.jpa;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.io.PipedReader;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@ActiveProfiles("junit")
//@Disabled
//public class UserServiceTest {
//
//    @Autowired
//    private AuthorRepo authorRepo;
//
//    @Autowired
//    private AuthorService authorService;
//
//    @Test
//    void notNull() {
//        assertThat(authorRepo).isNotNull();
//        assertThat(authorService).isNotNull();
//    }
//
//
//    @TestConfiguration
//    static class TestConfig {
//
//        /**
//         * 若测试不需要可以使用 MockBean
//         */
//        @MockBean
//        private UserRepo userRepo;
//
//        @Bean
//        public AuthorService authorService(AuthorRepo authorRepo) {
//            return new AuthorService(authorRepo, userRepo);
//        }
//    }
//}
