package jp.harujioh.endian;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * ビッグエンディアンutilクラス
 * 
 * @author rhirata
 */
public class BigEndianUtil {

	/**
	 * short値のバッファを取得
	 * 
	 * @param value
	 *            値
	 * @return バッファ
	 */
	public static int[] getShortBuffer(short value) {
		return EndianUtil.getBuffer(ByteBuffer.allocate(Short.BYTES).order(ByteOrder.BIG_ENDIAN).putShort(value));
	}

	/**
	 * バッファからshort値を取得
	 * 
	 * @param buffer
	 * @return
	 */
	public static short getShort(int[] buffer) {
		return getShort(buffer, 0);
	}

	/**
	 * バッファからshort値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @return
	 */
	public static short getShort(int[] buffer, int offset) {
		return getShort(buffer, offset, Short.BYTES);
	}

	/**
	 * バッファからshort値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @pram length
	 * @return
	 */
	public static short getShort(int[] buffer, int offset, int length) {
		return EndianUtil.createByteBuffer(ByteOrder.BIG_ENDIAN, buffer, offset, length, Short.BYTES).getShort(0);
	}

	/**
	 * int値のバッファを取得
	 * 
	 * @param value
	 *            値
	 * @return バッファ
	 */
	public static int[] getIntBuffer(int value) {
		return EndianUtil.getBuffer(ByteBuffer.allocate(Integer.BYTES).order(ByteOrder.BIG_ENDIAN).putInt(value));
	}

	/**
	 * バッファからint値を取得
	 * 
	 * @param buffer
	 * @return
	 */
	public static int getInt(int[] buffer) {
		return getInt(buffer, 0);
	}

	/**
	 * バッファからint値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @return
	 */
	public static int getInt(int[] buffer, int offset) {
		return getInt(buffer, offset, Integer.BYTES);
	}

	/**
	 * バッファからint値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @pram length
	 * @return
	 */
	public static int getInt(int[] buffer, int offset, int length) {
		return EndianUtil.createByteBuffer(ByteOrder.BIG_ENDIAN, buffer, offset, length, Integer.BYTES).getInt(0);
	}

	/**
	 * long値のバッファを取得
	 * 
	 * @param value
	 *            値
	 * @return バッファ
	 */
	public static int[] getLongBuffer(long value) {
		return EndianUtil.getBuffer(ByteBuffer.allocate(Long.BYTES).order(ByteOrder.BIG_ENDIAN).putLong(value));
	}

	/**
	 * バッファからlong値を取得
	 * 
	 * @param buffer
	 * @return
	 */
	public static long getLong(int[] buffer) {
		return getLong(buffer, 0);
	}

	/**
	 * バッファからlong値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @return
	 */
	public static long getLong(int[] buffer, int offset) {
		return getLong(buffer, offset, Long.BYTES);
	}

	/**
	 * バッファからlong値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @pram length
	 * @return
	 */
	public static long getLong(int[] buffer, int offset, int length) {
		return EndianUtil.createByteBuffer(ByteOrder.BIG_ENDIAN, buffer, offset, length, Long.BYTES).getLong(0);
	}

	/**
	 * float値のバッファを取得
	 * 
	 * @param value
	 *            値
	 * @return バッファ
	 */
	public static int[] getFloatBuffer(float value) {
		return EndianUtil.getBuffer(ByteBuffer.allocate(Float.BYTES).order(ByteOrder.BIG_ENDIAN).putFloat(value));
	}

	/**
	 * バッファからfloat値を取得
	 * 
	 * @param buffer
	 * @return
	 */
	public static float getFloat(int[] buffer) {
		return getFloat(buffer, 0);
	}

	/**
	 * バッファからfloat値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @return
	 */
	public static float getFloat(int[] buffer, int offset) {
		return getFloat(buffer, offset, Float.BYTES);
	}

	/**
	 * バッファからfloat値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @pram length
	 * @return
	 */
	public static float getFloat(int[] buffer, int offset, int length) {
		return EndianUtil.createByteBuffer(ByteOrder.BIG_ENDIAN, buffer, offset, length, Float.BYTES).getFloat(0);
	}

	/**
	 * double値のバッファを取得
	 * 
	 * @param value
	 *            値
	 * @return バッファ
	 */
	public static int[] getDoubleBuffer(double value) {
		return EndianUtil.getBuffer(ByteBuffer.allocate(Double.BYTES).order(ByteOrder.BIG_ENDIAN).putDouble(value));
	}

	/**
	 * バッファからdouble値を取得
	 * 
	 * @param buffer
	 * @return
	 */
	public static double getDouble(int[] buffer) {
		return getDouble(buffer, 0);
	}

	/**
	 * バッファからdouble値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @return
	 */
	public static double getDouble(int[] buffer, int offset) {
		return getDouble(buffer, offset, Double.BYTES);
	}

	/**
	 * バッファからdouble値を取得
	 * 
	 * @param buffer
	 * @param offset
	 * @pram length
	 * @return
	 */
	public static double getDouble(int[] buffer, int offset, int length) {
		return EndianUtil.createByteBuffer(ByteOrder.BIG_ENDIAN, buffer, offset, length, Double.BYTES).getDouble(0);
	}
}
