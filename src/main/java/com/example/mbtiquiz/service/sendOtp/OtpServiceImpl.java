package com.example.mbtiquiz.service.sendOtp;

import com.example.mbtiquiz.config.OtpProperties;
import com.example.mbtiquiz.model.sendOtp.SendOtpRequest;
import com.example.mbtiquiz.model.sendOtp.SendOtpResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final JavaMailSender mailSender;
    private final OtpProperties otpProperties;

    private static final String SUBJECT = "Your OTP for TalkBuddy Verification";

    @Override
    public SendOtpResponse sendOtp(SendOtpRequest request) {
        String otp = generateOtp(otpProperties.getLength());

        try {
            sendEmail(request.getEmail(), request.getName(), otp);
            return new SendOtpResponse(otp, "OTP sent successfully.");
        } catch (MessagingException e) {
            return new SendOtpResponse(null, "Failed to send OTP: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateOtp(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10)); // 0–9
        }
        return otp.toString();
    }

    private void sendEmail(String to, String name, String otp) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String htmlContent = "<p>Hello <b>" + name + "</b>,</p>"
                + "<p>Your OTP for TalkBuddy verification is:</p>"
                + "<h2>" + otp + "</h2>"
                + "<p>This OTP is valid for " + otpProperties.getExpiryMinutes() + " minutes.</p>";

        helper.setTo(to);
        helper.setSubject(SUBJECT);
        helper.setText(htmlContent, true); // HTML content
        helper.setFrom("talkbuddyotp@gmail.com", "TalkBuddy");

        mailSender.send(message);
    }
}
