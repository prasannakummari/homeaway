package com.homeaway.whitebox;

import java.util.ArrayList;

import com.sun.jna.platform.win32.Netapi32Util.User;

//Please see below for the comments where there are logical errors
public class CodeExample {

	public ArrayList<Message> addRecipientToAllMessages(
			final ArrayList<Message> messages, final User currentUser,
			final User recipient) {
		ArrayList<Message> successfulMessages = new ArrayList<Message>();
		ArrayList<Message> failedMessages = new ArrayList<Message>();
		for (Message message : messages) {

			if (canReceiveMessage(message, currentUser, recipient)) {
				successfulMessages.add(message);
			} else {
				failedMessages.add(message);
			}
		}
		// It will never meet the condition and can never modify the
		// successful messages as below and can never add recipient.
		if (sucessfulMessages.isEmpty()) {
			recipientManager.addRecipient(currentUser, successfulMessages);
		}
		return failedMessages;
	}

	private boolean canReceiveMessage(Message message, User currentUser,
			User recipient) {
		// This condition should use && operator and if either of the conditions
		// are not matching then it should return false
		if (currentUser.equals(recipient)
				|| currentUser.getHasPermissionToModifyRecipients()) {
			return message.getAddRecipientAllowed(recipient);
		}
		return true; // It should return false if currentuser is not same as
		// recipient and does not have permissions to modify

	}

}
