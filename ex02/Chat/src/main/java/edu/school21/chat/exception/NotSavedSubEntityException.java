package edu.school21.chat.exception;

    public class NotSavedSubEntityException extends RuntimeException {

        @Override
        public void printStackTrace() { System.out.println("Error: impossible to save the message"); }
}