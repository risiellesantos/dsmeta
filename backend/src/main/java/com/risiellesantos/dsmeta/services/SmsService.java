package com.risiellesantos.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.risiellesantos.dsmeta.entities.Sales;
import com.risiellesantos.dsmeta.repositories.SalesRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SalesRepository salesRepository;

	public void sendSms(Long salesId) {
		
		Sales sales = salesRepository.findById(salesId).get();
		
		String date = sales.getDate().getMonthValue() + "/" + sales.getDate().getYear();
				 
		
		String msg = "O vendedor" + sales.getSellerName() + " foi destaque em " + date
				+ " com um total de R$" + String.format("%.2f", sales.getAmount()); //%.2f é a forma de formatar um numero com 2 casas

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}
