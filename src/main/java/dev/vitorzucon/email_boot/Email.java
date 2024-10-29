package dev.vitorzucon.email_boot;

public record Email(
        String to,
        String subject,
        String body
) {
}
