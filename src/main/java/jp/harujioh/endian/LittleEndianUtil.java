package jp.harujioh.endian;

import java.nio.ByteOrder;

/**
 * リトルエンディアンutilクラス
 * 
 * @author rhirata
 */
public class LittleEndianUtil {

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
		return EndianUtil.createByteBuffer(ByteOrder.LITTLE_ENDIAN, buffer, offset, length, Short.BYTES).getShort(0);
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
		return EndianUtil.createByteBuffer(ByteOrder.LITTLE_ENDIAN, buffer, offset, length, Integer.BYTES).getInt(0);
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
		return EndianUtil.createByteBuffer(ByteOrder.LITTLE_ENDIAN, buffer, offset, length, Long.BYTES).getLong(0);
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
		return EndianUtil.createByteBuffer(ByteOrder.LITTLE_ENDIAN, buffer, offset, length, Float.BYTES).getFloat(0);
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
		return EndianUtil.createByteBuffer(ByteOrder.LITTLE_ENDIAN, buffer, offset, length, Double.BYTES).getDouble(0);
	}
}
