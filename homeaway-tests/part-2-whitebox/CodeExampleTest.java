package com.homeaway.whitebox;

import java.util.ArrayList;

import org.testng.annotations.Test;
//This class has tests to find issues in the production code 
public class CodeExampleTest {
	@Test
	// Negative testcase1 - user is not same as recipient and user does
	// not have the permission to modify recipients 
	// Expected Result - It should return all the messages as failed messages
	public void TestAddRecipients1() {
		User user = new User("MOA");
		user.setHasPermissonToModifyRecipients(false);
		Message goodMessage = new Message("Test 1");
		Message badMessage = new Message("Test 2");
		goodMessage.setAddRecipientAllowed(user, true);
		badMessage.setAddRecipientAllowed(user, true);
		ArrayList<Message> messages = new ArrayList<Message>();
		messages.add(goodMessage);
		messages.add(badMessage);
		CodeExample ce = new CodeExample();
		User recipient = new User("admin");
		ArrayList<Message> failedMessages = ce.addRecipientToAllMessages(
				messages, user, recipient);
		assertEquals(failedMessages.size(), 2);
	}

	@Test
	// Negative testcase2 - User is same as recipient and user
	// have the permissions to modify recipients and user has addrecipient allowed
	// Expected Result - All are successful messages and recipient should be added
	public void TestAddRecipients2() {
		User user = new User("MOA");
		user.setHasPermissonToModifyRecipients(true);
		Message Message1 = new Message("Test 1");
		Message Message2 = new Message("Test 2");
		goodMessage.setAddRecipientAllowed(user, true);
		badMessage.setAddRecipientAllowed(user, true);
		ArrayList<Message> messages = new ArrayList<Message>();
		messages.add(Message1);
		messages.add(Message2);
		CodeExample ce = new CodeExample();
		User recipient = new User("MOA");
		ArrayList<Message> successfulMessages = ce.addRecipientToAllMessages(
				messages, user, recipient);
		asserttrue(successfulMessages.get(1).recipient.equals("MOA"));
	}

	@Test
	// Negative testcase - User is same as recipient but user does not have
	// the permissions to modify recipients
	// Expected Result - It should not allow the user to modify and fail all the messages
	public void TestAddRecipients3() {
		User user = new User("MOA");
		user.setHasPermissonToModifyRecipients(false);
		Message goodMessage = new Message("Test 1");
		Message badMessage = new Message("Test 2");
		ArrayList<Message> messages = new ArrayList<Message>();
		messages.add(goodMessage);
		messages.add(badMessage);
		goodMessage.setAddRecipientAllowed(user, true);
		badMessage.setAddRecipientAllowed(user, true);
		CodeExample ce = new CodeExample();
		User recipient = new User("MOA");
		ArrayList<Message> failedMessages = ce.addRecipientToAllMessages(
				messages, user, recipient);
		assertEquals(failedMessages.size(), 2);
	}

}
