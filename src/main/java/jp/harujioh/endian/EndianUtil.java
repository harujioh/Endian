package jp.harujioh.endian;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * エンディアンutilクラス
 * 
 * @author rhirata
 */
class EndianUtil {

	/**
	 * ByteBuffer作成
	 * 
	 * @param buffer
	 * @param offset
	 * @param length
	 * @param byteLength
	 * @return
	 */
	public static ByteBuffer createByteBuffer(int[] buffer, int offset, int length, int byteLength) {
		return createByteBuffer(ByteOrder.nativeOrder(), buffer, offset, length, byteLength);
	}

	/**
	 * ByteBuffer作成
	 * 
	 * @param order
	 * @param buffer
	 * @param offset
	 * @param length
	 * @param byteLength
	 * @return
	 */
	public static ByteBuffer createByteBuffer(ByteOrder order, int[] buffer, int offset, int length, int byteLength) {
		if (offset >= buffer.length || length < 0 || length > byteLength) {
			throw new IndexOutOfBoundsException(String.valueOf(length));
		}

		ByteBuffer byteBuffer = ByteBuffer.allocate(byteLength).order(order);
		int[] usingBuffer = Arrays.copyOfRange(buffer, offset, Math.min(offset + length, buffer.length));

		IntStream.range(0, byteBuffer.capacity()).forEach(i -> {
			if (i < byteLength - usingBuffer.length) {
				byteBuffer.put((byte) 0x00);
			} else {
				byteBuffer.put((byte) usingBuffer[i - (byteLength - usingBuffer.length)]);
			}
		});

		return byteBuffer;
	}

	/**
	 * ByteBufferからint[]型のバッファを返す
	 * 
	 * @param byteBuffer
	 * @return int[]型のバッファ
	 */
	public static int[] getBuffer(ByteBuffer byteBuffer) {
		byte[] buf = byteBuffer.array();
		return IntStream.range(0, buf.length) //
				.map(i -> buf[i] & 0xff) //
				.toArray();
	}
}
