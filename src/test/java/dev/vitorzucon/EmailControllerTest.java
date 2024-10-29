package dev.vitorzucon;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import dev.vitorzucon.email_boot.Email;
import dev.vitorzucon.email_boot.EmailBootApplication;
import dev.vitorzucon.email_boot.EmailController;
import dev.vitorzucon.email_boot.EmailService;

@SpringBootTest(classes = EmailBootApplication.class)
@TestPropertySource(properties = {
        "MT_HOST=sandbox.smtp.mailtrap.io",
        "MT_PORT=2525",
        "MT_USER=1ac6573a245dea",
        "MU_PWD=35e7d6ed2146d1"
})
class EmailControllerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmailController emailController;

    public EmailControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmail() {
        Email email = new Email("teste@example.com", "Testando Email", "Corpo do email");

        emailController.sendEmail(email);

        verify(emailService, times(1)).sendEmail(email);
    }
}
