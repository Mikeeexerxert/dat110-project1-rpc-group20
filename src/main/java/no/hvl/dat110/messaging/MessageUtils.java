package no.hvl.dat110.messaging;
public class MessageUtils {
	public static final int SEGMENTSIZE = 128;
	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";
	public static byte[] encapsulate(Message message) {
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		segment[0] = (byte) data.length;
		System.arraycopy(data, 0, segment, 1, data.length);
		return segment;
	}
	public static Message decapsulate(byte[] segment) {
		int	length = segment[0];
		byte[] data = new byte[length];
		System.arraycopy(segment, 1, data, 0, length);
		return new Message(data);
	}
}
