package tutoriales.rabbitmq.spring;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Receiver {
    public static final String RECEIVE_METHOD_NAME = "receiveMessage";

    public void receiveMessage(String message) {
        System.out.println("[Receiver] ha recibido el mensaje \"" + message + '"');
    }

    public void receiveMessage(byte[] message) throws UnsupportedEncodingException {
        String decodedMessage = new String(message, StandardCharsets.UTF_8);
        System.out.println("[Receiver] ha recibido el mensaje \"" + decodedMessage + '"');
    }
}
