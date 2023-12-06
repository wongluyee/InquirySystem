package util;

import java.util.Properties;
import java.util.Date;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class SendMail {

	public void sendEmail (String toEmail, String subject, String message) throws MessagingException {
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication("system.project.team01@kanda-it-school-system.com", "iisyAeByMearp4f");
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("system.project.team01@kanda-it-school-system.com", "神田英会話スクール", "iso-2022-jp"));

			// 送信先メールアドレスを指定
			mimeMessage.setRecipients(Message.RecipientType.TO, toEmail);

			// メールのタイトルを指定
			mimeMessage.setSubject(subject, "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(message, "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}
}
